package main;

import java.util.Random;

public class MyRamdom {

	// TwoComplement
	// 1~ 16까지 하는 랜덤 메소드
	public String random0to16() {

		Random ram = new Random();

		return Integer.toString((ram.nextInt(16)));

	}

	// 2진수 8진수 10진수 16진수 랜점 하게 하는 변수
	public String randomNumberType() {

		Random ram = new Random();

		int SelectNumber = (ram.nextInt(4));

		if (SelectNumber == 0) {
			return "2";
		} else if (SelectNumber == 1) {
			return "8";
		} else if (SelectNumber == 2) {
			return "10";
		} else if (SelectNumber == 3) {
			return "16";
		}
		return "err";

	}
	// --------------------------------------------------------

	// Stack
	// 각각 한개씩 0또는 1으로 해서 랜덤출력 하는걸 8자하는 메서드
	public String randomOneCell0to1() {
		int[] cell = new int[8];
		String result = "";
		Random ram = new Random();
		for (int i = 0; i < cell.length; i++) {
			cell[i] = ram.nextInt(2);
			result = result + cell[i];
		}
		return result;
	}

	// --------------------------------------------------------

	// MyLRU
	// 10000000~ 99999999 까지 하는 랜덤 메소드
	public String random100000000to99999999() {

		Random ram = new Random();

		return Integer.toString(10000000 + Math.abs(ram.nextInt(89999999)));

	}

	// 0~ 10까지 하는 랜덤 메소드
	public int random0to10() {

		Random ram = new Random();

		return ram.nextInt(10);

	}
}
