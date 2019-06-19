package membershipLayout;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginID extends JPanel {
	
	//Center
	JPanel pnlTitle = new JPanel(new GridLayout(1, 1));
	JLabel lblTitleimage;
	
	JPanel pnlIDWrite = new JPanel(new BorderLayout());
	JLabel lblID = new JLabel("ID", JLabel.LEFT);
	JLabel lblIDERR = new JLabel("", JLabel.RIGHT);
	JTextField tfIDWrite = new JTextField();
//	JLabel lblIDERR = new JLabel(" id를 제대로 입력하세요", JLabel.CENTER);
	
	//South
	JPanel pnlMenu = new JPanel(new BorderLayout());
	JButton btnCreateId = new JButton("계정만들기");
	JButton btnNextImage = new JButton();
	
	
	LoginID(){
		super(new BorderLayout());
		
	}
}
