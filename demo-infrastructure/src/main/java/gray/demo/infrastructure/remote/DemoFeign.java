package gray.demo.infrastructure.remote;

import gray.bingo.tracker.adapter.feign.TrackerFeignInterceptor;
import gray.demo.common.entity.BaseUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "demo-feign",
        url = "http://localhost:8080/baseUser",
        configuration = TrackerFeignInterceptor.class
)
public interface DemoFeign {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BaseUser get(@PathVariable("id") Long id);


    @RequestMapping(value = "/test")
    public String test();
}
