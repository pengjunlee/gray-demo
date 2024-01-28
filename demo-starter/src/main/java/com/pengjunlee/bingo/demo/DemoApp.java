package com.pengjunlee.bingo.demo;

import com.pengjunlee.starter.BingoStarter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @作者 二月君
 * @版本 1.0
 * @日期 2024-01-28 13:01
 */
@SpringBootApplication(scanBasePackages = "com.pengjunlee.bingo")
public class DemoApp extends BingoStarter {

    public static void main(String[] args) {
        run(DemoApp.class, args);
    }
}
