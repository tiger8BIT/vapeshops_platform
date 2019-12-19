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
    private SecurityService securityService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CommercialNetworkService commercialNetworkService;
    @Autowired
    private VapeshopService vapeshopService;

    @GetMapping("/username")
    public @ResponseBody String username(){
        return securityService.findLoggedInUsername();
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout){
        log.info("{}", securityService.findLoggedInUsername());
        model.addAttribute("error", error);
        return "sing-in-page";
    }

    @GetMapping("info/cnetwork")
    public String getCnetworkInfoPage(@RequestParam("id") Integer id, Model model){
        CommercialNetwork commercialNetwork = commercialNetworkService.findByID(id);
        model.addAttribute("cnetwork", commercialNetwork);
        return "info/cnetwork";
    }

    @GetMapping("private-office/cnetwork")
    public String getPersonalOfficePage(Model model){
        CommercialNetwork commercialNetwork = commercialNetworkService.findByUsername(securityService.findLoggedInUsername());
        model.addAttribute("cnetwork", commercialNetwork);
        return "private-office/cnetwork";
    }

    @GetMapping("update/cnetwork")
    public String getUpdateVapeshopPage(@RequestParam("id") Integer id, Model model){
        CommercialNetwork currrent = commercialNetworkService.findByUsername(securityService.findLoggedInUsername());
        if (!currrent.getId().equals(id)) return "login";
        CommercialNetwork commercialNetwork = commercialNetworkService.findByID(id);
        model.addAttribute("cnetwork", commercialNetwork);
        model.addAttribute("btntext", "Изменить");
        return "add/cnetwork";
    }

    @GetMapping("/vapeshops")
    public String getVapeshopInfoPage(Model model){
        CommercialNetwork commercialNetwork = commercialNetworkService.findByUsername(securityService.findLoggedInUsername());
        List<Vapeshop> vapeshops = vapeshopService.findAllByCommercialNetwork(commercialNetwork);
        model.addAttribute("vapeshops", vapeshops);
        return "info/vapeshops";
    }

    @GetMapping("add/cnetwork")
    public String getVapeshopAddingPage(Model model){
        model.addAttribute("btntext", "Добавить");
        return "add/cnetwork";
    }
    @PostMapping("add/cnetwork/post")
    public String newCNetwork(@RequestParam Integer id,
                              @RequestParam String username,
                              @RequestParam String password,
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
        if(id == null) {
            commercialNetwork.setUsername(username);
            commercialNetwork.setPassword(password);
            commercialNetwork.setPasswordConfirm(password);
        }
        Image image = id == null ? new Image() : commercialNetwork.getImage();
        image.setUrl(logo);
        try {
            imageService.save(image);
            commercialNetwork.setImage(image);
            if (id == null)
                commercialNetworkService.save(commercialNetwork);
            else
                commercialNetworkService.update(commercialNetwork);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "add/answer/error";
        }
        if (id == null) securityService.autoLogin(username, password);
        model.addAttribute("answer", id == null ? "Торговая сеть успешно добавлена" : "Успешно изменено");
        model.addAttribute("id", commercialNetwork.getId());
        model.addAttribute("path", "/private-office/cnetwork");
        model.addAttribute("btntext", "Личный кабинет");
        return "add/answer/success";
    }
}
