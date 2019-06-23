package membershipLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import myValue.*;

public class UpDateMember extends JPanel {

	// Center
	JPanel pnlmain = new JPanel(new GridLayout(4, 1));

	// South
	JPanel pnlMenu = new JPanel(new BorderLayout());
	JButton btnCreateId = new JButton("탈퇴");
	JButton btnNext = new JButton("다음");

	// Center inner

	// first
	JPanel pnltitle = new JPanel(new GridLayout(1, 1));
	JLabel lblTitleimage = new JLabel("", JLabel.CENTER);

	// second
	JPanel pnlPWWrite = new JPanel(new BorderLayout());
	JLabel lblPW = new JLabel("PW", JLabel.LEFT);
	JLabel lblPWERR = new JLabel(" ", JLabel.RIGHT);
//	JLabel lblPWERR = new JLabel("PW를  입력하세요", JLabel.RIGHT);
	JPasswordField tfPWWrite = new JPasswordField();

	// Third
	JPanel pnlNicklWrite = new JPanel(new BorderLayout());
	JLabel lblNick = new JLabel("NickName", JLabel.LEFT);
	JLabel lblNickERR = new JLabel(" ", JLabel.RIGHT);
//	JLabel lblNickERR = new JLabel("닉네임을  입력하세요", JLabel.RIGHT);
	JTextField tfNickWrite = new JTextField();

	// fourth
	// 나머지 빈공간 쓸만큼만 할당하고 주석처리해서 어디 위치인지 선정하기.

	// 0, grid 공백
	// 2, 3은 pw 기입할때 동쪽 서쪽 빈공간
	// 4, 5은 닉네임 기입할때 동쪽 서쪽 빈공간
	JPanel[] blink = { new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel() };
	private UserActionListener userActionListener;

	public UpDateMember() {
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
		pnlmain.add(pnlPWWrite);
		pnlmain.add(pnlNicklWrite);
		pnlmain.add(blink[0]);
	}

	void initViewsbeckGroundPnl() {
		// 메뉴 패널 설정
		pnlMenu.setBackground(Color.white);

		// 타이틀 변경
		lblTitleimage.setIcon(new ImageIcon("./menber/updateMember.jpg"));

		// 계정만들기 담당 설정
		btnCreateId.setBackground(Color.white);
		btnCreateId.setForeground(MyColor.lightBlue);
		btnCreateId.setFont(new Font("굴림체", Font.BOLD, 20));

		// 다음 담당 설정 (이미지가 들어가야함)
		btnNext.setPreferredSize(new Dimension(124, 48));
		btnNext.setBackground(Color.white);
		btnNext.setForeground(MyColor.lightBlue);
		btnNext.setFont(new Font("굴림체", Font.BOLD, 20));

		pnlMenu.add(btnCreateId, BorderLayout.WEST);
		pnlMenu.add(btnNext, BorderLayout.EAST);

	}

	void initViewsPnlMenuPnl() {
		// first
		pnltitle.add(lblTitleimage);

		// second
		pnlPWWrite.setBackground(Color.white);
		// idLabel
		lblPW.setFont(new Font("Segoe UI", Font.BOLD, 30));
		// lblIDERR Label
		lblPWERR.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		lblPWERR.setForeground(Color.red);
		// blink Panel
		blink[2].setBackground(Color.white);
		blink[3].setBackground(Color.white);

		pnlPWWrite.add(lblPW, BorderLayout.NORTH);
		pnlPWWrite.add(tfPWWrite, BorderLayout.CENTER);
		pnlPWWrite.add(lblPWERR, BorderLayout.SOUTH);
		pnlPWWrite.add(blink[2], BorderLayout.EAST);
		pnlPWWrite.add(blink[3], BorderLayout.WEST);

		// Third
		pnlNicklWrite.setBackground(Color.white);
		// idLabel
		lblNick.setFont(new Font("Segoe UI", Font.BOLD, 30));
		// lblIDERR Label
		lblNickERR.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		lblNickERR.setForeground(Color.red);
		// blink Panel
		blink[4].setBackground(Color.white);
		blink[5].setBackground(Color.white);

		pnlNicklWrite.add(lblNick, BorderLayout.NORTH);
		pnlNicklWrite.add(tfNickWrite, BorderLayout.CENTER);
		pnlNicklWrite.add(lblNickERR, BorderLayout.SOUTH);
		pnlNicklWrite.add(blink[4], BorderLayout.EAST);
		pnlNicklWrite.add(blink[5], BorderLayout.WEST);

		// Fourd
		blink[0].setBackground(Color.white);

	}

	void setEvent() {
		btnCreateId.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("생성 클래스안에서 탈퇴 동작함");
				if (userActionListener != null) {
					userActionListener.onClickRemove();
				}

			}
		});

		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("생성 클래스안에서 다음 동작함");
				if (userActionListener != null) {
					userActionListener.onClickNext();
				}
			}
		});
	}

	public void setUserActionListener(UserActionListener l) {
		userActionListener = l;
	}

	public interface UserActionListener {
		void onClickNext();

		void onClickRemove();
	}

	public void allreset() {
		tfPWWrite.setText("");
		tfNickWrite.setText("");
	}

	public void setFoucesPW() {
		tfPWWrite.requestFocus();
		tfPWWrite.setFocusable(true);
	}

	public void setFoucesNick() {
		tfNickWrite.requestFocus();
		tfNickWrite.setFocusable(true);
	}

	public String getPWTextFlied() {

		return tfPWWrite.getText();
	}

	public String getNickTextFlied() {

		return tfNickWrite.getText();
	}

	public void errVisPW() {
		lblPWERR.setText(" PW를 제대로 입력하세요");
	}

	public void errVisNick() {
		lblNickERR.setText(" Nick를 제대로 입력하세요");
	}

	public void errVisclr() {
		lblPWERR.setText(" ");
		lblNickERR.setText(" ");
	}

	public void tFdclr() {
		tfPWWrite.setText(" ");
		tfNickWrite.setText(" ");
	}

}
