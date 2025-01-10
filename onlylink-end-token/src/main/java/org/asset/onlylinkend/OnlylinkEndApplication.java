package org.asset.onlylinkend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("org.asset.onlylinkend.mapper")
@SpringBootApplication()
public class OnlylinkEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlylinkEndApplication.class, args);
    }

}
