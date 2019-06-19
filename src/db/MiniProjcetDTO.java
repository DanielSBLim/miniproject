package db;

public class MiniProjcetDTO {
	private int basicJumsu;
	private int middleJumsu;
	private int highJumsu;
	private int flagbasicJumsu;
	private int flagmiddleJumsu;
	private int flaghighJumsu;
	private String id;
	private String pw;
	private String nickName;
	
	
	public int getFlagbasicJumsu() {
		return flagbasicJumsu;
	}

	public void setFlagbasicJumsu(int flagbasicJumsu) {
		this.flagbasicJumsu = flagbasicJumsu;
	}

	public int getFlagmiddleJumsu() {
		return flagmiddleJumsu;
	}

	public void setFlagmiddleJumsu(int flagmiddleJumsu) {
		this.flagmiddleJumsu = flagmiddleJumsu;
	}

	public int getFlaghighJumsu() {
		return flaghighJumsu;
	}

	public void setFlaghighJumsu(int flaghighJumsu) {
		this.flaghighJumsu = flaghighJumsu;
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
		this.basicJumsu = 0;
		this.middleJumsu = 0;
		this.highJumsu = 0;
		this.flagbasicJumsu = 0;
		this.flagmiddleJumsu = 0;
		this.flaghighJumsu = 0;
	}
	
	public MiniProjcetDTO(String nickName) {
		this.basicJumsu = 0;
		this.middleJumsu = 0;
		this.highJumsu = 0;
		this.flagbasicJumsu = 0;
		this.flagmiddleJumsu = 0;
		this.flaghighJumsu = 0;
		this.nickName = nickName;
	}
	
	
	
}
