package membershipLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DelMember extends JPanel {
	
	JLabel DelImage = new JLabel("회원 탈퇴 완료", JLabel.CENTER);
	
	public DelMember() {
		super(new GridLayout(1, 1));
		initViews();
	}
	
	private void initViews(){
		setBackground(Color.white);
		add(DelImage);
	}
}
