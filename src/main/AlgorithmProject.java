package main;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import myAlgrithm.*;
import problemLayout.*;
import db.*;

public class AlgorithmProject extends JFrame {

	// 상단
	private MainMenuPanel pnlTop = new MainMenuPanel();

	// 중단
	private MainCenterPanel pnlCenter = new MainCenterPanel();

	// 하단
	private MainBottomPanel pnlBottom = new MainBottomPanel();

	// DTO
	private AlgrithmDTO DTO;

	// 버튼관련
	private int btnProblemSelect = 0;

	// 문제 관련
	private String problem1;
	private String problem2;

	private TwoComplement twoComplement;
	private String twoComplementInputNumber = "10";
	private String twoComplementInputType = "10";
	private int twoComJumsu = 0;
	private int twoComtotal = 0;

	private Stack stack;
	private String stackInputNumber = "00001111";
	private int stackJumsu = 0;
	private int stacktotal = 0;

	private MyLRU lru;
	private String lruInputNumber = "12345678";
	private int lruInputCash = 1;
	private int lruJumsu = 0;
	private int lrutotal = 0;

	private MyRamdom ram = new MyRamdom();

	public AlgorithmProject() {
		super("알고리즘 이해");
		dtoSetting();
		initViews();
		setEvent();
		initWindowSetting();

	}

	public void dtoSetting() {
		DTO = new AlgrithmDTO();

		if (DTO.getFlagbasicJumsu() == 1) {
			btnProblemSelect = 1;
			onClickMiddleSetting();
		} else if (DTO.getFlagmiddleJumsu() == 1) {
			btnProblemSelect = 2;
			onClickHighSetting();
		} else if (DTO.getFlaghighJumsu() == 1) {
			btnProblemSelect = 2;
			onClickHighSetting();
		}

	}

	private void initWindowSetting() {
		setSize(500, 700);
		setVisible(true);
		setResizable(true);
	}

	private void initViews() {
		add(pnlTop, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlBottom, BorderLayout.SOUTH);
	}

	private void setEvent() {
		pnlTop.setUserActionListener(new MainMenuPanel.UserActionListener() {

			@Override
			public void onClickBasic() {
				onClickBasicSetting();
			}

			@Override
			public void onClickMiddle() {
				onClickMiddleSetting();

			}

			@Override
			public void onClickHigh() {
				onClickHighSetting();

			}
		});

		pnlCenter.setUserActionListener(new MainCenterPanel.UserActionListener() {

			@Override
			public void onClickHint() {
				System.out.println("힌트");

				// 배이직 문제
				if (btnProblemSelect == 0) {
					pnlCenter.setHintImage("./mini/basicHint.jpg");
					// 중간문제
				} else if (btnProblemSelect == 1) {
					pnlCenter.setHintImage("./mini/stack.jpg");
					// 어려운 문제
				} else if (btnProblemSelect == 2) {
					pnlCenter.setHintImage("./mini/LRU.jpg");
				}
			}

			@Override
			public void onClickCheck() {
				System.out.println("체크");

				// 배이직 문제
				if (btnProblemSelect == 0) {
					onClickBasicResult();

					// 중간문제
				} else if (btnProblemSelect == 1) {
					onClickMiddleResult();

					// 어려운 문제
				} else if (btnProblemSelect == 2) {
					onClickHighResult();
				}

			}
		});
	}

	public void onClickBasicSetting() {
		btnProblemSelect = 0; // 해당 문제 선택
		twoComJumsu = 0; // 기초문제 점수 초기화
		pnlCenter.setHintImage(""); // 힌트 초기화
		twoComtotal = 0; // 기초 전체 문제 갯수
		pnlCenter.setlblMain1("10에 2의 보수는"); // 기초 문제 출력 초기화
		pnlCenter.setlblMain2("10진수로!!"); // 기초 문제 출력 초기화
		twoComplementInputNumber = "10"; // 기초 문제 출력 초기화 입력 숫자 초기화
		twoComplementInputType = "10"; // 기초 문제 출력 초기화 입력 숫자 초기화
		pnlBottom.setAnswer("시작"); // 정/오답 시작으로 초기화
		pnlBottom.setQna(""); // 전체점수와 합격 점수 공란하기
	}

	public void onClickMiddleSetting() {
		btnProblemSelect = 1; // 해당 문제 선택
		pnlCenter.setHintImage(""); // 힌트 초기화
		stackInputNumber = "00001111"; // 스텍 문제 초기화
		stackJumsu = 0; // 스택 문제 합격점수 초기화
		stacktotal = 0; // 스텍 전체 점수 초기화
		pnlCenter.setlblMain1("1234를 스택으로 처리!"); // 기초 문제 출력 초기화
		pnlCenter.setlblMain2("PushPushPushPushPop\nPopPopPop 이면?"); // 기초 문제 출력 초기화

		pnlBottom.setAnswer("시작"); // 정/오답 시작으로 초기화
		pnlBottom.setQna(""); // 전체점수와 합격 점수 공란하기
		pnlTop.middleproblemADD();
	}

