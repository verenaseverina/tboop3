
/**
 *
 * @author nim_13515091
 */
public class SIController {
  private SIModel signIn;
  
  public SIController(Parse parser) {
    signIn.setId(parser.getPassword()[0]);
    signIn.setPass(parser.getPassword()[1]);
    signIn.setDescription(parser.getPassword()[2]);
  }
  
  public boolean isLock() {
    return (Integer.getInteger(signIn.getId())==1);
  }
  
  public void changePassword(String id, String pass, String desc) {
    signIn.setId(id);
    signIn.setPass(pass);
    signIn.setDescription(desc);
  }
  
  public boolean validatePassword(String pass) {
    return (pass.compareTo(signIn.getPass()) == 0);
  }
}
