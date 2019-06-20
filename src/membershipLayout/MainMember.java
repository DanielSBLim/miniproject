package membershipLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import myValue.*;

public class MainMember extends JPanel {

	// Center
	JPanel pnlmain = new JPanel(new GridLayout(4, 1));

	// South
	JPanel pnlMenu = new JPanel(new FlowLayout());
	JButton btnStart = new JButton("문제시작");

	// Center inner

	// first
	JPanel pnltitle = new JPanel(new GridLayout(1, 1));
	JLabel lblTitleimage = new JLabel("타이틀 이미지 들어감", JLabel.CENTER);
	// second
	JPanel pnlIDWrite = new JPanel(new FlowLayout());
	JLabel lblNick = new JLabel("Nick", JLabel.CENTER);
	JButton btnUpdate = new JButton("수정");

	// Third
	JLabel result = new JLabel("현재 수준", JLabel.CENTER);

	// 나머지 빈공간 쓸만큼만 할당하고 주석처리해서 어디 위치인지 선정하기.
	// 0 은 빈 gird 내역
	JPanel[] blink = { new JPanel() };

	public MainMember() {
		super(new BorderLayout());
		addBeckGroundPnl();
		addpnlMenuPnl();
		initViewsbeckGroundPnl();
		initViewsPnlMenuPnl();
		setEvent();
	}

	void addBeckGroundPnl() {
		add(pnlmain, BorderLayout.CENTER);
		add(pnlMenu, BorderLayout.SOUTH);
	}

	void addpnlMenuPnl() {
		pnlmain.add(pnltitle);
		pnlmain.add(pnlIDWrite);
		pnlmain.add(result);
		pnlmain.add(blink[0]);
	}

	void initViewsbeckGroundPnl() {
		// 메뉴 패널 설정
		pnlMenu.setBackground(Color.white);

		// 계정만들기 담당 설정
		btnStart.setBackground(Color.white);
		btnStart.setForeground(MyColor.lightBlue);
		btnStart.setFont(new Font("굴림체", Font.BOLD, 20));

		// Blink 설정
		blink[0].setBackground(Color.white);

		pnlMenu.add(btnStart);

	}

	void initViewsPnlMenuPnl() {
		// main
		pnlmain.setBackground(Color.white);

		// first
		pnltitle.add(lblTitleimage);

		// second
		pnlIDWrite.setBackground(Color.white);
		// idLabel
		lblNick.setFont(new Font("Segoe UI", Font.BOLD, 30));
		// lblIDERR Label
		btnUpdate.setFont(new Font("굴림체", Font.BOLD, 20));
		btnUpdate.setForeground(myValue.MyColor.lightBlue);
		pnlIDWrite.add(lblNick);
		pnlIDWrite.add(btnUpdate);

		// Third
		result.setFont(new Font("굴림체", Font.BOLD, 20));

	}

	void setEvent() {
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("main 클래스안에서 문제시작 동작함");
				if (userActionListener != null) {
					userActionListener.onClickStart();
				}

			}
		});

		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("main 클래스안에서 수정 동작함");
				if (userActionListener != null) {
					userActionListener.onClickUpdate();
				}
			}
		});

	}

	private UserActionListener userActionListener;

	public void setUserActionListener(UserActionListener l) {
		userActionListener = l;
	}

	public interface UserActionListener {

		public void onClickStart();

		public void onClickUpdate();
	}

}
