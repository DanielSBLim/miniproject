package myAlgrithm;

public class TwoComplement {

	private String inTent;


	public String getResult() {
		return inTent;
	}

	public TwoComplement(String getProblem, String typeNumber) {
		DecToAnotherchange(getProblem, "2");
		oneComplement();
		twoComplement();
		binToDecchange();
		DecToAnotherchange(inTent, typeNumber);
	}

	private void DecToAnotherchange(String getProblem, String getNumberType) {
		int iGetProblem = Integer.parseInt(getProblem);
		int iGetNumberType = Integer.parseInt(getNumberType);
		String sbinGetProblem = "";

		for (int i = 0;; i++) {

			sbinGetProblem = (iGetProblem % iGetNumberType) + sbinGetProblem;

			iGetProblem = iGetProblem / iGetNumberType;

			if (iGetProblem == 0) {
				break;
			}
		}
		if (getNumberType.equals("16")) {
			if (sbinGetProblem.equals("10")) {
				sbinGetProblem = "A";
			} else if (sbinGetProblem.equals("11")) {
				sbinGetProblem = "B";
			} else if (sbinGetProblem.equals("12")) {
				sbinGetProblem = "C";
			} else if (sbinGetProblem.equals("13")) {
				sbinGetProblem = "D";
			} else if (sbinGetProblem.equals("14")) {
				sbinGetProblem = "E";
			} else if (sbinGetProblem.equals("15")) {
				sbinGetProblem = "F";
			}
		}
		inTent = sbinGetProblem;
	}

	private void oneComplement() {
		char[] cArraybinGetProblem = inTent.toCharArray();

		for (int i = 0; i < cArraybinGetProblem.length; i++) {
			if (cArraybinGetProblem[i] == '0') {
				cArraybinGetProblem[i] = '1';
			} else {
				cArraybinGetProblem[i] = '0';
			}
		}
		inTent = String.valueOf(cArraybinGetProblem);
	}

	private void twoComplement() {
		char[] cArraybinGetProblem = inTent.toCharArray();
		if (cArraybinGetProblem[cArraybinGetProblem.length - 1] == '0') {
			cArraybinGetProblem[cArraybinGetProblem.length - 1] = '1';

		} else {
			cArraybinGetProblem[cArraybinGetProblem.length - 1] = '0';

			for (int i = cArraybinGetProblem.length - 2; i >= 0; i--) {
				if (cArraybinGetProblem.length == i) {
					break;
				} else if (cArraybinGetProblem[i] == '0') {
					cArraybinGetProblem[i] = '1';
					break;
				}
				cArraybinGetProblem[i] = '0';
			}
		}
		inTent = String.valueOf(cArraybinGetProblem);
	}

	private void binToDecchange() {
		char[] getBin = inTent.toCharArray();
		int decMulti = 1;
		int decResult = 0;

		for (int i = getBin.length - 1; i >= 0; i--) {
			decResult = decResult + ((getBin[i] - 48) * decMulti);
			decMulti *= 2;
		}
		inTent = Integer.toString(decResult);
	}

}
