package gray.demo.apiImpl.service;

import gray.demo.common.entity.BaseUser;
import gray.demo.infrastructure.dao.BaseUserMapper;
import gray.demo.api.service.BaseUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author 二月菌
 * @since 2024-03-08 22:10:11
 */
@Service
public class BaseUserServiceImp extends ServiceImpl<BaseUserMapper, BaseUser> implements BaseUserService {

}
