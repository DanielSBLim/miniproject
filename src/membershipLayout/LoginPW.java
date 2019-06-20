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
import javax.swing.JTextField;
import myValue.*;

public class LoginPW extends JPanel {

	// Center
	JPanel pnlmain = new JPanel(new GridLayout(4, 1));

	// South
	JPanel pnlMenu = new JPanel(new BorderLayout());
	JButton btnCreateId = new JButton("계정만들기");
	JButton btnNext = new JButton("다음");

	// Center inner

	// first
	JPanel pnltitle = new JPanel(new GridLayout(1, 1));
	JLabel lblTitleimage = new JLabel("타이틀 이미지 들어감", JLabel.CENTER);
	// second
	JPanel pnlPWWrite = new JPanel(new BorderLayout());
	JLabel lblPW = new JLabel("PW", JLabel.LEFT);
	JLabel lblPWERR = new JLabel(" ", JLabel.RIGHT);
//	JLabel lblPWERR = new JLabel("PW를 제대로 입력하세요", JLabel.RIGHT);
	JTextField tfPWWrite = new JTextField();

	// 나머지 빈공간 쓸만큼만 할당하고 주석처리해서 어디 위치인지 선정하기.
	// 0, 1은 pw뒤에 빈 gird 내역
	// 2, 3은 id 기입할때 동쪽 서쪽 빈공간
	JPanel[] blink = { new JPanel(), new JPanel(), new JPanel(), new JPanel() };

	public LoginPW() {
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
		pnlmain.add(blink[0]);
		pnlmain.add(blink[1]);
	}

	void initViewsbeckGroundPnl() {
		// 메뉴 패널 설정
		pnlMenu.setBackground(Color.white);

		// 계정만들기 담당 설정
		btnCreateId.setBackground(Color.white);
		btnCreateId.setForeground(MyColor.lightBlue);
		btnCreateId.setFont(new Font("굴림체", Font.BOLD, 20));

		// 다음 담당 설정 (이미지가 들어가야함)
		btnNext.setPreferredSize(new Dimension(124, 48));
		btnNext.setBackground(Color.white);
		btnNext.setForeground(MyColor.lightBlue);
		btnNext.setFont(new Font("굴림체", Font.BOLD, 20));

		// Blink 설정
		blink[0].setBackground(Color.white);
		blink[1].setBackground(Color.white);

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
		
	
		
	}

	void setEvent() {
		btnCreateId.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("pw 클래스안에서 생성 동작함");
				if (userActionListener != null) {
					userActionListener.onClickCreat();
				}

			}
		});

		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("pw 클래스안에서 다음 동작함");
				if (userActionListener != null) {
					userActionListener.onClickNext();
				}
			}
		});
	}

	private UserActionListener userActionListener;

	public void setUserActionListener(UserActionListener l) {
		userActionListener = l;
	}

	public interface UserActionListener {
		void onClickNext();

		void onClickCreat();
	}
	
	public void setFoucesPW() {
		tfPWWrite.requestFocus();
		tfPWWrite.setFocusable(true);
	}

	public void errVis() {
		lblPWERR.setText(" PW를 제대로 입력하세요");
	}

	public String getPWTextFlied() {

		return tfPWWrite.getText();
	}


	public void clrerrVis() {
		lblPWERR.setText(" ");
	}

	public void clrtext() {
		tfPWWrite.setText("");
	}

}
