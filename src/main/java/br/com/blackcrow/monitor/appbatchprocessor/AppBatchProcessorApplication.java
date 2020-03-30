package br.com.blackcrow.monitor.appbatchprocessor;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class AppBatchProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppBatchProcessorApplication.class, args);
    }

}

