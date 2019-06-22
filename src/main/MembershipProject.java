package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import membershipLayout.*;

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
		setEvent();
		startPanel();
		initWindowSetting();
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
				if (loginID.getIDTextFlied().equals("")) {
					loginID.errVis();
					loginID.setFoucesID();
				} else if (loginID.getIDTextFlied().contains(" ")) {
					loginID.errVis();
					loginID.setFoucesID();
				} else if (false) {
					// --------------------------------------------------------------------------------------문제
					// 내역
				} else {

					loginID.clrerrVis();
					loginID.clrtext();
					remove(loginID);
					add(loginPW);
					loginPW.setFoucesPW();
					revalidate();
					repaint();
				}

			}

			@Override
			public void onClickCreat() {
				getContentPane().remove(loginID);
				getContentPane().add(creativeMember);
				creativeMember.setFoucesID();
				revalidate();
				repaint();

			}
		});
		loginPW.setUserActionListener(new LoginPW.UserActionListener() {

			@Override
			public void onClickNext() {
				System.out.println("다음 출력");
				if (loginPW.getPWTextFlied().equals("")) {
					loginPW.errVis();
					loginPW.setFoucesPW();
				} else if (loginPW.getPWTextFlied().contains(" ")) {
					loginPW.errVis();
					loginPW.setFoucesPW();
				} else if (false) {
					// --------------------------------------------------------------------------------------문제
					// 내역
				} else {

					loginPW.clrerrVis();
					loginPW.clrtext();

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
				creativeMember.setFoucesID();
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

				// ------------------------------------------------------------------------------------
				// 쓰레드 넣기
//				remove(delMember);
//				add(loginID);
//				loginID.setFoucesID();
//				revalidate();
//				repaint();

			}

			@Override
			public void onClickNext() {
				upDateMember.errVisclr();
				int errFlag = 0;

				if (upDateMember.getNickTextFlied().equals("")) {
					upDateMember.errVisNick();
					upDateMember.setFoucesNick();
					errFlag = 1;
				} else if (upDateMember.getNickTextFlied().contains(" ")) {
					upDateMember.errVisNick();
					upDateMember.setFoucesNick();
					errFlag = 1;
				}
				if (upDateMember.getPWTextFlied().equals("")) {
					upDateMember.errVisPW();
					upDateMember.setFoucesPW();
					errFlag = 1;
				} else if (upDateMember.getPWTextFlied().contains(" ")) {
					upDateMember.errVisPW();
					upDateMember.setFoucesPW();
					errFlag = 1;
				}
				if (upDateMember.getIDTextFlied().equals("")) {
					upDateMember.errVisID();
					upDateMember.setFoucesID();
					errFlag = 1;
				} else if (upDateMember.getIDTextFlied().contains(" ")) {
					upDateMember.errVisID();
					upDateMember.setFoucesID();
					errFlag = 1;
				}

				if (errFlag == 0) {
					upDateMember.errVisclr();
					upDateMember.tFdclr();
					loginID.clrtext();
					remove(upDateMember);
					add(mainMember);
					revalidate();
					repaint();
				}
			}
		});

		creativeMember.setUserActionListener(new CreativeMember.UserActionListener() {

			@Override
			public void onClickNext() {
				creativeMember.errVisclr();
				int errFlag = 0;

				if (creativeMember.getNickTextFlied().equals("")) {
					creativeMember.errVisNick();
					creativeMember.setFoucesNick();
					errFlag = 1;
				} else if (creativeMember.getNickTextFlied().contains(" ")) {
					creativeMember.errVisNick();
					creativeMember.setFoucesNick();
					errFlag = 1;
				}
				
				if (creativeMember.getPWTextFlied().equals("")) {
					creativeMember.errVisPW();
					creativeMember.setFoucesPW();
					errFlag = 1;
				} else if (creativeMember.getPWTextFlied().contains(" ")) {
					creativeMember.errVisPW();
					creativeMember.setFoucesPW();
					errFlag = 1;
				}
				if (creativeMember.getIDTextFlied().equals("")) {
					creativeMember.errVisID();
					creativeMember.setFoucesID();
					errFlag = 1;
				} else if (creativeMember.getIDTextFlied().contains(" ")) {
					creativeMember.errVisID();
					creativeMember.setFoucesID();
					errFlag = 1;
				}
				if (errFlag == 0) {
					creativeMember.errVisclr();
					creativeMember.tFdclr();
					loginID.clrtext();
					remove(creativeMember);
					add(loginID);
					loginID.setFoucesID();
					revalidate();
					repaint();
				}
			}

			@Override
			public void onClickNew() {
				creativeMember.errVisclr();
				creativeMember.allreset();
				creativeMember.setFoucesID();

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

	void startPanel() {
		add(loginID, BorderLayout.CENTER);

	}
}
