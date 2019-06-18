package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainCenterPanel extends JPanel {

	private final static int FIRST = 0;
	private final static int SECOND = 1;
	private final static int THIRD = 2;
	private final static int FOURD = 3;
	private final static String addrUpimage = "./mini/BoradUp.jpg";
	private final static String addrDownimage = "./mini/BoradDown.jpg";
	private final static String addrHINT = "./mini/HINT.jpg";
	private final static String addrCHECK = "./mini/CHECK.jpg";

	// 2 - 1 pnlArrayMainInnerCenterInnerGrid[] = new [4]
	private JPanel pnlGridMain[] = { new JPanel(new GridLayout(1, 1)), new JPanel(new GridLayout(1, 1)),
			new JPanel(new GridLayout(2, 1)), new JPanel(new BorderLayout()) };

	// 2 - 1 - 1 lblMainInnerCenterInnerGrid[0]

	private JLabel lblMain1 = new JLabel("10에 2의 보수는?", JLabel.CENTER);

	// 2 - 1 - 2 lblMainInnerCenterInnerGrid[1]
	private JLabel lblMain2 = new JLabel("10진수로!!", JLabel.CENTER);

	// 2 - 1 - 3 pnlMainInnerCenterInnerGrid[2]
	private JPanel pnlAnswer = new JPanel(new BorderLayout());
	private JPanel pnlAnswerBtn = new JPanel(new FlowLayout());

	// 2 - 1 - 3 - 1 pnlMainInnerCenterInnerGridThirdInnerFirstInner
	private JLabel lblAnswer = new JLabel(" 답  : ", JLabel.CENTER);
	private JTextField tfAnswer = new JTextField();
	private JPanel[] pnlBlink = { new JPanel(), new JPanel(), new JPanel() };

	// 2 - 1 - 3 - 2 pnlMainInnerCenterInnerGridThirdInnerSecond

	private JButton btnCheck = new JButton();
	private JButton btnHint = new JButton();

	// 2 - 1 - 4 pnlMainInnerCenterInnerGrid[3]
	private JLabel lblHint = new JLabel("     힌트!!!!       ");
	private JLabel lblPrintHint = new JLabel("", JLabel.CENTER);

	public MainCenterPanel() {
		super(new GridLayout(4, 1));
		createView();
		setEvent();
	}
	
	public void setlblMain1(String setlblMain1) {
		lblMain1.setText(setlblMain1);
	}
	public void setlblMain2(String setlblMain2) {
		lblMain2.setText(setlblMain2);
	}
	public void setHintImage(String setImageAddr) {
		lblPrintHint.setIcon(new ImageIcon(setImageAddr));
	}
	
	public void setBlockTfAnswer() {
		tfAnswer.setText("");
	}
	public String getTfAnswer() {
		return tfAnswer.getText();
	}

	private void createView() {

		// 첫번째 이너 패널
		pnlGridMain[FIRST] = new JPanel(new GridLayout(1, 1)) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Dimension d = getSize();
				ImageIcon image = new ImageIcon(addrUpimage);
				g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);

			}
		};
		pnlGridMain[FIRST].add(lblMain1);
		pnlGridMain[FIRST].setBackground(Color.white);
		lblMain1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 30));
		lblMain1.setForeground(Color.white);
		// -----------------------------------------------------------------------------------------------------------------

		// 두번째 이너 패널
		pnlGridMain[SECOND] = new JPanel(new GridLayout(1, 1)) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Dimension d = getSize();
				ImageIcon image = new ImageIcon(addrDownimage);
				g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);

			}
		};
		pnlGridMain[SECOND].add(lblMain2);
		pnlGridMain[SECOND].setBackground(Color.white);
		lblMain2.setForeground(Color.white);
		lblMain2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
		// -----------------------------------------------------------------------------------------------------------------

		// 3번째 이너 패널
		pnlAnswer.setBackground(Color.white);
		lblAnswer.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 30));
		tfAnswer.setPreferredSize(new Dimension(360, 50));
		tfAnswer.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 30));

		pnlAnswer.add(lblAnswer, BorderLayout.WEST);
		pnlAnswer.add(tfAnswer, BorderLayout.CENTER);

		for (int section = FIRST; section < pnlBlink.length; section++) {
			pnlBlink[section].setBackground(Color.white);

		}
		pnlAnswer.add(pnlBlink[FIRST], BorderLayout.SOUTH);
		pnlAnswer.add(pnlBlink[SECOND], BorderLayout.NORTH);
		pnlAnswer.add(pnlBlink[THIRD], BorderLayout.EAST);
		pnlGridMain[THIRD].add(pnlAnswer);
//--------------------------------------------------------------------------------------------------------------------------
		btnCheck.setIcon(new ImageIcon(addrCHECK));
		btnCheck.setPreferredSize(new Dimension(100, 50));
		btnCheck.setBackground(Color.white);
		
		btnHint.setIcon(new ImageIcon(addrHINT));
		btnHint.setPreferredSize(new Dimension(100, 50));
		btnHint.setBackground(Color.white);

		pnlAnswerBtn.add(btnCheck);
		pnlAnswerBtn.add(btnHint);
		
		pnlAnswerBtn.setBackground(Color.white);
		pnlGridMain[THIRD].add(pnlAnswerBtn);

		// 4번째 이너 패널
		pnlGridMain[FOURD].add(lblHint, BorderLayout.NORTH);
		pnlGridMain[FOURD].add(lblPrintHint, BorderLayout.CENTER);
		pnlGridMain[FOURD].setBackground(Color.white);

		for (int section = FIRST; section < pnlGridMain.length; section++) {
			add(pnlGridMain[section]);
		}
	}

	public void setEvent() {
		btnCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (userActionListener != null) {
					userActionListener.onClickCheck();
				}

			}
		});
		btnHint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (userActionListener != null) {
					userActionListener.onClickHint();
				}
			}
		});
	}

	private UserActionListener userActionListener;

	public void setUserActionListener(UserActionListener l) {
		userActionListener = l;
	}

	public interface UserActionListener {
		void onClickCheck();

		void onClickHint();
	}
}
