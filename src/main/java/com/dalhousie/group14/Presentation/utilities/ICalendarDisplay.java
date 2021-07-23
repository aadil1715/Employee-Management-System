package com.dalhousie.group14.Presentation.utilities;

public interface ICalendarDisplay {

  void display(int year);

  void displayMonths(int year, int month);

  void displayThreeMonths(int year, int current_month);

  void displayCurrentMonth(int year, int current_month);
}
