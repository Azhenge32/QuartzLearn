package com.azhen.lesson1;

import org.quartz.*;

public class HelloJob implements Job {
    public HelloJob() {
    }

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.err.println("Hello!  HelloJob is executing.");
    }
}
