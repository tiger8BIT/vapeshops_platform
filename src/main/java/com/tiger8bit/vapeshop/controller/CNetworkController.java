package com.tiger8bit.vapeshop.controller;

import com.tiger8bit.vapeshop.model.*;
import com.tiger8bit.vapeshop.model.data.CityData;
import com.tiger8bit.vapeshop.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class CNetworkController {
    @Autowired
    private VapeshopService vapeshopService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CommercialNetworkService commercialNetworkService;

    @GetMapping("info/cnetwork")
    public String getCnetworkInfoPage(@RequestParam("id") Integer id, Model model){
        CommercialNetwork commercialNetwork = commercialNetworkService.findByID(id);
        model.addAttribute("cnetwork", commercialNetwork);
        return "info/cnetwork";
    }

    @GetMapping("private-office/cnetwork")
    public String getPersonalOfficePage(@RequestParam("id") Integer id, Model model){
        CommercialNetwork commercialNetwork = commercialNetworkService.findByID(id);
        model.addAttribute("cnetwork", commercialNetwork);
        return "private-office/cnetwork";
    }

    @GetMapping("update/cnetwork")
    public String getUpdateVapeshopPage(@RequestParam("id") Integer id, Model model){
        CommercialNetwork commercialNetwork = commercialNetworkService.findByID(id);
        model.addAttribute("cnetwork", commercialNetwork);
        model.addAttribute("btntext", "Изменить");
        return "add/cnetwork";
    }

    @GetMapping("add/cnetwork")
    public String getVapeshopAddingPage(Model model){
        model.addAttribute("btntext", "Добавить");
        return "add/cnetwork";
    }
    @PostMapping("add/cnetwork/post")
    public String newVapeshop(@RequestParam Integer id,
                              @RequestParam String logo,
                              @RequestParam String name,
                              @RequestParam String info,
                              Model model
    )
    {
        CommercialNetwork commercialNetwork =
                id == null ? new CommercialNetwork() : commercialNetworkService.findByID(id);
        commercialNetwork.setName(name);
        commercialNetwork.setInfo(info);
        try {
            Image image = imageService.addImage(logo);
            commercialNetwork.setImage(image);
            commercialNetworkService.save(commercialNetwork);
        } catch (Exception e) {
            //imageService.deleteByID(image.getId());
            Throwable couse = e.getCause();
            while(couse.getCause() != null) {
                couse = couse.getCause();
            }
            log.error(couse.getMessage());
            model.addAttribute("error", couse.getMessage());
            return "add/answer/error";
        }
        model.addAttribute("answer", "Торговая сеть успешно добавлена");
        model.addAttribute("id", commercialNetwork.getId());
        model.addAttribute("path", "../../info/cnetwork");
        return "add/answer/success";
    }
}
