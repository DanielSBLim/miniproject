package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import membershipLayout.*;

public class MembershipProject extends JFrame {

	private JPanel[] emtpy = { new JPanel(), new JPanel(), new JPanel(), new JPanel() };
	private LoginID loginID = new LoginID();
	private LoginPW loginPW = new LoginPW();
	private	CreativeMember creativeMember = new CreativeMember();
	private UpdateMember updateMember = new UpdateMember();
	private DelMember delMember = new DelMember();
	private MainMember mainMember = new MainMember();

	public MembershipProject() {
		super("membership");
		initViews();
		setEvent();
		startPanel();
		initWindowSetting();
	}

	private void initViews() {

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

	private void initWindowSetting() {
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
		updateMember.setUserActionListener(new UpdateMember.UserActionListener() {

			@Override
			public void onClickRemove() {
				remove(updateMember);
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
				updateMember.errVisclr();
				int errFlag = 0;

				if (updateMember.getNickTextFlied().equals("")) {
					updateMember.errVisNick();
					updateMember.setFoucesNick();
					errFlag = 1;
				} else if (updateMember.getNickTextFlied().contains(" ")) {
					updateMember.errVisNick();
					updateMember.setFoucesNick();
					errFlag = 1;
				}
				if (updateMember.getPWTextFlied().equals("")) {
					updateMember.errVisPW();
					updateMember.setFoucesPW();
					errFlag = 1;
				} else if (updateMember.getPWTextFlied().contains(" ")) {
					updateMember.errVisPW();
					updateMember.setFoucesPW();
					errFlag = 1;
				}

				if (errFlag == 0) {
					updateMember.errVisclr();
					updateMember.tFdclr();
					loginID.clrtext();
					remove(updateMember);
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
					creativeMember.tfClr();
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
				creativeMember.tfClr();
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
				add(updateMember);
				revalidate();
				repaint();
			}
		});

	}

	private void startPanel() {
		add(loginID, BorderLayout.CENTER);

	}
}
