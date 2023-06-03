package com.madeeasy.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SchedulerServiceOne {

    /**
     * Which Methods can be the candidate to use @Scheduled?
     *
     * @Scheduled is a method level annotation applied at runtime to mark the method to be scheduled.
     * Any method using @Scheduled needs to satisfy two conditions:
     * <p>
     * 1) The annotated method should not have a return type. Otherwise the return value will be overlooked at runtime.
     * <p>
     * 2) The annotated method should not accept any input parameters.
     */

    @Scheduled(cron = "0 0/5 * * * *")
    public void reportCurrentTime() {
        System.out.printf("%s:%s%n", new Date(), this.toString());
    }


    @Scheduled(initialDelay = 5000, fixedDelay = 9000)
//	@Scheduled(initialDelayString = "5000" ,fixedDelayString = "9000")
    // 1000 milli sec = 1sec
    public void scheduledMethodWithInitialDelayAndFixedDelay() {
        System.out.println("Hello Scheduler One :" + new Date());
    }

    @Scheduled(fixedRate = 1000)
    //@Scheduled(fixedRateString = "4000")
    public void scheduledMethodWithFixedRate() {
        System.out.println("Hello Scheduler Two :" + new Date());
    }

    @Scheduled(cron = "15 * * * * *")
    public void scheduledMethodWithCronExpression() {
        System.out.println("Hello cron Scheduler Three :" + new Date());
    }
    /**
     * //-------------------------------- For learning purpose--------------------------------
     *
     * How to write a Cron Expression ?
     *
     * 1) There are 6 Asterisks(******) by default in cron expression as shown below. Further each asterisk has some meaning as
     * they denote a value. These values can be assigned as Second, Minute, Hours, Day, Month, WeekDay respectively in sequence as shown below.
     * Possible values at proper place are also given below.
     *
     * CronExp
     * 2) A Cron Expression can accept symbols : * – , / ?
     *
     * 3) Comma denotes possible values
     * 0 0 4,6 * * *
     * Above expression denotes ‘execute given task every day 4:00:00AM and 6:00:00 AM
     *
     * 4) Dash (-) denotes a range, which means consider all possible values between the range
     * 0 0 4-6 * * *
     * To illustrate, above expression just denotes ‘execute given task every day 4:00:00AM, 5:00:00AM and 6:00:00 AM’
     *
     * 5) Asterisk(*) denotes any/every/all value
     *
     * 6) Forward slash(/) denotes a period of time
     *
     * 7) Question mark(?) denotes any value, but it is applied only at Day & WeekDay when month value is given.
     *
     * 8) English names can also be used for the day-of-month and day-of-week fields. Use the first three letters of the particular
     * day or month (case does not matter).
     *
     * Note: For a separate article specific to cron expressions with improvements in Spring 5.3, visit Spring Scheduling
     * Cron Expressions & Improvements.
     */
}