package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainBottomPanel extends JPanel {

	private static final Color LIGTHBLUE = new Color(49, 168, 243);
	// 3 - 1 pnlMainInnerSouthInnerGridFirst
	private JPanel pnlMain = new JPanel(new GridLayout(1, 1));
	private JLabel lblAnswer = new JLabel("시작", JLabel.CENTER);

	// 3 - 2 pnlMainInnerSouthInnerGridSecond
	private JPanel pnlQna = new JPanel(new GridLayout(2, 1));

	// 3 - 2 - 1 libMainInnerSouthInnerGridSecondInnerGridFirst
	private JLabel lblQna = new JLabel("정답/문제", JLabel.CENTER);

	// 3 - 2 - 2 pnlMainInnerSouthInnerGridSecondInnerGridSecond
	private JLabel lblQnaCount = new JLabel("", JLabel.CENTER);

	public MainBottomPanel() {
		super(new GridLayout(1, 2));
		createView();
	}
	
	public void setQna(String setQna) {
		lblQnaCount.setText(setQna);
	}
	
	public void setAnswer(String setAnswe) {
		lblAnswer.setText(setAnswe);
	}

	private void createView() {
		lblAnswer.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 36));
		lblAnswer.setForeground(Color.white);
		pnlMain.add(lblAnswer);

		pnlQna.add(lblQna);
		pnlQna.add(lblQnaCount);
		lblQna.setForeground(Color.white);
		lblQnaCount.setForeground(Color.white);
		lblQna.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 30));
		lblQnaCount.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 14));

		pnlMain.setBackground(LIGTHBLUE);
		pnlQna.setBackground(LIGTHBLUE);
		add(pnlMain);
		add(pnlQna);
		setPreferredSize(new Dimension(500, 60));
	}
}