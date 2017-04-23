package financialrecords.records;

/**
 *
 * Kelas yang berisi data keuangan.
 * Kelas Record memiliki atribut string date, long amount, string description,
 * dan string category
 * 
 * @author Winarto
 * @author Kukuh B R
 */
public abstract class Record {
  /**
   * Atribut String dari parse (date) yang menyimpan tanggal.
   */
  protected NewDate date;
  /**
   * Atribut long dari parse (amount) yang menyimpan nilai uang.
   */
  protected long amount;
  /**
   * Atribut String dari parse (description) yang menyimpan deskripsi.
   */
  protected String description;
  /**
   * Atribut String dari parse (category) yang menyimpan kategori pemakaian.
   */
  protected String category;
  
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