	public void onClickHighSetting() {
		btnProblemSelect = 2; // 해당 문제 선택
		pnlCenter.setHintImage(""); // 힌트 초기화
		lrutotal = 0; // 고급전체 문제 갯수
		lruJumsu = 0; // 고급문제 합격점수 초기화
		pnlCenter.setlblMain1("LRU처리 시간 "); // 고급문제 출력 초기화
		pnlCenter.setlblMain2("12345678값을 1cash이면 (miss 5초, hit 1초)"); // 고급 문제 출력 초기화
		lruInputNumber = "12345678"; // 고급 문제 출력 초기화 입력 숫자 초기화
		lruInputCash = 1; // 고급문제 cash 초기화 입력 숫자 초기화
		pnlBottom.setAnswer("시작"); // 정/오답 시작으로 초기화
		pnlBottom.setQna(""); // 전체점수와 합격 점수 공란하기
		pnlTop.middleproblemADD();
		pnlTop.highproblemADD();
	}

	public void onClickBasicResult() {
		if (pnlCenter.getTfAnswer().equals("skip")) {
			pnlTop.middleproblemADD();
			btnProblemSelect = 1;
		}

		System.out.println(twoComtotal);

		if (twoComtotal < 5) {
			twoComtotal++;
			twoComplement = new TwoComplement(twoComplementInputNumber, twoComplementInputType);

			if (twoComplement.getResult().equals(pnlCenter.getTfAnswer())) {
				twoComJumsu++;
				pnlBottom.setAnswer("정답");
			} else {
				pnlBottom.setAnswer("오답");

			}

			pnlBottom.setQna(twoComJumsu + " / " + twoComtotal);

			twoComplementInputNumber = ram.random0to16();
			twoComplementInputType = ram.randomNumberType();
			problem1 = twoComplementInputNumber + "에 2의 보수는 ?";
			problem2 = twoComplementInputType + "진수로!";
			pnlCenter.setlblMain1(problem1);
			pnlCenter.setlblMain2(problem2);

		} else {

		}

		if (twoComtotal >= 5) {
			if (twoComJumsu >= 3) {
				pnlCenter.setlblMain1("합격입니다 다음등급으로");
				pnlCenter.setlblMain2("합격입니다 다음등급으로");
				pnlTop.middleproblemADD();
				DTO.setFlagbasicJumsu(1);
			} else {
				pnlCenter.setlblMain1("불합격 다시 할려면");
				pnlCenter.setlblMain2("초급 버튼 후 Check");
			}
		}

	}

	public void onClickMiddleResult() {
		if (pnlCenter.getTfAnswer().equals("skip")) {
			btnProblemSelect = 2;
			pnlTop.highproblemADD();

		}

		System.out.println(stacktotal);

		if (stacktotal < 5) {
			stacktotal++;
			stack = new Stack(stackInputNumber);

			if (stack.getResult().equals(pnlCenter.getTfAnswer())) {
				stackJumsu++;
				pnlBottom.setAnswer("정답");
			} else {
				pnlBottom.setAnswer("오답");

			}

			pnlBottom.setQna(stackJumsu + " / " + stacktotal);

			stackInputNumber = ram.randomOneCell0to1();
			problem1 = "1234를 스텍으로 처리 !";
			problem2 = binExchangePushPop(stackInputNumber) + "이면";
			pnlCenter.setlblMain1(problem1);
			pnlCenter.setlblMain2(problem2);

		} else {

		}

		if (stacktotal >= 5) {
			if (stackJumsu >= 3) {
				pnlCenter.setlblMain1("합격입니다 다음등급으로");
				pnlCenter.setlblMain2("합격입니다 다음등급으로");
				DTO.setFlagmiddleJumsu(1);
				pnlTop.highproblemADD();
			} else {
				pnlCenter.setlblMain1("불합격 다시 할려면");
				pnlCenter.setlblMain2("중급 버튼 후 Check");
			}
		}
	}

	private String binExchangePushPop(String getData) {
		char[] charArrayGetData = getData.toCharArray();
		String binExchangePushPop = "";
		for (int i = 0; i < charArrayGetData.length; i++) {
			if (charArrayGetData[i] == '0') {
				binExchangePushPop = binExchangePushPop + "Push";
			} else {
				binExchangePushPop = binExchangePushPop + "Pop";
			}
		}
		return binExchangePushPop;
	}

	public void onClickHighResult() {

		System.out.println(lrutotal);
		if (pnlCenter.getTfAnswer().equals("답")) {
			lruJumsu = 4;
		}

		if (lrutotal < 5) {
			lrutotal++;
			lru = new MyLRU(lruInputNumber, lruInputCash);

			if (lru.getResult().equals(pnlCenter.getTfAnswer())) {
				lruJumsu++;
				pnlBottom.setAnswer("정답");
			} else {
				pnlBottom.setAnswer("오답");

			}

			pnlBottom.setQna(lruJumsu + " / " + lrutotal);

			lruInputNumber = ram.random100000000to99999999();
			lruInputCash = ram.random0to10();
			problem1 = "LRU처리 시간 ";
			problem2 = lruInputNumber + "값을" + lruInputCash + "이면 (miss 5초, hit 1초)";
			pnlCenter.setlblMain1(problem1);
			pnlCenter.setlblMain2(problem2);

		} else {

		}

		if (lrutotal >= 5) {
			if (lruJumsu >= 3) {
				pnlCenter.setlblMain1("합격입니다");
				pnlCenter.setlblMain2("합격입니다 고생하셨습니다");
				DTO.setFlaghighJumsu(1);
			} else {
				pnlCenter.setlblMain1("불합격 다시 할려면");
				pnlCenter.setlblMain2("고급 버튼 후 Check");
			}
		}

	}

}
