package gray.demo.infrastructure.repo.impl;

import gray.bingo.mybatis.datasource.BingoDatasource;
import gray.demo.common.entity.BaseUser;
import gray.demo.infrastructure.mapper.BaseUserMapper;
import gray.demo.infrastructure.repo.BaseUserRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author 二月菌
 * @since 2024-03-11 17:45:18
 */
@Service
public class BaseUserRepoImpl extends ServiceImpl<BaseUserMapper, BaseUser> implements BaseUserRepo {

}
