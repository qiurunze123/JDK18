package com.geekq.jdk18.jodatime.joda;

import java.util.Calendar;
import java.util.Date;

import com.geekq.jdk18.jodatime.joda.factory.SystemFactory;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreatingJodaTimeObjects {
  private static Logger log = LoggerFactory.getLogger(CreatingJodaTimeObjects.class);
  public static void main(String[] args) {
    
    example2_1();
    example2_2();
    example2_3();
    example2_4();
    example2_5();
       
  }
  
  private static void example2_1() {
    DateTime dateTime = new DateTime();
    log.info("Using system clock: " + dateTime.toString());
    dateTime = SystemFactory.getClock().getDateTime();
    log.info("Using (better) system clock: " + dateTime.toString());
  }
  
  private static void example2_2() {
    DateTime dateTime = new DateTime(
        2000, //year
        1,    // month
        1,    // day
        0,    // hour (midnight is zero)
        0,    // minute
        0,    // second
        0     // milliseconds
      );
    log.info("Using explicit field values: " + dateTime.toString());
  }
  
  private static void example2_3() {
    Date jdkDate = obtainDateSomehow();
    long timeInMillis = jdkDate.getTime();
    DateTime dateTime = new DateTime(timeInMillis);
    log.info("Using a Date object's millisecond value: " + dateTime.toString());
  }
  
  private static Date obtainDateSomehow() {
    return SystemFactory.getClock().getDate();
  }
  private static Calendar obtainCalendarSomehow() {
    return SystemFactory.getClock().getCalendar();
  }
  private static DateTime obtainDateTimeSomehow() {
    return SystemFactory.getClock().getDateTime();
  }
  
  private static void example2_4() {
    Date jdkDate = obtainDateSomehow();
    DateTime dateTime = new DateTime(jdkDate.getTime());    
    log.info("Using a Date object directly: " + dateTime.toString());
  }
  private static void example2_5() {
    // Use a Calendar
    Calendar calendar = obtainCalendarSomehow();
    DateTime dateTime = new DateTime(calendar);
    log.info("Using a Calendar object directly: " + dateTime.toString());
    // Use another Joda DateTime
    DateTime anotherDateTime = obtainDateTimeSomehow();
    dateTime = new DateTime(anotherDateTime);
    log.info("Using another DateTime object: " + dateTime.toString());
    // Use a String (must be formatted properly)
    String timeString = "2006-01-26T13:30:00-06:00";
    dateTime = new DateTime(timeString);
    log.info("Using a String: " + dateTime.toString());
    
    timeString = "2006-01-26";
    dateTime = new DateTime(timeString);
    log.info("Using a String: " + dateTime.toString());    
  }
}
