package com.samy.company.Uber;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PrintDate {

  public static void main(String[] args) {
    String start = "1988-11-05";
    String end = "1993-02-10";
    PrintDate pd = new PrintDate();
    pd.print(start, end);
  }

  public void print(String start, String end) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate startDate = LocalDate.parse(start, dtf);
    LocalDate endDate = LocalDate.parse(end, dtf);

    LocalDate date = startDate;
    while (date.compareTo(endDate) < 0) {
      // print current day
      System.out.println(date);
      // get the last day of month
      date = getLastDayOfMonth(date);
      if (date.compareTo(endDate) < 0)
        System.out.println(date);
      // first day of next month
      date = date.plusDays(1);
    }
    System.out.println(endDate);
  }

  private LocalDate getLastDayOfMonth(LocalDate date) {
    int month = date.getMonthValue();
    int year = date.getYear();
    if (month == 12) {
      year++;
      month = 1;
    } else
      month++;
    return LocalDate.of(year, month, 1).minusDays(1);
  }
}
