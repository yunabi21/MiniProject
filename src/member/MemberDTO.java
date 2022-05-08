package member;

public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String gender;
	private String birth;
	private String email;
	private String tel;
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		String str = String.format("아이디 : %s \n이름 : %s \n성별 : %s \n생년월일 : %s \n이메일 : %s \n전화번호 : %s \n", id, name, gender, birth, email, tel);
		return str;
	}
}
