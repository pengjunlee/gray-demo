package gray.demo.api.serviceImpl;

import gray.demo.api.service.DemoService;
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
