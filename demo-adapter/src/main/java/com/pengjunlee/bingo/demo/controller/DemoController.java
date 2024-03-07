package com.pengjunlee.bingo.demo.controller;

import gray.bingo.demo.service.DemoService;
import gray.bingo.tracker.adapter.aspect.TrackerStart;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/test")
    @TrackerStart(spanName = "DemoController")
    public String meta(){
        return demoService.test();
    }
}
