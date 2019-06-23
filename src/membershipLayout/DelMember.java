package membershipLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DelMember extends JPanel {
	
	private JLabel DelImage = new JLabel("", JLabel.CENTER);
	
	public DelMember() {
		super(new GridLayout(1, 1));
		createViews();
	}
	
	private void createViews(){
		setBackground(Color.white);
		DelImage.setIcon(new ImageIcon("./menber/delMember.jpg"));
		add(DelImage);
	}
}
