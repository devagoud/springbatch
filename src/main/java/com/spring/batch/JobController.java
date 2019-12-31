package com.spring.batch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class JobController {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job processJob;

    @RequestMapping("/invokejob")
    public String handle() throws Exception {

//        JobParameters jobParameters = new JobParametersBuilder().addDate("date",new Date())
//                .toJobParameters();
        Map<String, JobParameter> confMap = new HashMap<String, JobParameter>();
        confMap.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(confMap);

        jobLauncher.run(processJob, jobParameters);

        return "Batch job has been invoked";
    }
}
