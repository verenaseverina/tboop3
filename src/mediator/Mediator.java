package mediator;

import financialrecords.FinancialRecordController;
import parse.Parse;
import parse.ParseExc;
import setting.SettingController;
import signin.SignInController;

/**
 * Kelas Mediator untuk menghubungkan kelas-kelas controller.
 * Kelas Mediator memiliki atribut FinancialRecordController, SettingController,
 * SignInController, dan Parse
 *
 * @author Winarto
 * @author Kukuh B R
 */
public class Mediator {
  /**
   * Atribut FinancialRecordController.
   */
  private FinancialRecordController frControl;
  /**
   * Atribut SettingController.
   */
  private SettingController settingControl;
  /**
   * Atribut SignInController.
   */
  private SignInController signInControl;
  /**
   * Atribut Parse.
   */
  private Parse parser;

  /**
   * Constructor Mediator.
   */
  public Mediator() throws ParseExc {
    parser = new Parse();
    signInControl = new SignInController(this,parser);
    frControl = new FinancialRecordController(this,parser);
    settingControl = new SettingController(this);
  }

  /**
   * Prosedur untuk menyimpan data pengeluaran dan pemasukan.
   */
  public void saveSavings(int amount) {
    frControl.updateSavings(amount);
    frControl.saveData();
  }

  /**
   * Prosedur untuk mengambil data pengeluaran dan pemasukan.
   */
  public long getSavings() {
    return frControl.getSavings();
  }

  /**
   * Prosedur untuk menghapus semua pengeluaran dan pemasukan.
   */
  public void deleteInOut(){
    for(int i=0;i<frControl.getOutcome().size();i++) {
      frControl.deleteExpense(i);
    }
    for(int i=0;i<frControl.getIncome().size();i++) {
      frControl.deleteIncome(i);
    }
    frControl.deleteTable();
    frControl.updateSavings(0);
    frControl.saveData();
  }

  /**
   * Getter signInId.
   * @return signInId
   */
  public String getSignInID() {
    return signInControl.getSignInID();
  }

  /**
   * Getter signInPass.
   * @return signInPass
   */
  public String getSignInPass() {
    return signInControl.getSignInPass();
  }

  /**
   * Getter signInDesc.
   * @return signInDesc
   */
  public String getSignInDesc() {
    return signInControl.getSignInDesc();
  }

  /**
   * Menyimpan informasi signin.
   * @param id Status dikunci atau tidak
   * @param pass Password untuk membuka aplikasi
   * @param desc Hint yang digunakan pengguna
   */
  public void saveSignInState(String id, String pass, String desc) {
    signInControl.changePassword(id,pass,desc);
  }

  /**
   * Prosedur untuk menampilkan atau menyembunyikan tampilan setting.
   * @param state kondisi untuk menampilkan atau menyembunyikan
   */
  public void setSettingVisible(boolean state) {
    settingControl.visible(state);
  }

  /**
   * Prosedur untuk menampilkan atau menyembunyikan tampilan sign in.
   * @param state kondisi untuk menampilkan atau menyembunyikan
   */
  public void setSignInVisible(boolean state){
    signInControl.visible(state);
  }

  /**
   * Prosedur untuk menampilkan atau menyembunyikan tampilan financial record.
   * @param state kondisi untuk menampilkan atau menyembunyikan
   */
  public void setFrControlVisible(boolean state){
    frControl.visible(state);
  }
}
