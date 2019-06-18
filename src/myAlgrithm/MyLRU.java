package myAlgrithm;

public class MyLRU {

	private String result;
	private final int iMiss = 5;
	private final int iHit = 1;

	public MyLRU(String inputDatas, int cahes) {
		myLRU(inputDatas, cahes);
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void myLRU(String getInputData, int cahes) {

		if (cahes == 0) {
			cahes = 1;
		}
		String[] datas = new String[getInputData.length()];
		char[] cArrayGetInputData = getInputData.toCharArray();
		for (int i = 0; i < cArrayGetInputData.length; i++) {
			datas[i] = cArrayGetInputData[i] + "";
		}

		String[] sArrayMemory = new String[cahes];
		for (int i = 0; i < sArrayMemory.length; i++) {
			sArrayMemory[i] = " ";
		}

		int[] Rank = new int[cahes];
		int iRunTime = 5;
		boolean bHitFlag = false;

		sArrayMemory[0] = datas[0];
		Rank[0] = cahes;

		// 처음에 값은 바로 입력되기에 두번째 부터 시작을 한다.
		for (int iInput = 1; iInput < datas.length; iInput++) {

			// 후의 값이 앞에 값과 비교 했을때 같을 값이 있는지 확인한다.
			for (int iCheckCount = 0; iCheckCount < cahes; iCheckCount++) {

				// iCaheHit 발생
				// 해당 위치의 값은 변동이 없으며 동일한 번지의 랭크는 최고 높은 등급을 할당한다.
				// 나머지 다른 번지는 한단계 값이 낮아야한다.(어떻게 구현하지)
				if (sArrayMemory[iCheckCount].equals(datas[iInput])) {
					Rank = rankDown(Rank);
					Rank[iCheckCount] = cahes;

					// 어차피 똑같은 값이기에 넣을 필요는 없다.
//					sArrayMemory[iCheckCount] = citis[iInput];
					iRunTime = iRunTime + iHit;
					bHitFlag = true;

					break;
				}
			}

			// cacheMiss 발생hit에서 발생하지 않았으면 miss이기에 선언이며
			// hit가 발현되었는데 시작이 되면 안되기에 플레그값으로 조건 할당
			// 랭크가 제일 낮은 점수부터 값이 기입이 되어야한다.
			if (bHitFlag == false) {
				Rank = rankDown(Rank);
				for (int iInputCount = 0; iInputCount < cahes; iInputCount++) {
					if (Rank[iInputCount] <= 0) {
						Rank[iInputCount] = cahes;
						sArrayMemory[iInputCount] = datas[iInput];
						iRunTime = iRunTime + iMiss;
						break;
					}
				}

			} else {
				bHitFlag = false;
			}

		}
		result = Integer.toString(iRunTime);

	}

	public int[] rankDown(int[] rank) {
		for (int i = 0; i < rank.length; i++) {
			rank[i] = rank[i] - 1;
		}
		return rank;
	}

}
