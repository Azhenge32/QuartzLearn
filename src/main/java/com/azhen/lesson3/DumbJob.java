package com.azhen.lesson3;

import org.quartz.*;

import java.util.ArrayList;
import java.util.Date;

@DisallowConcurrentExecution
public class DumbJob implements Job {
    String jobSays;
    float myFloatValue;
    ArrayList state;

    public DumbJob() {
    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        try {
            JobKey key = context.getJobDetail().getKey();
            JobDataMap dataMap = context.getMergedJobDataMap();
            System.out.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);
            Thread.sleep(3 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setJobSays(String jobSays) {
        this.jobSays = jobSays;
    }

    public void setMyFloatValue(float myFloatValue) {
        myFloatValue = myFloatValue;
    }

    public void setState(ArrayList state) {
        state = state;
    }
}
