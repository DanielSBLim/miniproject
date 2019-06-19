package layout;

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

//최상단 작업

public class MainMenuPanel extends JPanel {
	private JPanel pnlGrade = new JPanel(new GridLayout(1, 3));
	private JButton[] btnsGradeList = { new JButton(), new JButton(), new JButton() };

	private JPanel pnlScore = new JPanel(new GridLayout(1, 1));

	private final String ImageAddrHighLevel = "./mini/highLevel.jpg";
	private final String ImageAddrMeddleLevel = "./mini/middleLevel.jpg";
	private final String ImageAddrLowLevel = "./mini/lowLevel.jpg";

	public MainMenuPanel() {
		super(new BorderLayout());
		createView();
		setEvent();
	}

	public void middleproblemADD() {
		btnsGradeList[1].setVisible(true);
	}

	public void highproblemADD() {
		btnsGradeList[2].setVisible(true);
	}
	

	private void createView() {
		// West
		btnsGradeList[0].setIcon(new ImageIcon(ImageAddrLowLevel));
		btnsGradeList[0].setPreferredSize(new Dimension(110, 50));
		pnlGrade.add(btnsGradeList[0]);
		btnsGradeList[1].setIcon(new ImageIcon(ImageAddrMeddleLevel));
		btnsGradeList[1].setPreferredSize(new Dimension(110, 50));
		btnsGradeList[1].setVisible(false);
		pnlGrade.add(btnsGradeList[1]);
		btnsGradeList[2].setIcon(new ImageIcon(ImageAddrHighLevel));
		btnsGradeList[2].setPreferredSize(new Dimension(110, 50));
		btnsGradeList[2].setVisible(false);
		pnlGrade.add(btnsGradeList[2]);

		add(pnlGrade, BorderLayout.WEST);

		// East
		
		
		add(pnlScore, BorderLayout.EAST);
	}

	private void setEvent() {
		btnsGradeList[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (userActionListener != null) {
					userActionListener.onClickBasic();
				}
			}
		});

		btnsGradeList[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (userActionListener != null) {
					userActionListener.onClickMiddle();
				}
			}
		});

		btnsGradeList[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (userActionListener != null) {
					userActionListener.onClickHigh();
				}
			}
		});
	}

	private UserActionListener userActionListener;

	public void setUserActionListener(UserActionListener l) {
		userActionListener = l;
	}

	public interface UserActionListener {
		void onClickBasic();

		void onClickMiddle();

		void onClickHigh();
	}
}
