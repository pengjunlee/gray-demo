package com.pengjunlee.bingo.demo.serviceImpl;

import com.bingo.tracker.adapter.aspect.TrackerStart;
import com.pengjunlee.bingo.demo.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    @TrackerStart(spanName = "DemoServiceImpl")
    public String test() {
        return "test";
    }
}
