package gray.demo.starter;

import gray.bingo.starter.BingoStarter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @作者 二月菌
 * @版本 1.0
 * @日期 2024-01-28 13:01
 */
@SpringBootApplication(scanBasePackages = {"gray.demo","gray.bingo"})
@MapperScan(basePackages = {"com.pengjunlee.bingo.demo.dao"})
public class DemoApp extends BingoStarter {

    public static void main(String[] args) {
        run(DemoApp.class, args);
    }
}
