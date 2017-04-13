
/**
 *
 * @author nim_13515091
 */
public class Record {
  private String date;
  private long amount;
  private String description;
  private String category;
  
  public Record (String tgl, String jml, String desc,String cat) {
    date = tgl;
    amount = Long.decode(jml);
    description = desc;
    category = cat;
  }
  
  public Record (String tgl, String jml, String desc) {
    date = tgl;
    amount = Long.decode(jml);
    description = desc;
    category = "";
  }
  
  public void setDate(String tgl) {
    date = tgl;
  }
  
  public void setAmount(String jml) {
    amount = Long.getLong(jml);
  }
  
  public void setCategory(String cat) {
    category = cat;
  }
  
  public void setDescription(String desc) {
    description = desc;
  }
  
  public String getDate() {
    return date;
  }
  
  public long getAmount() {
    return amount;
  }
  
  public String getCategory() {
    return category;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void printRecord() {
    System.out.println(date);
    System.out.println(amount);
    System.out.println(category);
    System.out.println(description);
  }
}
