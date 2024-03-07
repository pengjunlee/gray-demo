package gray.demo.infrastructure.dao;

import gray.bingo.mybatis.datasource.BingoDatasource;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@BingoDatasource(dbName = "default")
public interface DemoMapper {
}
