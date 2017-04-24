package signin;

/**
 * Created by verenaseverina on 4/23/17.
 */
public class MvcSignIn {
  SignInModel siModel = new SignInModel();
  SignInView siView = new SignInView();

  SignInController siController = new SignInController(siView, siModel);
}
