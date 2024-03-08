package gray.demo.infrastructure.repo.impl;

import gray.demo.common.entity.BaseUser;
import gray.demo.infrastructure.dao.BaseUserMapper;
import gray.demo.infrastructure.repo.BaseUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author 二月菌
 * @since 2024-03-08 22:18:34
 */
@Service
public class BaseUserServiceImp extends ServiceImpl<BaseUserMapper, BaseUser> implements BaseUserService {

}
