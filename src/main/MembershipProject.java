package main;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MembershipProject extends JFrame {

	JPanel[] emtpy = { new JPanel(), new JPanel(), new JPanel(), new JPanel() };

	MembershipProject() {
		super("membership");
		initViews();
		initWindowSetting();
	}

	void initViews() {
		add(emtpy[0], BorderLayout.WEST);
		add(emtpy[1], BorderLayout.EAST);
		add(emtpy[2], BorderLayout.SOUTH);
		add(emtpy[3], BorderLayout.NORTH);
		emtpy[0].setBackground(Color.white);
		emtpy[1].setBackground(Color.white);
		emtpy[2].setBackground(Color.white);
		emtpy[3].setBackground(Color.white);
	}
	
	void initWindowSetting(){
		setSize(500, 700);
		setVisible(true);
		setResizable(true);
	}
}
