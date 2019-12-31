package com.spring.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JobCompletionListener extends JobExecutionListenerSupport {

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
        }
    }
//	@Override
//	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//		// pull variable from JobExecutionContext
//		String value = (String) chunkContext
//				.getStepContext()
//				.getStepExecution()
//				.getJobExecution()
//				.getExecutionContext()
//				.get("name");
//		log.info(value);
//
//
//		// exit the step
//		return RepeatStatus.FINISHED;
//	}

}
