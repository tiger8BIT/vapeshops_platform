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
public class BlendRatioController {
    @Autowired
    private BlendRatioService blendRatioService;

    @GetMapping("info/blend-ratio")
    public String getVapeshopInfoPage(@RequestParam("id") Integer id, Model model){
        BlendRatio blendRatio = blendRatioService.findByID(id);
        model.addAttribute("blendRatio", blendRatio);
        return "info/blend-ratio";
    }
    @PostMapping("add/blend-ratio/post")
    public String newVapeshop(@RequestParam Integer vg,
                              @RequestParam Integer pg,
                              Model model
    )
    {
        BlendRatio blendRatio = new BlendRatio();
        blendRatio.setVg(vg);
        blendRatio.setPg(pg);
        try {
            blendRatioService.save(blendRatio);
        } catch (Exception e) {
            Throwable couse = e.getCause();
            while(couse.getCause() != null) {
                couse = couse.getCause();
            }
            log.error(couse.getMessage());
            model.addAttribute("error", couse.getMessage());
            return "add/answer/error";
        }
        model.addAttribute("answer", "Бренд успешно добавлен");
        model.addAttribute("id", blendRatio.getId());
        model.addAttribute("path", "../../info/blend-ratio");
        return "add/answer/success";
    }
}

