package com.kubkyactus.kkyactus.controller;

import com.kubkyactus.kkyactus.service.PodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PodController {

    private final PodService podService;

    @Autowired
    public PodController(PodService podService) {
        this.podService = podService;
    }

    @GetMapping("/kkyactus/api/v1/pods")
    List<String> getAllPods() {
        return podService.getAllPodsName();
    }
}
