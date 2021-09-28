package ita.euris.academy.cinema.utils;

import ita.euris.academy.cinema.data.enums.ScreeningTime;

public class UT {

  public static ScreeningTime getScreeningTime(String value) {
    if (value == null) {
      return null;
    }
    for (ScreeningTime time : ScreeningTime.values()) {
      if (time.name().equals(value)) {
        return time;
      }
    }
    return null;
  }
  
  public static String numberToString(Number value) {
    return value == null ? null : value.toString();
  }

  public static Long toLong(String value) {
    return value == null ? null : Long.parseLong(value);
  }
  
  public static Integer toInt(String value) {
    return value == null ? null : Integer.parseInt(value);
  }
  
  public static Double toDouble(String value) {
    return value == null ? null : Double.parseDouble(value);
  }
  
  public static String getScreeningTime(ScreeningTime value) {
    return value == null ? null : value.name();
  }
}
