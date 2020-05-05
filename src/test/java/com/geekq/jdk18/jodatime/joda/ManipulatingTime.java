package com.geekq.jdk18.jodatime.joda;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.geekq.jdk18.jodatime.joda.factory.SystemFactory;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManipulatingTime {
  private static Logger log = LoggerFactory.getLogger(ManipulatingTime.class);
  public static void main(String[] args) {
    
    example3_1();
    example3_2();
    example3_3();
    example3_4();
    example3_5();
    example3_6();
    example3_7();
    
  }
  
  private static void example3_1() {
    LocalDate now = SystemFactory.getClock().getLocalDate();
    log.info("Now:" + now.toString());
    LocalDate lastDayOfPreviousMonth = now.minusMonths(1).dayOfMonth().withMaximumValue();
    log.info("Then: " + lastDayOfPreviousMonth.toString());
  }

  private static void example3_2() {
    LocalDate now = SystemFactory.getClock().getLocalDate();
    log.info("Now:" + now.toString());
    LocalDate electionDate = now.monthOfYear()
     .setCopy(11)        // November
     .dayOfMonth()       // Access Day Of Month Property
     .withMinimumValue() // Get its minimum value
     .plusDays(6)        // Add 6 days
     .dayOfWeek()        // Access Day Of Week Property
     .setCopy("Monday")  // Set to Monday (it will round down)
     .plusDays(1);       // Gives us Tuesday
    log.info("Then:" + electionDate.toString());
  }

  private static void example3_3() {
    DateTime now = SystemFactory.getClock().getDateTime();
    log.info("Now:" + now.toString());
    DateTime tomorrow = now.plusDays(1);
    DateTime then = tomorrow.plusDays(90);
    log.info("Then:" + then.toString());
  }

  private static void example3_4() {
    DateTime now = SystemFactory.getClock().getDateTime();
    log.info("Now:" + now.toString());
    DateTime then = now.plusWeeks(2);
    log.info("Then:" + then.toString());
  }

  private static void example3_5() {
    DateTime now = SystemFactory.getClock().getDateTime();
    log.info("Now:" + now.toString());
    DateTime then = now.plusSeconds(156);
    log.info("Then:" + then.toString());
  }

  private static void example3_6() {
    DateTime now = SystemFactory.getClock().getDateTime();
    log.info("Now:" + now.toString());
    DateTime then = now.minusYears(5)
                   .monthOfYear()
                   .setCopy(2)
                   .dayOfMonth()
                   .withMaximumValue();    
    log.info("Then:" + then.toString());    
  }

  private static void example3_7() {
    DateTime dateTime = SystemFactory.getClock().getDateTime();
    log.info("DateTime:" + dateTime.toString());
    Calendar calendar = dateTime.toCalendar(Locale.getDefault());
    SimpleDateFormat sdf = new SimpleDateFormat();
    log.info("As Calendar:" + sdf.format(calendar.getTime()));
    Date date = dateTime.toDate();
    log.info("As Date:" + sdf.format(date));
    DateMidnight dateMidnight = SystemFactory.getClock()
      .getDateMidnight();
    date = dateMidnight.toDate();
    log.info("As Date (from DateMidnight):" + sdf.format(date));
  }

}
