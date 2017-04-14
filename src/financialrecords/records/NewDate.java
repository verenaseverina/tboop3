package financialrecords.records;

/**
 *
 * @author nim_13515091
 */
public class NewDate {
  private String day;
  private String month;
  private String year;
  
  public NewDate(String tanggal) {
    String dd = tanggal.substring(0, 2);
    String mm = tanggal.substring(3, 5);
    String yy = tanggal.substring(6, 10);
    day = dd;
    month = mm;
    year = yy;
  }
  public void copyDate(String tanggal) {
    String dd = tanggal.substring(0, 2);
    String mm = tanggal.substring(3, 5);
    String yy = tanggal.substring(6, 10);
    day = dd;
    month = mm;
    year = yy;
  }
  
  public String dateToStr() {
    String date = day;
    date = date.concat("/");
    date = date.concat(month);
    date = date.concat("/");
    date = date.concat(year);
    return date;
  }
  
  public String getDay() {
    return day;
  }
  
  public String getMonth() {
    return month;
  }
  
  public String getYear() {
    return year;
  }
  
  public void setDay(String dd) {
    day = dd;
  }
  
  public void setMonth(String mm) {
    month = mm;
  }
  
  public void setYear(String yy) {
    year = yy;
  }
  
  public boolean isOneWeek(NewDate date1, NewDate date2) {
    int day1 = Integer.getInteger(date1.getMonth());
    int day2 = Integer.getInteger(date2.getMonth());
    boolean monthEquals = date1.getDay().equals(date2.getDay());
    boolean yearEquals = date1.getYear().equals(date2.getYear());
    return (monthEquals && yearEquals && (day1 + 7 == day2));
  }
  
  public boolean isOneMonth(NewDate date1, NewDate date2) {
    int month1 = Integer.getInteger(date1.getMonth());
    int month2 = Integer.getInteger(date2.getMonth());
    boolean dayEquals = date1.getDay().equals(date2.getDay());
    boolean yearEquals = date1.getYear().equals(date2.getYear());
    return (dayEquals && yearEquals && (month1 + 1 == month2));
  }
  
  public boolean isOneYear(NewDate date1, NewDate date2) {
    int year1 = Integer.getInteger(date1.getYear());
    int year2 = Integer.getInteger(date2.getYear());
    boolean dayEquals = date1.getDay().equals(date2.getDay());
    boolean monthEquals = date1.getMonth().equals(date2.getMonth());
    return (dayEquals && monthEquals && (year1 + 1 == year2));
  }
  
}
