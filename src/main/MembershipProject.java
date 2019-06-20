package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import membershipLayout.*;
import myValue.MyApi;

public class MembershipProject extends JFrame {

	JPanel[] emtpy = { new JPanel(), new JPanel(), new JPanel(), new JPanel() };
	LoginID loginID = new LoginID();
	LoginPW loginPW = new LoginPW();
	CreativeMember creativeMember = new CreativeMember();
	UpDateMember upDateMember = new UpDateMember();
	DelMember delMember = new DelMember();
	MainMember mainMember = new MainMember();

	MembershipProject() {
		super("membership");
		initViews();
		initWindowSetting();
		setEvent();
		start();
	}

	void initViews() {

		emtpy[0].setBackground(Color.white);
		emtpy[0].setPreferredSize(new Dimension(63, 700));
		emtpy[1].setBackground(Color.white);
		emtpy[1].setPreferredSize(new Dimension(49, 700));
		emtpy[2].setBackground(Color.white);
		emtpy[3].setBackground(Color.white);
		emtpy[2].setPreferredSize(new Dimension(500, 51));
		add(emtpy[0], BorderLayout.WEST);
		add(emtpy[1], BorderLayout.EAST);
		add(emtpy[2], BorderLayout.SOUTH);
		add(emtpy[3], BorderLayout.NORTH);
	}

	void initWindowSetting() {
		setSize(500, 700);
		setVisible(true);
		setResizable(false);
	}

	private void setEvent() {
		loginID.setUserActionListener(new LoginID.UserActionListener() {
			
			@Override
			public void onClickNext() {
				System.out.println("id 출력");
				if(loginID.getIDTextFlied().equals("")) {
					loginID.errVis();
				} else if(false) {
					//--------------------------------------------------------------------------------------문제 내역
				} else {
					loginID.clrerrVis();
					loginID.clrtext();
					
					remove(loginID);
					add(loginPW);
					revalidate();
					repaint();
				}
				
			}
			
			@Override
			public void onClickCreat() {
				getContentPane().remove(loginID);
				getContentPane().add(creativeMember);
				revalidate();
				repaint();
				
			}
		});
		loginPW.setUserActionListener(new LoginPW.UserActionListener() {
			
			@Override
			public void onClickNext() {
				System.out.println("다음 출력");
				if(loginPW.getPWTextFlied().equals("")) {
					loginPW.errVis();
				} else if(false) {
					//문제 내역
				} else {
					remove(loginPW);
					add(mainMember);
					revalidate();
					repaint();
				}
				
			}
				
			
			
			@Override
			public void onClickCreat() {
				remove(loginPW);
				add(creativeMember);
				revalidate();
				repaint();
				
			}
		});
		upDateMember.setUserActionListener(new UpDateMember.UserActionListener() {
			
			@Override
			public void onClickRemove() {
				remove(upDateMember);
				add(delMember);
				revalidate();
				repaint();
				
				//------------------------------------------------------------------------------------ 쓰레드 넣기
				remove(delMember);
				add(loginID);
				revalidate();
				repaint();
				
			}
			
			@Override
			public void onClickNext() {
				remove(upDateMember);
				add(mainMember);
				revalidate();
				repaint();
				
			}
		});
		
		creativeMember.setUserActionListener(new CreativeMember.UserActionListener() {
			
			@Override
			public void onClickNext() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onClickNew() {
				// TODO Auto-generated method stub
				
			}
		});
		
		mainMember.setUserActionListener(new MainMember.UserActionListener() {
			@Override
			public void onClickStart() {
				new AlgorithmProject(); 
				setVisible(false);
				
			}

			@Override
			public void onClickUpdate() {
				remove(mainMember);
				add(upDateMember);
				revalidate();
				repaint();
			}
		});
		
		 
		
	}

	void start() {
		add(loginID, BorderLayout.CENTER);
		
	}
//	void testPnladd() {
//	
//
//	}
}
