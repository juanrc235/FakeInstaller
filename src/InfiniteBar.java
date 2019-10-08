import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InfiniteBar extends JPanel {

  JProgressBar pbar;

  static final int MY_MINIMUM = 0;
  static final int DELAY = 500;
  static final int MY_MAXIMUM = DELAY;

  public InfiniteBar(int x, int y) {
	  	
	  	
	    JFrame frmFakeInstaller = new JFrame("Visual Paradigm Installer");
	    frmFakeInstaller.setTitle("Fake Installer");
	    frmFakeInstaller.setResizable(false);
	    frmFakeInstaller.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frmFakeInstaller.setVisible(true);
		frmFakeInstaller.setBounds(x, y, 450, 159);
	
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmFakeInstaller.setContentPane(contentPane);
		contentPane.setLayout(null);
		

		pbar = new JProgressBar();
		pbar.setBounds(12, 46, 420, 31);
		pbar.setMinimum(MY_MINIMUM);
	    pbar.setMaximum(MY_MAXIMUM);
	    pbar.setForeground(Color.GRAY);
	    pbar.setToolTipText("Installing");
	    pbar.setStringPainted(true);
		contentPane.add(pbar);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Fake Program Installer ");
		lblWelcomeToThe.setFont(new Font("Dubai Medium", Font.BOLD, 13));
		lblWelcomeToThe.setBounds(92, 17, 258, 16);
		contentPane.add(lblWelcomeToThe);
		
		JLabel lblInstalling = new JLabel("Installing ... " );
		lblInstalling.setFont(new Font("Dubai Medium", Font.BOLD, 13));
		lblInstalling.setBounds(170, 90, 81, 16);
		contentPane.add(lblInstalling);
		
		frmFakeInstaller.setIconImage(Toolkit.getDefaultToolkit().getImage(InfiniteBar.class.getResource("/Images/logoFrame.png")));
  }

  public void updateBar(int newValue) {
    pbar.setValue(newValue);
  }

  public static void main(String args[]) {

    final InfiniteBar it = new InfiniteBar(100, 100);
    
    // run a loop to demonstrate raising
    while(true) {
	    for (int i = MY_MINIMUM; i <= MY_MAXIMUM; i++) {
	      final int percent = i;
	      try {
	        SwingUtilities.invokeLater(new Runnable() {
	          public void run() {
	            it.updateBar(percent);  
	          }
	        });
	        java.lang.Thread.sleep(DELAY);
	      } catch (InterruptedException e) {
	        ;
	      }
	    }
	    
    }
  }
}

