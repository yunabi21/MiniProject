package member;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MemberService {

	Scanner scan = new Scanner(System.in);
	MemberRepository memberRepository = new MemberRepository();
	MemberException memEx = new MemberException();

	// 회원가입
	public void insert() throws AuthenException {

		String pw2 = null;
		boolean id = true;
		boolean pw = true;
		boolean name = true;
		boolean gender = true;
		boolean tel = true;

		System.out.println("-------------------- 회원가입 ---------------------");
		System.out.println("-------------------------------------------------");

		try {
			MemberDTO memberDTO = new MemberDTO();

			do {
				try {
					System.out.print("아이디 > ");
					memberDTO.setId(scan.next());
					memEx.idFormat(memberDTO.getId());

					id = false;
				} catch (AuthenException e) {
					System.out.println(e.toString());
				}
			} while (id);

			do {
				try {
					System.out.print("비밀번호 > ");
					memberDTO.setPw(scan.next());

					System.out.print("비밀번호 확인 > ");
					pw2 = scan.next();
					memEx.pwCheck(memberDTO.getPw(), pw2);

					pw = false;
				} catch (AuthenException e) {
					System.out.println(e.toString());
				}
			} while (pw);

			do {
				try {
					System.out.print("이름 > ");
					memberDTO.setName(scan.next());
					memEx.nameCheck(memberDTO.getName());

					name = false;
				} catch (AuthenException e) {
					System.out.println(e.toString());
				}
			} while (name);

			do {
				try {
					System.out.print("성별 [남자/여자] > ");
					memberDTO.setGender(scan.next());
					memEx.genderCheck(memberDTO.getGender());

					gender = false;
				} catch (AuthenException e) {
					System.out.println(e.toString());
				}
			} while (gender);

			System.out.print("생일 [xxxx-xx-xx] > ");
			memberDTO.setBirth(scan.next());

			System.out.print("이메일 [xxx@xx.xxx] > ");
			memberDTO.setEmail(scan.next());

			do {
				try {
					System.out.print("전화번호 [xxx-xxxx-xxxx] > ");
					memberDTO.setTel(scan.next());
					memEx.phoneCheck(memberDTO.getTel());

					tel = false;
				} catch (AuthenException e) {
					System.out.println(e.toString());
				}
			} while (tel);

			int result = memberRepository.insert(memberDTO);

			if (result != 0) {
				System.out.println();
				System.out.println("가입 완료 되었습니다.");
				System.out.println();

				System.out.println("회원가입 확인");
				System.out.println(memberDTO.toString());
			} else {
				System.out.println("회원가입에 실패했습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	// 정보수정
	public void update() {

		try {
			MemberDTO memberDTO = new MemberDTO();

			System.out.print("수정 할 아이디 > ");
			memberDTO.setId(scan.next());

			System.out.print("비밀번호 > ");
			memberDTO.setPw(scan.next());

			System.out.print("이메일 [xxx@xx.xxx] > ");
			memberDTO.setEmail(scan.next());

			System.out.print("전화번호 [xxx-xxxx-xxxx] > ");
			memberDTO.setTel(scan.next());

			int result = memberRepository.update(memberDTO);

			if (result != 0) {
				System.out.println("회원정보가 수정되었습니다.");
			} else {
				System.out.println("회원정보수정에 실패하였습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// 회원탈퇴
	public void delete() {

		try {
			String id;
			String pw;

			System.out.print("탈퇴 할 아이디 > ");
			id = scan.next();

			System.out.print("비밀번호 확인 > ");
			pw = scan.next();

			int result = memberRepository.delete(id, pw);

			if (result != 0) {
				System.out.println("성공적으로 탈퇴 되었습니다.");
			} else {
				System.out.println("탈퇴에 실패했습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// 회원리스트
	public void selectAll() {

		List<MemberDTO> memberList = memberRepository.getList();
		Iterator<MemberDTO> memberIt = memberList.iterator();

		int i = 1;

		while (memberIt.hasNext()) {

			MemberDTO memberDTO = memberIt.next();
			System.out.println("[회원 " + i + "]");
			System.out.println(memberDTO.toString());
			i++;
		}
	}

	// 아이디검색
	public void searchId() {

		System.out.print("검색 할 아이디 > ");
		List<MemberDTO> memberList = memberRepository.getList(scan.next());
		Iterator<MemberDTO> memberIt = memberList.iterator();

		if (memberIt.hasNext()) {
			MemberDTO memberDTO = memberIt.next();
			System.out.println(memberDTO.toString());
		}
	}

}
