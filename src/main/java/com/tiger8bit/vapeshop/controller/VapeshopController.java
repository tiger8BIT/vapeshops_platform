package com.tiger8bit.vapeshop.controller;

import com.tiger8bit.vapeshop.model.*;
import com.tiger8bit.vapeshop.model.data.CityData;
import com.tiger8bit.vapeshop.service.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.mariadb.jdbc.internal.util.dao.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class VapeshopController {
    @Autowired
    private VapeshopService vapeshopService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;
    @Autowired
    private PhoneNumberService phoneNumberService;
    @Autowired
    private ContactLinkService contactLinkService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CommercialNetworkService commercialNetworkService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private ContactLinkTypeService contactLinkTypeService;
    @Autowired
    private SecurityService securityService;

    @GetMapping("/regions")
    @ResponseBody public ResponseEntity getRegions(@RequestParam Integer countryId) {
        Country country = countryService.findByID(countryId);
        List<CityData> cities = cityService.findCitiesByCountry(country)
                .stream().map(CityData::new).collect(Collectors.toList());
        log.info("response {}\n", cities);
        return ResponseEntity.status(HttpStatus.OK).body(cities);
    }

    @GetMapping("/prefix")
    @ResponseBody public ResponseEntity getPrefix(@RequestParam Integer countryId) {
        Country country = countryService.findByID(countryId);
        String prefix = country.getPhonePrefix();
        return ResponseEntity.status(HttpStatus.OK).body(prefix);
    }

    @GetMapping("info/vapeshop")
    public String getVapeshopInfoPage(@RequestParam("id") Integer id, Model model){
        Vapeshop vapeshop = vapeshopService.findByID(id.intValue());
        model.addAttribute("vapeshop", vapeshop);
        return "info/vapeshop";
    }
    @GetMapping("add/vapeshop")
    public String getVapeshopAddingPage(Model model){
        log.info("{}\n", countryService.findAll());
        model.addAttribute("countries", countryService.findAll());
        return "add/vapeshop";
    }
    @PostMapping("add/vapeshop/post")
    public String newVapeshop(@RequestParam List<String> images,
                              @RequestParam List<String> phonenumber,
                              @RequestParam String email,
                              @RequestParam String instagram,
                              @RequestParam String vk,
                              @RequestParam Integer cityId,
                              @RequestParam String addressInf,
                              Model model
    )
    {
        Address address = new Address();
        City city = cityService.findByID(cityId.intValue());
        address.setCity(city);
        address.setAddress(addressInf);
        addressService.save(address);
        CommercialNetwork commercialNetwork = commercialNetworkService.findByUsername(securityService.findLoggedInUsername());
        Vapeshop vapeshop = new Vapeshop();
        vapeshop.setCommercialNetwork(commercialNetwork);
        vapeshop.setAddress(address);
        vapeshop.setVepeshopImages(new LinkedList<>());
        images.forEach((value)-> {
            Image image = new Image();
            image.setUrl(value);
            imageService.save(image);
            vapeshop.getVepeshopImages().add(image);
        });
        vapeshopService.save(vapeshop);
        if (email != null) {
            contactLinkService.save(
                    new ContactLink(email, vapeshop, contactLinkTypeService.findByID(1)));
        }
        if (instagram != null) {
            contactLinkService.save(
                    new ContactLink(instagram, vapeshop, contactLinkTypeService.findByID(2)));
        }
        if (vk != null) {
            contactLinkService.save(
                    new ContactLink(vk, vapeshop, contactLinkTypeService.findByID(3)));
        }
        log.info("{}", phonenumber);
        phonenumber.forEach((v) -> {
            v = v.replaceAll("[+()-]", "");
            phoneNumberService.save(new PhoneNumber(v, vapeshop, address.getCity().getCountry()));
        });
        try {
            vapeshopService.save(vapeshop);
        } catch (Exception e) {
            Throwable couse = e.getCause();
            while(couse.getCause() != null) {
                couse = couse.getCause();
            }
            log.error(couse.getMessage());
            model.addAttribute("error", couse.getMessage());
            return "add/answer/error";
        }
       // int id = vapeshopService.addVapeshop(addressInf, cityId, 2, true);
        model.addAttribute("answer", "Магазин успешно добавлен");
        model.addAttribute("btntext", "Страница магазина");
        model.addAttribute("id", vapeshop.getId());
        model.addAttribute("path", "../../info/vapeshop");
        return "add/answer/success";
    }
}
