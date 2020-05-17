package com.geekq.jdk18.jodatime.util.time;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

/**
 * Serves as a wrapper for the system clock to be used by applications
 * to retrieve the system time, rather than System.currentTimeMillis().
 * This allows us to set arbitrary times to exercise application logic
 * without having to alter the system time to do so.
 * 
 * @author steve
 *
 */
public interface SystemClock {
  /**
   * Retrieve the system time in milliseconds
   * 
   * @return - long - the number of milliseconds since the epoc that
   * represents the system time. This is consistent with the JDK
   * definition of time.
   */
  public long getTimeInMillis();
  /**
   * Retrieve the system time as a Joda DateTime object.
   *  
   * @return - DateTime - a Joda DateTime object that contains the
   * system time.
   */
  public DateTime getDateTime();
  /**
   * Retrieve the system time as a Joda DateMidnight object.
   * 
   * @return - DateMidnight - a Joda DateMidnight object that contains
   * the system time.
   */
  public DateMidnight getDateMidnight();
  /**
   * Retrieve the system time as a Joda LocalDate object.
   * 
   * @return - LocalDate - a Joda LocalDate object that contains
   * the system time.
   */
  public LocalDate getLocalDate();
  /**
   * Retrieve the system time as a Joda LocalTime object.
   * 
   * @return - LocalTime - a Joda LocalTime object that contains
   * the system time.
   */
  public LocalTime getLocalTime();
  /**
   * Retrieve the system time as a JDK Date object.
   * 
   * @return - Date - the system time as JDK Date
   */
  public Date getDate();
  /**
   * Retrieve the system time as a JDK Calendar object.
   * 
   * @return - Calendar - the system time as JDK Calendar
   */
  public Calendar getCalendar();
}
