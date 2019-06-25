package dbDATA;

public class MiniDTO {
	private int base_Problem_Check;
	private int Middel_Problem_Check;
	private int Complete_Problem_Check;
	public int getBase_Problem_Check() {
		return base_Problem_Check;
	}

	public void setBase_Problem_Check(int base_Problem_Check) {
		this.base_Problem_Check = base_Problem_Check;
	}

	public int getMiddel_Problem_Check() {
		return Middel_Problem_Check;
	}

	public void setMiddel_Problem_Check(int middel_Problem_Check) {
		Middel_Problem_Check = middel_Problem_Check;
	}

	public int getComplete_Problem_Check() {
		return Complete_Problem_Check;
	}

	public void setComplete_Problem_Check(int complete_Problem_Check) {
		Complete_Problem_Check = complete_Problem_Check;
	}

	private String nickName;
	private String id;
	private String pw;
	
	

	public MiniDTO() {
		this.base_Problem_Check = 0;
		this.Middel_Problem_Check = 0;
		this.Complete_Problem_Check = 0;
	}
	
	public MiniDTO(String id, String pw, String nick ,int setflagbasicJumsu, int setflagmiddleJumsu, int setflaghighJumsu) {
		this.id = id;
		this.pw = pw;
		this.nickName = nick;
		this.base_Problem_Check = setflagbasicJumsu;
		this.Middel_Problem_Check = setflagmiddleJumsu;
		this.Complete_Problem_Check = setflaghighJumsu;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	
	
	
	
}
