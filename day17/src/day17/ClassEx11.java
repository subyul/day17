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
			System.out.println("���¹�ȣ\t��й�ȣ\t�����ܾ�");
			System.out.println("---------------------");
			for (int i = 0; i < e.Acc.length; i++) {
				System.out.println(e.Acc[i] + "    " + e.pw[i] + "    " + e.money[i]);
			}
			System.out.println("---------------------");

			if (e.loginCheck != -1) {
				System.out.println("���� : " + e.Acc[e.loginCheck] + " �α���");
			}

			System.out.println("---------------------");
			System.out.println("[" + e.name + "]");
			System.out.println("[1] ȸ������");
			System.out.println("[2] ȸ��Ż��");
			System.out.println("[3] �α���");
			System.out.println("[4] �α׾ƿ�");
			System.out.println("[5] �Ա��ϱ�");
			System.out.println("[6] ��ü�ϱ�");
			System.out.println("[7] �ܾ���ȸ");
			System.out.println("[0] �����ϱ�");

			System.out.println("�޴� ���� : ");
			int select = sc.nextInt();

			if (select == 1) {
				System.out.println("[����]���� ��ȣ�� �Է��ϼ���");
				String id = sc.next();
				int check = 1;
				for (int i = 0; i < e.Acc.length; i++) {
					if (e.Acc[i].equals(id)) {
						check = -1;
					}
				}
				if (check == -1) {
					System.out.println("�ߺ��� ���� ��ȣ �Դϴ�");
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

					System.out.println("[����]��� ��ȣ�� �Է��ϼ���");
					String pwdata = sc.next();
					System.out.println("[����]�ݾ��� �Է��ϼ���");
					int datamoney = sc.nextInt();

					e.Acc[e.count] = id;
					e.pw[e.count] = pwdata;
					e.money[e.count] = datamoney;
				}
			} else if (select == 2) {
				if (e.loginCheck == -1) {
					System.out.println("�α��� �� �̿� �����մϴ�.");
					continue;
				} else {
					for (int i = e.loginCheck; i < e.count - 1; i++) {
						e.Acc[i] = e.Acc[i + 1];
						e.pw[i] = e.pw[i + 1];
						e.money[i] = e.money[i + 1];
					}
					System.out.println("ȸ��Ż�� �Ϸ�Ǿ����ϴ�");
				}

			} else if (select == 3) {
				if (e.loginCheck != -1) {
					System.out.println("�̹� �α��� �� �Դϴ�");
					continue;
				} else {
					System.out.println("�α��� �� ���� ��ȣ�� �Է��ϼ���");
					String inid = sc.next();
					System.out.println("��й�ȣ�� �Է��ϼ���");
					String inpw = sc.next();

					for (int i = 0; i < e.Acc.length; i++) {
						if (e.Acc[i].equals(inid) && e.pw[i].equals(inpw)) {

							e.loginCheck = i;

						}
						if (e.loginCheck == -1) {
							System.out.println("�α��ο� �����Ͽ����ϴ�");
						} else {
							System.out.println("�α����� �Ϸ�Ǿ����ϴ�");
							break;
						}
					}
				}

			}

			else if (select == 4) {
				System.out.println("�α׾ƿ��� ���¹�ȣ�� �Է��ϼ���");
				String delid = sc.next();

				System.out.println("��й�ȣ�� �Է��ϼ���");
				String delpw = sc.next();

				if (e.loginCheck == -1) {
					System.out.println("�α��� �� �̿밡���մϴ�");
				} else {
					for (int i = 0; i < e.Acc.length; i++) {
						if (e.Acc[i].equals(delid) && e.pw[i].equals(delpw)) {
							e.loginCheck = -1;
						}
					}

				}
			} else if (select == 5) {
				if (e.loginCheck == -1) {
					System.out.println("�α��� �� �̿밡���մϴ�");
				} else {
					System.out.println("�Ա��� ���¸� �Է��ϼ���");
					String in_id = sc.next();
					System.out.println("�Ա��� �ݾ��� �Է��ϼ���");
					int inmoney = sc.nextInt();

					for (int i = 0; i < e.money.length; i++) {
						if (e.Acc[i].equals(in_id)) {
							e.money[i] += inmoney;
						}
					}
				}
			} else if (select == 6) {
				if (e.loginCheck == -1) {
					System.out.println("�α��� �� �̿밡���մϴ�");
				} else {
					System.out.println("��ü�� ���¸� �Է��ϼ���");
					String send_id = sc.next();
					System.out.println("��ü�� �ݾ��� �Է��ϼ���");
					int send_money = sc.nextInt();

					for (int i = 0; i < e.money.length; i++) {
						if (e.Acc[i].equals(send_id)) {
							e.money[i] += send_money;
						}
					}
				}
			} else if (select == 7) {
				if (e.loginCheck == -1) {
					System.out.println("�α��� �� �̿밡���մϴ�");
				} else {
					System.out.println("��ȸ�� ���¸� �Է��ϼ���");
					String fid = sc.next();

					for (int i = 0; i < e.Acc.length; i++) {
						if (e.Acc[i].equals(fid)) {
							System.out.println("���¿� " + e.money[i] + "�� �ֽ��ϴ�");
						}

					}
				}
			} else if (select == 0) {
				System.out.println("���α׷� ����...");
				break;
			}
		}
	}

}
