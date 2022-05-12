package com.example.demo.controller;

import com.example.demo.entity.dto.ShadowDTO;
import com.example.demo.service.ShadowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shadow")
public class ShadowController {

    @Autowired
    private ShadowService shadowService;

    @PostMapping("/add")
    public ShadowDTO shadowAdd(@RequestBody ShadowDTO shadowDTO) {
        shadowService.saveShadow(shadowDTO);
        return shadowDTO;
    }

    @GetMapping("/getById")
    public ShadowDTO.MetadataBean.DesiredBeanX getById(@RequestParam Integer id) {
        return shadowService.getById(id);
    }
}
