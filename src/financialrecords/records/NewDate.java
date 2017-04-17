package financialrecords.records;

/**
 * Kelas untuk tanggal.
 * Kelas financialrecords.records.NewDate memiliki atribut String untuk hari,
 * String untuk bulan, dan String untuk tahun
 *
 * @author Kukuh B R
 * @author Adrian Hartanto
 */
public class NewDate {
  /**
   * Atribut utnuk menyimpan hari dari tanggal.
   */
  private String day;
  /**
   * Atribut utnuk menyimpan bulan dari tanggal.
   */
  private String month;
  /**
   * Atribut utnuk menyimpan tahun dari tanggal.
   */
  private String year;

  /**
   * Ctor NewDate.
   * @param tanggal adalah String yang akan dibentuk menjadi NewDate
   */
  public NewDate(String tanggal) {
    String dd = tanggal.substring(0, 2);
    String mm = tanggal.substring(3, 5);
    String yy = tanggal.substring(6, 10);
    day = dd;
    month = mm;
    year = yy;
  }

  /**
   * Method copy NewDate.
   * @param tanggal adalah tanggal yang hendak di-copy
   */
  public void copyDate(String tanggal) {
    String dd = tanggal.substring(0, 2);
    String mm = tanggal.substring(3, 5);
    String yy = tanggal.substring(6, 10);
    day = dd;
    month = mm;
    year = yy;
  }

  /**
   * Konversi dari NewDate ke String.
   * @return hasil konversi dari NewDate ke String
   */
  public String dateToStr() {
    String date = day;
    date = date.concat("/");
    date = date.concat(month);
    date = date.concat("/");
    date = date.concat(year);
    return date;
  }

  /**
   * Getter day.
   * @return day
   */
  public String getDay() {
    return day;
  }

  /**
   * Getter month.
   * @return month
   */
  public String getMonth() {
    return month;
  }

  /**
   * Getter year.
   * @return year
   */
  public String getYear() {
    return year;
  }

  /**
   * Setter day.
   * @param dd String yang akan diassign ke day
   */
  public void setDay(String dd) {
    day = dd;
  }

  /**
   * Setter month.
   * @param mm String yang akan diassign ke month
   */
  public void setMonth(String mm) {
    month = mm;
  }


  /**
   * Setter year.
   * @param yy String yang akan diassign ke year
   */
  public void setYear(String yy) {
    year = yy;
  }

  /**
   * Mengecek apakah dua tanggal berada di minggu yang sama.
   * @param date2 pembanding tanggal objek
   * @return apakah dua tanggal berada di minggu yang sama
   */
  public boolean isOneWeek(NewDate date2) {
    int day1 = Integer.getInteger(this.getMonth());
    int day2 = Integer.getInteger(date2.getMonth());
    boolean monthEquals = this.getDay().equals(date2.getDay());
    boolean yearEquals = this.getYear().equals(date2.getYear());
    return (monthEquals && yearEquals && (day1 + 7 == day2));
  }

  /**
   * Mengecek apakah dua tanggal berada di bulan yang sama.
   * @param date2 pembanding tanggal objek
   * @return apakah dua tanggal berada di bulan yang sama
   */
  public boolean isOneMonth(NewDate date2) {
    int month1 = Integer.getInteger(this.getMonth());
    int month2 = Integer.getInteger(date2.getMonth());
    boolean dayEquals = this.getDay().equals(date2.getDay());
    boolean yearEquals = this.getYear().equals(date2.getYear());
    return (dayEquals && yearEquals && (month1 + 1 == month2));
  }

  /**
   * Mengecek apakah dua tanggal berada di tahun yang sama.
   * @param date2 pembanding tanggal objek
   * @return apakah dua tanggal berada di tahun yang sama
   */
  public boolean isOneYear(NewDate date2) {
    int year1 = Integer.getInteger(this.getYear());
    int year2 = Integer.getInteger(date2.getYear());
    boolean dayEquals = this.getDay().equals(date2.getDay());
    boolean monthEquals = this.getMonth().equals(date2.getMonth());
    return (dayEquals && monthEquals && (year1 + 1 == year2));
  }
  
}
