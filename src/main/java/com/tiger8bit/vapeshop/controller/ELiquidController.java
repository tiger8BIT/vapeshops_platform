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

import java.util.Collections;
import java.util.LinkedList;
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
    private ImageService imageService;
    @Autowired
    private BlendRatioService blendRatioService;

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, @RequestParam("page") Integer page, Model model){
        int count = 4;
        int endIndex = count * page;
        int startIndex = endIndex - count;
        List<Product> products = productService.findAll();

        List<Product> res = products.stream()
                .filter(i -> i.getName().contains(search) || i.getBrand().getName().contains(search))
                .collect(Collectors.toList());
        log.info("{}", products.size());
        log.info("{}", search);
        log.info("{}", res);
        int maxpage = res.size() / count + ((res.size() % count != 0) ? 1 : 0);
        List<Integer> pages = new LinkedList<>();
        for(int i = 1; i <= maxpage; i++){
            pages.add(i);
        }
        model.addAttribute("pages", pages);
        model.addAttribute("products", res.subList(startIndex, Math.min(endIndex, res.size())));
        model.addAttribute("search", search);
        model.addAttribute("prev", Math.max(page - 1, 1));
        model.addAttribute("next", Math.min(page + 1, maxpage));
        return "/search";
    }

    @GetMapping({"/", "/eliquids"})
    public String getEliquidsPage(@RequestParam("page") Integer page, Model model){
        int count = 3;
        int endIndex = count * page;
        int startIndex = endIndex - count;
        List<ELiquid> eLiquids = eLiquidService.findAll();
        int maxpage = eLiquids.size() / count + ((eLiquids.size() % count != 0) ? 1 : 0);
        List<Integer> pages = new LinkedList<>();
        for(int i = 1; i <= maxpage; i++){
            pages.add(i);
        }
        model.addAttribute("pages", pages);
        model.addAttribute("eliquids", eLiquids.subList(startIndex, Math.min(endIndex, eLiquids.size())));
        model.addAttribute("prev", Math.max(page - 1, 1));
        model.addAttribute("next", Math.min(page + 1, maxpage));
        return "/eliquids";
    }

    @GetMapping("product/images")
    @ResponseBody public ResponseEntity getRegions(@RequestParam Integer id) {
        Product product = productService.findByID(id);
        List<Image> images = product.getProductImages();
        List<String> urls = images.stream().map(Image::getUrl).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(urls);
    }

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
                              @RequestParam Integer volume,
                              @RequestParam String n_type,
                              @RequestParam Integer blendRatioId,
                              Model model
    )
    {
        Product product = new Product();
        Brand brand = brandService.findByID(brandId);
        product.setBrand(brand);
        product.setName(name);
        product.setInfo(info);
        ELiquid eLiquid = new ELiquid();
        eLiquid.setProduct(product);
        eLiquid.setVolume(volume);
        BlendRatio blendRatio = blendRatioService.findByID(blendRatioId);
        eLiquid.setBlendRatio(blendRatio);
        productService.save(product);
        product.setProductImages(new LinkedList<>());
        images.forEach((value)-> {
            Image image = new Image();
            image.setUrl(value);
            imageService.save(image);
            product.getProductImages().add(image);
        });
        try {
            eLiquidService.save(eLiquid);
        } catch (Exception e) {
            Throwable couse = e.getCause();
            while(couse.getCause() != null) {
                couse = couse.getCause();
            }
            log.error(couse.getMessage());
            model.addAttribute("error", couse.getMessage());
            return "add/answer/error";
        }
        model.addAttribute("answer", "Магазин успешно добавлен");
        model.addAttribute("id", eLiquid.getId());
        model.addAttribute("path", "../../info/eliquid");
        return "add/answer/success";
    }
}
