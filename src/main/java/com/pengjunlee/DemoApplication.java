package com.pengjunlee;

import com.pengjunlee.bingo.BingoStarter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 二月君
 * @version 1.0
 * @date 2024-01-21 15:04
 */
@SpringBootApplication(scanBasePackages = {"com.pengjunlee.*"})
public class DemoApplication extends BingoStarter {

    public static void main(String[] args) {
        run(DemoApplication.class, args);
    }
}
