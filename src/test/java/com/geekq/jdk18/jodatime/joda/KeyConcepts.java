package com.geekq.jdk18.jodatime.joda;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.joda.time.DateTime;

public class KeyConcepts {
  public static void main(String[] args) {
    example1_1();
    example1_2();
    example1_3();
    example1_4();
  }
  
  private static void example1_1() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
    SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/yyyy HH:mm:ss.SSS");
    calendar.add(Calendar.DAY_OF_MONTH, 90);
    System.out.println(sdf.format(calendar.getTime()));
  }
  
  private static void example1_2() {
    DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);
    System.out.println(dateTime.plusDays(90).toString("E MM/dd/yyyy HH:mm:ss.SSS"));
  }
  
  private static void example1_3() {
    DateTime dt = new DateTime(2000, 1, 1, 0, 0, 0, 0);
    System.out.println(
        dt.plusDays(45)
          .plusMonths(1)
          .dayOfWeek()
          .withMaximumValue()
          .toString("E MM/dd/yyyy HH:mm:ss.SSS"));    
  }
  
  private static void example1_4() {
    Calendar calendar = Calendar.getInstance();
    DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);
    System.out.println(dateTime.plusDays(45).plusMonths(1).dayOfWeek()
      .withMaximumValue().toString("E MM/dd/yyyy HH:mm:ss.SSS"));
    calendar.setTime(dateTime.toDate());    
  }
}
