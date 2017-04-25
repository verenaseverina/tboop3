package mediator;

import financialrecords.FinancialRecordController;
import parse.Parse;
import setting.SettingController;
import signin.SignInController;

/**
 * Created by Winarto on 04/25/2017.
 */
public class Mediator {
  private FinancialRecordController frControl;
  private SettingController settingControl;
  private SignInController signInControl;
  private Parse parser;

  public Mediator() {
    parser = new Parse();
    signInControl = new SignInController(this,parser);
    frControl = new FinancialRecordController(this,parser);
    settingControl = new SettingController(this);
  }

  /**
   * Prosedur untuk menyimpan data pengeluaran dan pemasukan
   */
  public void saveSavings(int amount) {
    frControl.updateSavings(amount);
    frControl.saveData();
  }

  /**
   * Prosedur untuk mengambil data pengeluaran dan pemasukan
   */
  public long getSavings() {
    return frControl.getSavings();
  }

  /**
   * Prosedur untuk menghapus semua pengeluaran dan pemasukan
   */
  public void deleteInOut(){
    for(int i=0;i<frControl.getOutcome().size();i++) {
      frControl.deleteExpense(i);
    }
    for(int i=0;i<frControl.getIncome().size();i++) {
      frControl.deleteIncome(i);
    }
    frControl.updateSavings(0);
    frControl.saveData();
  }

  /**
   * Prosedur untuk mengambil id signin
   */
  public String getSignInID() {
    return signInControl.getSignInID();
  }

  /**
   * Prosedur untuk mengambil password signin
   */
  public String getSignInPass() {
    return signInControl.getSignInPass();
  }

  /**
   * Prosedur untuk mengambil deskripsi password
   */
  public String getSignInDesc() {
    return signInControl.getSignInDesc();
  }

  /**
   * Menyimpan informasi signin
   * @param id Status dikunci atau tidak
   * @param pass Password untuk membuka aplikasi
   * @param desc Hint yang digunakan pengguna
   */
  public void saveSignInState(String id, String pass, String desc) {
    signInControl.changePassword(id,pass,desc);
  }

  public void setSettingVisible(boolean state) {
    settingControl.visible(state);
  }

  public void setSignInVisible(boolean state){
    signInControl.visible(state);
  }

  public void setFrControlVisible(boolean state){
    frControl.visible(state);
  }
}
