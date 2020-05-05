package com.geekq.jdk18.jodatime.util.time;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;


public class HardcodedSystemClock implements SystemClock {
  
  /**
   * Hardcode the date time here. It will be used as the "Sytem Time"
   * for all code that use the SystemClock interface, where this implementation
   * is the one returned by SystemFactory.getClock().
   */
  // This instance set to 9/6/2009 8:00am
  private static final DateTime theDateTime = new DateTime(2009, 9, 6, 14, 30, 0, 0);

  public DateTime getDateTime() {
    return theDateTime;
  }

  public long getTimeInMillis() {
    return theDateTime.getMillis();
  }

  public DateMidnight getDateMidnight() {
    return theDateTime.toDateMidnight();
  }

  public LocalDate getLocalDate() {
    return theDateTime.toLocalDate();
  }

  public LocalTime getLocalTime() {
    return theDateTime.toLocalTime();
  }

  public Calendar getCalendar() {
    return theDateTime.toCalendar(Locale.getDefault());
  }

  public Date getDate() {
    return theDateTime.toDate();
  }

}
