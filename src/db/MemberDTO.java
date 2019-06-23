package db;

public class MemberDTO {
	private String id;
	private String pw;
	private String nickname;
	
	public MemberDTO(String id, String pw, String nickname) {
		this.setId(id);
		this.setPw(pw);
		this.setNickname(nickname);
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
