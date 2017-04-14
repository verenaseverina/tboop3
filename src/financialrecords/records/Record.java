package financialrecords.records;

/**
 *
 * Kelas yang berisi data keuangan.
 * Kelas financialrecords.records.Record memiliki atribut string date, long amount, string description,
 * dan string category
 * 
 * @author Winarto
 * @author Kukuh B R
 */
public class Record {
  /**
   * Atribut String dari parse (date) yang menyimpan tanggal.
   */
  private NewDate date;
  /**
   * Atribut long dari parse (amount) yang menyimpan nilai uang.
   */
  private long amount;
  /**
   * Atribut String dari parse (description) yang menyimpan deskripsi.
   */
  private String description;
  /**
   * Atribut String dari parse (category) yang menyimpan kategori pemakaian.
   */
  private String category;
  
  /**
   * Menginisialisasi semua atribut dengan string masukkan.
   * 
   * @param tgl untuk mengisi date
   * @param jml untuk mengisi amount
   * @param desc untuk mengisi description
   * @param cat untuk mengisi category
   */
  public Record (String tgl, String jml, String desc,String cat) {
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
  public Record (String tgl, String jml, String desc) {
    date = new NewDate(tgl);
    amount = Long.decode(jml);
    description = desc;
    category = "";
  }
  
  /**
   * Setter date.
   * @param tgl mengisi date
   */  
  public void setDate(String tgl) {
    date.copyDate(tgl);
  }
  
  /**
   * Setter amount.
   * @param jml menisi amount
   */  
  public void setAmount(String jml) {
    amount = Long.decode(jml);
  }
  
  /**
   * Setter category.
   * @param cat mengisi category
   */  
  public void setCategory(String cat) {
    category = cat;
  }
  
  /**
   * Setter description.
   * @param desc mengisi description
   */  
  public void setDescription(String desc) {
    description = desc;
  }
  
  /**
   * Getter date.
   * @return date
   */  
  public NewDate getDate() {
    return date;
  }
  
  /**
   * Getter amount.
   * @return amount
   */  
  public long getAmount() {
    return amount;
  }
  
  /**
   * Getter category.
   * @return category
   */  
  public String getCategory() {
    return category;
  }
  
  /**
   * Getter description.
   * @return description
   */  
  public String getDescription() {
    return description;
  }
}
