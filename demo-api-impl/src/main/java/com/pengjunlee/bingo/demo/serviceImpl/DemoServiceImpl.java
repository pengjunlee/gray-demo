package com.pengjunlee.bingo.demo.serviceImpl;

import gray.bingo.demo.service.DemoService;
import gray.bingo.tracker.adapter.aspect.TrackerStart;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    @TrackerStart(spanName = "DemoServiceImpl")
    public String test() {
        return "test";
    }
}
