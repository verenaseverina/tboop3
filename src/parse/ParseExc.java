package parse;

/**
 *
 * @author nim_13515091
 */
public class ParseExc extends Exception {
  /**
   * @param msg the detail message.
   */
  public ParseExc(String msg) {
    super(msg);
  }
  
  /**
   * @param cause throwable
   */
  public ParseExc(Throwable cause) {
    super(cause);
  }
  
  /**
   * @param msg the detail message.
   * @param cause throwable
   */
  public ParseExc(String msg, Throwable cause) {
    super(msg, cause);
  }
}
