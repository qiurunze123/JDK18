package com.geekq.jdk18.jodatime.joda;

import com.geekq.jdk18.jodatime.joda.factory.SystemFactory;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormattingTime {
  private static Logger log = LoggerFactory.getLogger(FormattingTime.class);
  public static void main(String[] args) {
    
    example4_1();
    example4_2();
    
  }
  
  private static void example4_1() {
    DateTime dateTime = SystemFactory.getClock().getDateTime();
    log.info("Using ISODateTimeFormat.basicDateTime: " + 
        dateTime.toString(ISODateTimeFormat.basicDateTime())
    );
    log.info("Using ISODateTimeFormat.basicDateTimeNoMillis: " + 
        dateTime.toString(ISODateTimeFormat.basicDateTimeNoMillis())
    );
    log.info("Using ISODateTimeFormat.basicOrdinalDateTime: " + 
        dateTime.toString(ISODateTimeFormat.basicOrdinalDateTime())
    );
    log.info("Using ISODateTimeFormat.basicWeekDateTime: " + 
        dateTime.toString(ISODateTimeFormat.basicWeekDateTime())
    );
  }

  private static void example4_2() {
    DateTime dateTime = SystemFactory.getClock().getDateTime();
    log.info("Using MM/dd/yyyy hh:mm:ss.SSSa: " + 
        dateTime.toString("MM/dd/yyyy hh:mm:ss.SSSa")
    );
    log.info("Using dd-MM-yyyy HH:mm:ss: " + 
        dateTime.toString("dd-MM-yyyy HH:mm:ss")
    );
    log.info("Using EEEE dd MMMM, yyyy HH:mm:ss: " + 
        dateTime.toString("EEEE dd MMMM, yyyy HH:mm:ss")
    );
    log.info("Using MM/dd/yyyy HH:mm ZZZZ: " + 
        dateTime.toString("MM/dd/yyyy HH:mm ZZZZ")
    );
    log.info("Using MM/dd/yyyy HH:mm Z: " + 
        dateTime.toString("MM/dd/yyyy HH:mm Z")
    );
  }
}
