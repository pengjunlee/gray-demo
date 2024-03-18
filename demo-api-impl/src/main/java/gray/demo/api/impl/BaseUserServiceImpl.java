package gray.demo.api.impl;

import gray.bingo.common.utils.RequestUtil;
import gray.bingo.mybatis.datasource.BingoDatasource;
import gray.demo.api.service.BaseUserService;
import gray.demo.common.entity.BaseUser;
import gray.demo.infrastructure.repo.BaseUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@BingoDatasource(dbName = "blossom")
@Slf4j
public class BaseUserServiceImpl implements BaseUserService {

    private final BaseUserRepo baseUserRepo;

    private final AsyncService asyncService;

    @Override
    public BaseUser getById(Long id) {
        log.info(Thread.currentThread().getName());
        System.out.println(RequestUtil.getHeaderValue("BINGO_TRACE"));
        asyncService.async();
        return baseUserRepo.getById(id);

    }
}
