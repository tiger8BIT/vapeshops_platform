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
public class BrandController {
    @Autowired
    private BrandService brandService;
    @Autowired
    private ImageService imageService;

    @GetMapping("info/brand")
    public String getVapeshopInfoPage(@RequestParam("id") Integer id, Model model){
        Brand brand = brandService.findByID(id);
        model.addAttribute("brand", brand);
        return "info/brand";
    }
    @PostMapping("add/brand/get")
    public ResponseEntity newVapeshop(@RequestParam String name,
                              @RequestParam String info,
                              @RequestParam String logo
    )
    {
        Brand brand = new Brand();
        brand.setName(name);
        brand.setInfo(info);
        Image image = new Image();
        image.setUrl(logo);
        try {
            imageService.save(image);
            brand.setImage(image);
            brandService.save(brand);
        } catch (Exception e) {
            //imageService.deleteByID(image.getId());
            Throwable couse = e.getCause();
            while(couse.getCause() != null) {
                couse = couse.getCause();
            }
            log.error(couse.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(couse.getMessage());
        }
        log.info("created\n");
        return ResponseEntity.status(HttpStatus.CREATED).body(brand);
    }
}

