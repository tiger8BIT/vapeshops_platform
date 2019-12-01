package com.tiger8bit.vapeshop.controller;

import com.tiger8bit.vapeshop.model.*;
import com.tiger8bit.vapeshop.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    @RequestMapping(value = "/regions")
    @ResponseBody
    public List<City> getRegions(@RequestParam Long countryId) {
        Country country = countryService.findByID(countryId);
        List<City> cities = cityService.findCitiesByCountry(country);
        return cities;
    }
    @GetMapping("info/vapeshop")
    public String getVapeshopInfoPage(@RequestParam("id") Long id, Model model){
        Vapeshop vapeshop = vapeshopService.findByID(id.intValue());
        model.addAttribute("vapeshop", vapeshop);
        return "info/vapeshop";
    }
    @GetMapping("add/vapeshop")
    public String getVapeshopAddingPage(Model model){
        model.addAttribute("countries", countryService.findAll());
        return "add/vapeshop";
    }
    @PostMapping("add/vapeshop/post")
    public String newVapeshop(@RequestParam String phonenumber,
                              @RequestParam String phonenumber2,
                              @RequestParam String email,
                              @RequestParam String instagram,
                              @RequestParam String vk,
                              @RequestParam Long cityId,
                              @RequestParam String addressInf,
                              Model model
    )
    {
        Address address = new Address();
        City city = cityService.findByID(cityId.intValue());
        address.setCity(city);
        address.setAddress(addressInf);
        addressService.save(address);
        Vapeshop vapeshop = new Vapeshop();
        vapeshop.setAddress(address);
        vapeshopService.save(vapeshop);
        if (email != null)
            contactLinkService.save(new ContactLink(email, vapeshop));
        if (instagram != null)
            contactLinkService.save(new ContactLink(instagram, vapeshop));
        if (vk != null)
            contactLinkService.save(new ContactLink(vk, vapeshop));
        phoneNumberService.save(new PhoneNumber(phonenumber, vapeshop, address.getCity().getCountry()));
        phoneNumberService.save(new PhoneNumber(phonenumber2, vapeshop, address.getCity().getCountry()));
        log.info("{} is added",vapeshopService.save(vapeshop));
        model.addAttribute("answer", "Магазин успешно добавлен");
        model.addAttribute("id", vapeshop.getId());
        return "add/answer/success";
    }
}
