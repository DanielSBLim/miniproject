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

public class LoginID extends JPanel {
	
	//Center
	JPanel pnlmain = new JPanel(new GridLayout(4, 1));

	//South
		JPanel pnlMenu = new JPanel(new BorderLayout());
		JButton btnCreateId = new JButton("계정만들기");
		JButton btnNext = new JButton("다음");
	
	//Center inner
	
	//first
	JPanel pnltitle = new JPanel(new GridLayout(1, 1));
	JLabel lblTitleimage = new JLabel("", JLabel.CENTER);
	//second
	JPanel pnlIDWrite = new JPanel(new BorderLayout());
	JLabel lblID = new JLabel("ID", JLabel.LEFT);
	JLabel lblIDERR = new JLabel(" ", JLabel.RIGHT);
	JTextField tfIDWrite = new JTextField();
	//	JLabel lblIDERR = new JLabel(" id를 제대로 입력하세요", JLabel.CENTER);
	
	// 나머지 빈공간 쓸만큼만 할당하고 주석처리해서 어디 위치인지 선정하기.
	// 0, 1은 아이디뒤에 빈 gird 내역 
	// 2, 3은 id 기입할때 동쪽 서쪽 빈공간
	JPanel[] blink = { new JPanel(), new JPanel()
			, new JPanel(), new JPanel()};

	public LoginID(){
		super(new BorderLayout());
		addBeckGroundPnl();
		addpnlMenuPnl();
		createViewsbeckGroundPnl();
		createViewsPnlMenuPnl();
		setEvent();
	}
	
	void addBeckGroundPnl() {
		add(pnlmain, BorderLayout.CENTER);
		add(pnlMenu, BorderLayout.SOUTH);
	}
	
	void addpnlMenuPnl() {
		pnlmain.add(pnltitle);
		pnlmain.add(pnlIDWrite);
		pnlmain.add(blink[0]);
		pnlmain.add(blink[1]);
	}
	
	void createViewsbeckGroundPnl() {
		//메뉴 패널 설정
		pnlMenu.setBackground(Color.white);
		
		//타이틀 변경
		lblTitleimage.setIcon(new ImageIcon("./menber/loginTitle.jpg"));
		
		
		//계정만들기 담당 설정
		btnCreateId.setBackground(Color.white);
		btnCreateId.setForeground(MyColor.lightBlue);
		btnCreateId.setFont(new Font("굴림체", Font.BOLD, 20));
		
		//다음 담당 설정 (이미지가 들어가야함)
		btnNext.setPreferredSize(new Dimension(124, 48));
		btnNext.setBackground(Color.white);
		btnNext.setForeground(MyColor.lightBlue);
		btnNext.setFont(new Font("굴림체", Font.BOLD, 20));

		//Blink 설정
		blink[0].setBackground(Color.white);
		blink[1].setBackground(Color.white);

		
		pnlMenu.add(btnCreateId, BorderLayout.WEST);
		pnlMenu.add(btnNext, BorderLayout.EAST);
		
		
	}
	
	void createViewsPnlMenuPnl() {
		
		
		//first
		
		pnltitle.add(lblTitleimage);
		pnlmain.setBackground(Color.white);
		
		//second 
		pnlIDWrite.setBackground(Color.white);
			//idLabel
		lblID.setFont(new Font("Segoe UI", Font.BOLD, 30));
			//lblIDERR Label
		lblIDERR.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		lblIDERR.setForeground(Color.red);
			//blink Panel
		blink[2].setBackground(Color.white);
		blink[3].setBackground(Color.white);
		
		pnlIDWrite.add(lblID, BorderLayout.NORTH);
		pnlIDWrite.add(tfIDWrite, BorderLayout.CENTER);
		pnlIDWrite.add(lblIDERR, BorderLayout.SOUTH);
		pnlIDWrite.add(blink[2], BorderLayout.EAST);
		pnlIDWrite.add(blink[3], BorderLayout.WEST);
		
	}
	
	void setEvent() {
		btnCreateId.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("login 클래스안에서 생성 동작함");
				if(userActionListener != null) {
					userActionListener.onClickCreat();
				}
				
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("login 클래스안에서 다음 동작함");
				if(userActionListener != null) {
					userActionListener.onClickNext();
				}
			}
		});
	}
	
	private UserActionListener userActionListener;
	
	public void setUserActionListener(UserActionListener l) {
		userActionListener = l;
	}
	
	public interface UserActionListener{
		void onClickNext();
		
		void onClickCreat();
	}
	
	public void errVis() {
		lblIDERR.setText(" id를 제대로 입력하세요");
	}
	public String getIDTextFlied() {
		
		return tfIDWrite.getText();
	}
	
	public void setFoucesID() {
		tfIDWrite.requestFocus();
		tfIDWrite.setFocusable(true);
	}
	
	public void clrerrVis() {
		lblIDERR.setText(" ");
	}
	public void clrtext() {
		tfIDWrite.setText("");
	}
	


}
