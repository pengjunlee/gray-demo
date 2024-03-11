package gray.demo.api.impl;

import gray.bingo.mybatis.datasource.BingoDatasource;
import gray.bingo.mybatis.datasource.DynamicDataSourceAspect;
import gray.demo.api.service.BaseUserService;
import gray.demo.common.entity.BaseUser;
import gray.demo.infrastructure.repo.BaseUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@BingoDatasource(dbName = "blossom")
public class BaseUserServiceImpl implements BaseUserService {

    private final BaseUserRepo baseUserRepo;

    private final DynamicDataSourceAspect dynamicDataSourceAspect;
    @Override
    public BaseUser getById(Long id) {
        System.out.println(dynamicDataSourceAspect.toString());
        return baseUserRepo.getById(id);

    }
}
