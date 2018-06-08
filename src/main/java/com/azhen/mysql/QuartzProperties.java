package com.azhen.mysql;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Properties;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;


public class QuartzProperties {
    public static void main(String[] args) {
        try {
            Properties prop = new Properties();
            //RMI configuration to make the client to connect to the
            // Quartz server
            prop.put("org.quartz.scheduler.rmi.export", "true");
            prop.put("org.quartz.scheduler.rmi.createRegistry", "true");
            prop.put("org.quartz.scheduler.rmi.registryHost", "localhost");
            prop.put("org.quartz.scheduler.rmi.registryPort", "1099");
            prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
            prop.put("org.quartz.threadPool.threadCount", "2");
            //Quartz Server Properties
            prop.put("quartz.scheduler.instanceName", "ServerScheduler");
            prop.put("org.quartz.scheduler.instanceId", "AUTO");
            prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
            prop.put("org.quartz.scheduler.instanceId", "NON_CLUSTERED");
            prop.put("org.quartz.scheduler.jobFactory.class", "org.quartz.simpl.SimpleJobFactory");
            prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
            prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
            prop.put("org.quartz.jobStore.dataSource", "quartzDataSource");
            prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
            prop.put("org.quartz.jobStore.isClustered", "false");
            //MYSQL DATABASE CONFIGURATION
            //If we do not specify this configuration, QUARTZ will
            // use RAM(in-memory) to store jobs
            //Once we restart QUARTZ, the jobs will not be persisted
            // Configure your MySQL properties
            prop.put("org.quartz.dataSource.quartzDataSource.driver", "com.mysql.jdbc.Driver");
            prop.put("org.quartz.dataSource.quartzDataSource.URL", "jdbc:mysql://112.74.191.64:3306/quartz");
            prop.put("org.quartz.dataSource.quartzDataSource.user", "root");
            prop.put("org.quartz.dataSource.quartzDataSource.password", "Linggu123!@#");
            prop.put("org.quartz.dataSource.quartzDataSource.maxConnections", "2");
            SchedulerFactory stdSchedulerFactory = new StdSchedulerFactory(prop);
            Scheduler scheduler = stdSchedulerFactory.getScheduler();

            // Create Job
            JobDetail job = newJob(TestJob.class).withIdentity
                    ("jobName", "groupName")
                    .build();
            // Create Trigger
            Trigger trigger = newTrigger().withIdentity
                    ("triggerName", "groupName")
                    .startNow().withSchedule(simpleSchedule()
                            .withIntervalInSeconds(10)
                            .repeatForever())
                    .build();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}