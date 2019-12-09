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
public class ELiquidController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ELiquidService eLiquidService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private BlendRatioService blendRatioService;

    @GetMapping("info/eliquid")
    public String getVapeshopInfoPage(@RequestParam("id") Integer id, Model model){
        ELiquid eLiquid = eLiquidService.findByID(id);
        model.addAttribute("eliquid", eLiquid);
        return "info/eliquid";
    }
    @GetMapping("add/eliquid")
    public String getVapeshopAddingPage(Model model){
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("blendRatio", blendRatioService.findAll());
        return "add/eliquid";
    }
    @PostMapping("add/eliquid/post")
    public String newVapeshop(@RequestParam List<String> images,
                              @RequestParam String name,
                              @RequestParam String info,
                              @RequestParam Integer brandId,
                              Model model
    )
    {
        Product product = new Product();
        Brand brand = brandService.findByID(brandId);
        product.setBrand(brand);
        product.setName(name);
        product.setInfo(info);
        images.forEach((value)-> {
            ProductImage productImage = new ProductImage();
            productImage.setProduct(product);
            productImage.setImage(value);
            productImageService.save(productImage);
        });
        ELiquid eLiquid = new ELiquid();
        eLiquid.setProduct(product);
        try {
            eLiquidService.save(eLiquid);
        } catch (Exception e) {
            log.error(e.getMessage());
            model.addAttribute("error", e.getMessage());
            return "add/answer/error";
        }
        model.addAttribute("answer", "Магазин успешно добавлен");
        model.addAttribute("id", eLiquid.getId());
        model.addAttribute("path", "../../info/eliquid");
        return "add/answer/success";
    }
}
