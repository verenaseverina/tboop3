package signin;

/**
 *
 * @author nim_13515091
 */
public class SignInModel {
  private String id;
  private String pass;
  private String description;
  
  public SignInModel() {
    id = "0";
    pass = "";
    description = "";
  }
  
  public String getId() {
    return id;
  }
  
  public String getPass() {
    return pass;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setId(String idBool) {
    id = idBool;
  }
  
  public void setPass(String passw) {
    pass = passw;
  }
  
  public void setDescription(String desc) {
    description = desc;
  }
}
