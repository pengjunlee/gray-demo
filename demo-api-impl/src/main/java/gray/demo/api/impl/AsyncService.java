package gray.demo.api.impl;

import gray.bingo.common.utils.JsonUtil;
import gray.demo.common.entity.BaseUser;
import gray.demo.infrastructure.remote.DemoFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AsyncService {

    private final DemoFeign demoFeign;

    @Async
    public void async() {
        log.info(Thread.currentThread().getName());
        log.info("AsyncService running");
        String test = demoFeign.test();
        log.info("AsyncService result:{}", JsonUtil.toJson(test));
    }


}
