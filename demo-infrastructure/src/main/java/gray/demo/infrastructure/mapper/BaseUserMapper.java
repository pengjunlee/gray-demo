package gray.demo.infrastructure.mapper;

import gray.bingo.mybatis.datasource.BingoDatasource;
import gray.demo.common.entity.BaseUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author 二月菌
 * @since 2024-03-11 17:45:18
 */
@Mapper
public interface BaseUserMapper extends BaseMapper<BaseUser> {

}
