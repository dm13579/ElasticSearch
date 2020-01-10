package com.dm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dm.mapper")
public class ElasticsearchImportdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchImportdataApplication.class, args);
	}

}
