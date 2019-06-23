package myAlgrithm;

import java.util.ArrayList;

public class Stack {

	private String intent;
	private final char PUSH = 48;
	private final char POP = 49;
	private final String[] DATAS = { "1", "2", "3", "4" };

	public String getResult() {
		return intent;
	}

	public Stack(String pushPopData) {
		stackSystem(pushPopData);
	}

	private void stackSystem(String getPushPopData) {

		ArrayList<String> memory = new ArrayList<String>();
		ArrayList<String> print = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();

		char[] pushPop = getPushPopData.toCharArray();

		String result = "";
		int datasCount = -1;

		for (int i = 0; i < DATAS.length; i++) {
			list.add(DATAS[i]);
		}

		for (int i = 0; i < pushPop.length; i++) {
			if (pushPop[i] == PUSH) {
				if (list.size() == 0) {

				} else {
					memory.add(list.get(0));
					list.remove(0);
				}

			} else if (pushPop[i] == POP) {
				if (memory.size() == 0) {

				} else {
					result = result + memory.get(memory.size() - 1);
					memory.remove(memory.size() - 1);

				}

			}
		}

		intent = result;
	}
}
