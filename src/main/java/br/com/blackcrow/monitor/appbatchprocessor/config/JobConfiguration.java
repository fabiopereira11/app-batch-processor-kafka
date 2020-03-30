package br.com.blackcrow.monitor.appbatchprocessor.config;


import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step step() {
        return stepBuilderFactory.get("step").tasklet((contribution, chunkContext) -> {
            System.out.println("Hello World, Este é o step 1");
            return RepeatStatus.FINISHED;
        }).build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2").tasklet((contribution, chunkContext) -> {
            System.out.println("Hello World, Este é o step 2");
            return RepeatStatus.FINISHED;
        }).build();
    }

    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3").tasklet((contribution, chunkContext) -> {
            System.out.println("Hello World, Este é o step 3");
            return RepeatStatus.FINISHED;
        }).build();
    }

    @Bean
    public Job job() throws InterruptedException {
        return jobBuilderFactory.get("Job1")
                .start(step()).on("COMPLETED")
                .to(step2()).from(step3()).on("COMPLETED")
                .to(step3()).end()
                .build();
    }



}
