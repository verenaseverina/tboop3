package financialrecords.records.recordderivative;

import financialrecords.records.NewDate;
import financialrecords.records.Record;

/**
 * Kelas turunan dari Record yang merepresentasikan pemasukan.
 *
 * @author
 * @author
 */
public class Income extends Record {
  /**
   * Menginisialisasi semua atribut dengan string masukkan.
   *
   * @param tgl untuk mengisi date
   * @param jml untuk mengisi amount
   * @param desc untuk mengisi description
   * @param cat untuk mengisi category
   */
  public Income (String tgl, String jml, String desc,String cat) {
    date = new NewDate(tgl);
    amount = Long.decode(jml);
    description = desc;
    category = cat;
  }

  /**
   * Menginisialisasi semua atribut dengan string masukkan (kecuali category).
   *
   * @param tgl untuk mengisi date
   * @param jml untuk mengisi amount
   * @param desc untuk mengisi description
   */
  public Income (String tgl, String jml, String desc) {
    date = new NewDate(tgl);
    amount = Long.decode(jml);
    description = desc;
    category = "";
  }
}
