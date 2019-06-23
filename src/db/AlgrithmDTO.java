package db;

public class AlgrithmDTO {
	private int flagbasicJumsu;
	private int flagmiddleJumsu;
	private int flaghighJumsu;
	private String nickName;
	
	
	public int getFlagbasicJumsu() {
		return flagbasicJumsu;
	}

	public void setFlagbasicJumsu(int flagbasicJumsu) {의미

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


	public AlgrithmDTO() {
		this.flagbasicJumsu = 0;
		this.flagmiddleJumsu = 0;
		this.flaghighJumsu = 0;
	}
	
	public AlgrithmDTO(int setflagbasicJumsu, int setflagmiddleJumsu, int setflaghighJumsu, String setNickName) {
		this.flagbasicJumsu = setflagbasicJumsu;
		this.flagmiddleJumsu = setflagmiddleJumsu;
		this.flaghighJumsu = setflaghighJumsu;
		this.nickName = setNickName;
	}
	
	
	
	
}
