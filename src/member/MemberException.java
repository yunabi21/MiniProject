package member;

import java.util.regex.Pattern;

public class MemberException {

	public void idFormat(String str) throws AuthenException {

		if (str.length() < 5 || str.length() > 20) {
			throw new AuthenException("5~20자 이내의 아이디만 가능합니다.");
		}

		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < str.length(); i++) {
			char chr = str.charAt(i);

			if ((chr >= 'a' && chr <= 'z') || (chr >= 'A' && chr <= 'Z')) {
				count1++;
			} else if (chr >= '0' && chr <= '9') {
				count2++;
			}
		}

		if (count1 == 0 || count2 == 0) {
			throw new AuthenException("아이디는 영문자와 숫자를 혼용해서 만들어주세요.");
		}
	}

	public void pwCheck(String pw1, String pw2) throws AuthenException {

		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < pw1.length(); i++) {
			char chr = pw1.charAt(i);

			if ((chr >= 'a' && chr <= 'z') || (chr >= 'A' && chr <= 'Z')) {
				count1++;
			} else if (chr >= '0' && chr <= '9') {
				count2++;
			}
		}

		if (count1 == 0 || count2 == 0) {
			throw new AuthenException("비밀번호는 영문자와 숫자를 혼용해서 만들어주세요.");
		}

		if (!pw1.equals(pw2)) {
			throw new AuthenException("비밀번호가 다릅니다.");
		}
	}

	public void genderCheck(String gender) throws AuthenException {

		if (!gender.equals("남자") && !gender.equals("여자")) {
			throw new AuthenException("성별은 '남자' 혹은 '여자'로 적어주세요.");
		}
	}

	public void nameCheck(String name) throws AuthenException {
		boolean chk = Pattern.matches("^[ㄱ-ㅎ-가-힣]*$", name);

		if (!chk) {
			throw new AuthenException("이름은 한글로 입력해주세요.");
		}
	}

	public void phoneCheck(String phone) throws AuthenException {
		boolean chk = Pattern.matches("(010|011|016|017|018?019)-(\\d{3,4})-(\\d{4})", phone);

		if (!chk) {
			throw new AuthenException("전화번호 입력 형식은 'xxx-xxxx-xxxx' 입니다.");
		}
	}

}
