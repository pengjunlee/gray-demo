package gray.demo.infrastructure.dao;

import gray.demo.common.entity.BaseUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author 二月菌
 * @since 2024-03-08 22:18:34
 */
@Mapper
public interface BaseUserMapper extends BaseMapper<BaseUser> {

}
