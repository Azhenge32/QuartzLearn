package com.azhen.triggerData;

import org.quartz.*;

@DisallowConcurrentExecution
public class TriggerDataMapJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Trigger trigger = context.getTrigger();
        String triggerGroup = trigger.getJobKey().getGroup();
        String triggerName = trigger.getJobKey().getName();
        System.out.println("JobName:" + triggerGroup + "-" + triggerName);
        // System.out.println();
        // JobDataMap jobDataMap = trigger.getJobDataMap();
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        String flowCode = String.valueOf(jobDataMap.get("flowcode"));
        String messageId = String.valueOf(jobDataMap.get("messageId"));
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println();
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // System.out.println(flowCode);
        // System.out.println(messageId);
    }
}
