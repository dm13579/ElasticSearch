package com.dm.searchplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;


@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
@MapperScan({"com.dm.searchplatform.mapper","com.dm.searchplatform.core"})
@ComponentScan(basePackages = {"com.dm.searchplatform"})
@EnableScheduling
public class SearchPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchPlatformApplication.class, args);
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.
	}

}
