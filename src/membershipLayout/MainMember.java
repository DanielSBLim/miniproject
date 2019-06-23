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
	private JPanel pnlmain = new JPanel(new GridLayout(4, 1));

	// South
	private JPanel pnlMenu = new JPanel(new FlowLayout());
	private JButton btnStart = new JButton("문제시작");

	// Center inner

	// first
	private JPanel pnltitle = new JPanel(new GridLayout(1, 1));
	private JLabel lblTitleimage = new JLabel("", JLabel.CENTER);
	// second
	private JPanel pnlMyNick = new JPanel(new FlowLayout());
	private JLabel lblNick = new JLabel("Nick", JLabel.CENTER);
	private JButton btnUpdate = new JButton("수정");

	// Third
	private JLabel lblMyLevelResult = new JLabel("현재 수준", JLabel.CENTER);

	// 나머지 빈공간 쓸만큼만 할당하고 주석처리해서 어디 위치인지 선정하기.
	// 0 은 빈 gird 내역
	private JPanel[] blink = { new JPanel() };
	
	private UserActionListener userActionListener;
	

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
		pnlmain.add(pnlMyNick);
		pnlmain.add(lblMyLevelResult);
		pnlmain.add(blink[0]);
	}

	void initViewsbeckGroundPnl() {
		// 메뉴 패널 설정
		pnlMenu.setBackground(Color.white);

		//타이틀 변경
		lblTitleimage.setIcon(new ImageIcon("./menber/mainMember.jpg"));
				
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
		pnlMyNick.setBackground(Color.white);
		// idLabel
		lblNick.setFont(new Font("Segoe UI", Font.BOLD, 30));
		// lblIDERR Label
		btnUpdate.setFont(new Font("굴림체", Font.BOLD, 20));
		btnUpdate.setForeground(myValue.MyColor.lightBlue);
		pnlMyNick.add(lblNick);
		pnlMyNick.add(btnUpdate);

		// Third
		lblMyLevelResult.setFont(new Font("굴림체", Font.BOLD, 20));

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

	public void setUserActionListener(UserActionListener l) {
		userActionListener = l;
	}

	public interface UserActionListener {

		public void onClickStart();

		public void onClickUpdate();
	}

}
