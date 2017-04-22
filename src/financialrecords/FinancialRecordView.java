package financialrecords;

import java.awt.*;
import javax.swing.*;

public class FinancialRecordView extends JFrame {
  // bisa tambahin ga dia lagi nampilin apaan
  private int width = 750;
  private int height = 500;

  public FinancialRecordView() {
    this.setVisible(true);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JPanel controls = new JPanel();
    controls.setSize(200,500);
    controls.setBackground(Color.white);
    controls.setVisible(true);

    JPanel glass = new JPanel();
    glass.setSize(550,500);
    glass.setBackground(Color.black);
    glass.setVisible(true);

    // biar resizable pake JSplitPane
    JSplitPane splitPane = new JSplitPane();
    splitPane.setSize(width,height);
    splitPane.setDividerSize(0);
    splitPane.setDividerLocation(200);
    splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
    splitPane.setLeftComponent(controls);
    splitPane.setRightComponent(glass);

    this.add(splitPane);
  }
}