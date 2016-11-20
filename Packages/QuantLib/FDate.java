package Packages.QuantLib;

import java.util.*;
import java.text.*;
import java.lang.Math.*;

public class FDate{
  private final String[] months = {"January", "February", "March", "April", "May", "June", "July",
                                   "August", "September", "October", "November", "December"};

  private final String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday",
                                  "Friday", "Saturday", "Sunday"};

  private final SimpleDateFormat sdf;
  private final long MDC = 86400000;   //Milliseconds to days conversion constant
  private Date date;
  private int day;
  private int month;
  private int year;

  //Default constructor for FDate object
  public FDate(int new_day, int new_month, int new_year) {
    sdf = new SimpleDateFormat("dd-MM-yyyy");  //Modify date format
    this.day = new_day;
    this.month = new_month;
    this.year = new_year;
    
    //Set data string for date format
    String dateInput = Integer.toString(new_day)
                       + "-" + Integer.toString(new_month)
                       + "-" + Integer.toString(new_year);

    //Attempt to parse input data for date
    try{
      date = sdf.parse(dateInput);
    }
    catch(ParseException e) {
      System.out.println("ERROR: " + e);
      System.out.println("Cannot parse " + sdf);
    }
  }

  //Function to change date
  public void changeDate(int new_day, int new_month, int new_year) {
    this.day = new_day;
    this.month = new_month;
    this.year = new_year;

    String dateInput = Integer.toString(new_day)
                       + "-" + Integer.toString(new_month)
                       + "-" + Integer.toString(new_year);

    String input = dateInput;

    //Attempt to parse input data for date
    try{
      date = sdf.parse(input);
    }
    catch(ParseException e) {
      System.out.println("ERROR: " + e);
      System.out.println("Cannot parse " + sdf);
    }
  }

  public void printDate() { System.out.println(this.date.toString()); }    //return string of date
  public Date getDate() { return this.date; }                              //Function to return Date as java data form
  public String getStringMonth() { return months[month-1];}                //Function to return string month
  public int getDay() { return this.day; }                                 //Function to return this (int) day
  public int getMonth() { return this.month; }                             //Function to return this (int) month
  public int getYear() { return this.year; }                               //Function to return this (int) year

  //Function to return string day
  public String getStringDay() {
    long time = date.getTime();
    int daysPast = (int)(time / MDC);
    daysPast = (daysPast + 4) % 7;
    return days[daysPast];
  }

  //return days between date
  public int daysBetween(FDate endDate) {
      long startTime = date.getTime();
      long endTime = endDate.getDate().getTime();
      return (int)Math.abs((startTime - endTime)/(MDC));
  }

  //function to add days to create a new fDate
  public Date dateAddDays(int days) {
    long startTime = date.getTime();
    long addTime = days * MDC;

    Date temp = new Date(01, 01, 1970);
    temp.setTime(addTime);
    return temp;
  }
}
