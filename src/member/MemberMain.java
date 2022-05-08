package member;

import java.util.Scanner;

public class MemberMain {
	
	Scanner scan = new Scanner(System.in);
	MemberRepository memberRepository = new MemberRepository();

	public static void main(String[] args) throws AuthenException {
		
		Scanner scan = new Scanner(System.in);
		MemberService memberService = new MemberService();
		boolean run = true;
		int selectNum;
		
		while (run) {
			
			do {
				System.out.println("-------------------------------------------------------");
				System.out.println("1.가입 | 2.수정 | 3.탈퇴 | 4.회원전체출력 | 5.아이디검색 | 6.종료");
				System.out.println("-------------------------------------------------------");
				System.out.print("선택 > ");
				selectNum = scan.nextInt();
			} while(selectNum < 1 || selectNum > 6);
			
			System.out.println();
			
			switch (selectNum) {
			case 1: // 회원가입 (insert)
				memberService.insert();
				System.out.println();
				break;
			case 2: // 정보수정 (update)
				memberService.update();
				System.out.println();
				break;
			case 3: // 회원탈퇴 (delete)
				memberService.delete();
				System.out.println();
				break;
			case 4: // 회원리스트 (selectAll)
				memberService.selectAll();
				System.out.println();
				break;
			case 5: // 아이디검색 (searchId)
				memberService.searchId();
				System.out.println();
				break;
			case 6: // 종료 
				run = false;
				scan.close();
				System.exit(0);
			}
		}
		
	}

}
