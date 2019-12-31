package com.spring.batch;

import com.mixpanel.mixpanelapi.MessageBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;


@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    /**
     *
     * @return
     */
    @Bean
    public Job processJob() {
        return jobBuilderFactory.get(UUID.randomUUID().toString())
                .incrementer(new RunIdIncrementer()).listener(listener()).preventRestart()
                .flow(orderStep1()).end().build();
    }

    /**
     *
     * @return
     */
    @Bean
    public Step orderStep1() {
        return stepBuilderFactory.get(UUID.randomUUID().toString()).<Catalogue,Catalogue>chunk(10)/*tasklet(tasklet()).build();*/
                .reader(new Reader()).processor(new Processor())
                .writer(new Writer()).build();
    }

    /**
     *
     * @return
     */
    @Bean
    public MessageBuilder getMessageBuilder(){
       return new MessageBuilder("a53d31c1919006a87114a9aa9aaeab96");
    }
//    @Bean
//    public Tasklet tasklet() {
//        return (contribution, chunkContext) -> {
//            chunkContext.getStepContext().getStepExecution().getExecutionContext().put("name","devagoud");
//            return RepeatStatus.FINISHED;
//        };
//    }
    @Bean
    public JobExecutionListener listener() {
        return new JobCompletionListener();
    }

}