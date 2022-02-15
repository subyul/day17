package day17;

import java.util.Scanner;

class Ex11 {
	String name = "NH BANK";

	String[] Acc = { "1111", "2222", "3333", "4444", "5555" };
	String[] pw = { "1234", "2345", "3456", "4567", "5678" };
	int[] money = { 87000, 34000, 17500, 98000, 12500 };

	int count = 5;

	int loginCheck = -1;
}

public class ClassEx11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ex11 e = new Ex11();

		while (true) {
			System.out.println("---------------------");
			System.out.println("계좌번호\t비밀번호\t계좌잔액");
			System.out.println("---------------------");
			for (int i = 0; i < e.Acc.length; i++) {
				System.out.println(e.Acc[i] + "    " + e.pw[i] + "    " + e.money[i]);
			}
			System.out.println("---------------------");

			if (e.loginCheck != -1) {
				System.out.println("상태 : " + e.Acc[e.loginCheck] + " 로그인");
			}

			System.out.println("---------------------");
			System.out.println("[" + e.name + "]");
			System.out.println("[1] 회원가입");
			System.out.println("[2] 회원탈퇴");
			System.out.println("[3] 로그인");
			System.out.println("[4] 로그아웃");
			System.out.println("[5] 입금하기");
			System.out.println("[6] 이체하기");
			System.out.println("[7] 잔액조회");
			System.out.println("[0] 종료하기");

			System.out.println("메뉴 선택 : ");
			int select = sc.nextInt();

			if (select == 1) {
				System.out.println("[가입]계좌 번호를 입력하세요");
				String id = sc.next();
				int check = 1;
				for (int i = 0; i < e.Acc.length; i++) {
					if (e.Acc[i].equals(id)) {
						check = -1;
					}
				}
				if (check == -1) {
					System.out.println("중복된 계좌 번호 입니다");
				} else {
					if (e.count == 0) {
						e.Acc = new String[e.Acc.length + 1];
						e.pw = new String[e.pw.length + 1];
						e.money = new int[e.money.length + 1];
					} else if (e.count > 0) {
						String temp_acc[] = e.Acc;
						String temp_pw[] = e.pw;
						int temp_money[] = e.money;
						e.Acc = new String[e.Acc.length + 1];
						e.pw = new String[e.pw.length + 1];
						e.money = new int[e.money.length + 1];

						for (int i = 0; i < e.Acc.length - 1; i++) {
							e.Acc[i] = temp_acc[i];
							e.pw[i] = temp_pw[i];
							e.money[i] = temp_money[i];

						}
						temp_acc = null;
						temp_pw = null;
						temp_money = null;
					}

					System.out.println("[가입]비밀 번호를 입력하세요");
					String pwdata = sc.next();
					System.out.println("[가입]금액을 입력하세요");
					int datamoney = sc.nextInt();

					e.Acc[e.count] = id;
					e.pw[e.count] = pwdata;
					e.money[e.count] = datamoney;
				}
			} else if (select == 2) {
				if (e.loginCheck == -1) {
					System.out.println("로그인 후 이용 가능합니다.");
					continue;
				} else {
					for (int i = e.loginCheck; i < e.count - 1; i++) {
						e.Acc[i] = e.Acc[i + 1];
						e.pw[i] = e.pw[i + 1];
						e.money[i] = e.money[i + 1];
					}
					System.out.println("회원탈퇴가 완료되었습니다");
				}

			} else if (select == 3) {
				if (e.loginCheck != -1) {
					System.out.println("이미 로그인 중 입니다");
					continue;
				} else {
					System.out.println("로그인 할 계좌 번호를 입력하세요");
					String inid = sc.next();
					System.out.println("비밀번호를 입력하세요");
					String inpw = sc.next();

					for (int i = 0; i < e.Acc.length; i++) {
						if (e.Acc[i].equals(inid) && e.pw[i].equals(inpw)) {

							e.loginCheck = i;

						}
						if (e.loginCheck == -1) {
							System.out.println("로그인에 실패하였습니다");
						} else {
							System.out.println("로그인이 완료되었습니다");
							break;
						}
					}
				}

			}

			else if (select == 4) {
				System.out.println("로그아웃할 계좌번호를 입력하세요");
				String delid = sc.next();

				System.out.println("비밀번호를 입력하세요");
				String delpw = sc.next();

				if (e.loginCheck == -1) {
					System.out.println("로그인 후 이용가능합니다");
				} else {
					for (int i = 0; i < e.Acc.length; i++) {
						if (e.Acc[i].equals(delid) && e.pw[i].equals(delpw)) {
							e.loginCheck = -1;
						}
					}

				}
			} else if (select == 5) {
				if (e.loginCheck == -1) {
					System.out.println("로그인 후 이용가능합니다");
				} else {
					System.out.println("입금할 계좌를 입력하세요");
					String in_id = sc.next();
					System.out.println("입금할 금액을 입력하세요");
					int inmoney = sc.nextInt();

					for (int i = 0; i < e.money.length; i++) {
						if (e.Acc[i].equals(in_id)) {
							e.money[i] += inmoney;
						}
					}
				}
			} else if (select == 6) {
				if (e.loginCheck == -1) {
					System.out.println("로그인 후 이용가능합니다");
				} else {
					System.out.println("이체할 계좌를 입력하세요");
					String send_id = sc.next();
					System.out.println("이체할 금액을 입력하세요");
					int send_money = sc.nextInt();

					for (int i = 0; i < e.money.length; i++) {
						if (e.Acc[i].equals(send_id)) {
							e.money[i] += send_money;
						}
					}
				}
			} else if (select == 7) {
				if (e.loginCheck == -1) {
					System.out.println("로그인 후 이용가능합니다");
				} else {
					System.out.println("조회할 계좌를 입력하세요");
					String fid = sc.next();

					for (int i = 0; i < e.Acc.length; i++) {
						if (e.Acc[i].equals(fid)) {
							System.out.println("계좌에 " + e.money[i] + "원 있습니다");
						}

					}
				}
			} else if (select == 0) {
				System.out.println("프로그램 종료...");
				break;
			}
		}
	}

}
