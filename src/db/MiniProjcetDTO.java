package db;

public class MiniProjcetDTO {
	private int totalJumsu;
	private int basicJumsu;
	private int middleJumsu;
	private int highJumsu;

	public int getTotalJumsu() {
		return totalJumsu;
	}

	public int getBasicJumsu() {
		return basicJumsu;
	}

	public void setBasicJumsu(int basicJumsu) {
		this.basicJumsu = basicJumsu;
	}

	public int getMiddleJumsu() {
		return middleJumsu;
	}

	public void setMiddleJumsu(int middleJumsu) {
		this.middleJumsu = middleJumsu;
	}

	public int getHighJumsu() {
		return highJumsu;
	}

	public void setHighJumsu(int highJumsu) {
		this.highJumsu = highJumsu;
	}

	public MiniProjcetDTO() {
		this.totalJumsu = 0;
		this.basicJumsu = 0;
		this.middleJumsu = 0;
		this.highJumsu = 0;
	}
}
