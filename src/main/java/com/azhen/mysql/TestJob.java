package com.azhen.mysql;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("I am JOB, schdule me with Quartz");
        System.out.println("Send SMS here");
    }
}
