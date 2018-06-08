package com.azhen.lesson3;

import org.quartz.*;

import java.util.ArrayList;

public class Dumb2Job implements Job {
    public Dumb2Job() {
    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        try {
            JobKey key = context.getJobDetail().getKey();
            JobDataMap dataMap = context.getMergedJobDataMap();
            String jobSays = dataMap.getString("jobSays");
            float myFloatValue = dataMap.getFloat("myFloatValue");
            ArrayList state = (ArrayList)dataMap.get("myStateData");

            System.out.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
