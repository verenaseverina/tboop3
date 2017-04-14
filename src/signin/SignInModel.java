package signin;

public class SignInModel {
  private String password;
  private String hint;

  public SignInModel(String password, String hint) {
    this.password = password;
    this.hint = hint;
  }

  public String getPassword() {
    return password;
  }

  public String getHint() {
    return hint;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setHint(String hint) {
    this.hint = hint;
  }
}
