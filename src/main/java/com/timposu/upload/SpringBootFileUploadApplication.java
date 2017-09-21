package com.timposu.upload;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.timposu.upload.config.StorageProperties;
import com.timposu.upload.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringBootFileUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFileUploadApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
