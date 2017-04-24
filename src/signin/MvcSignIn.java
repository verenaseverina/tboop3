package signin;

/**
 * Created by verenaseverina on 4/23/17.
 */
public class MvcSignIn {
  SignInModel siModel = new SignInModel();

  public void checkPassword() {
    if(siModel.isLock()) {
      SignInView siView = new SignInView();
      SignInController siCOntroller = new SignInController(siView, siModel);
    } else {

    }
  }

//  SignInView siView = new SignInView();
//
//  SignInController siController = new SignInController(siView, siModel);
}
