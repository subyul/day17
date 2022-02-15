package day17;
import java.util.Scanner;
class Ex10
{String name = "";

int [] price = {2500,3800,1500,1000};
String[] menu = {"치즈버거","새우버거","감자튀김","코카콜라"};

int [] count = new int [4];
int total = 0;
	}
public class ClassEx10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ex10 e = new Ex10();
		
		System.out.println("----------------------------");
		
		while (true)
		{
			System.out.println("  ITEM   QTY   AMT");
			for(int i = 0; i<e.menu.length;i++)
			{
				System.out.println("["+i+"]"+e.menu[i]);
			}
			System.out.println("[4]결제");
			System.out.println("주문할 메뉴를 선택하세요");
			int select = sc.nextInt();
			
			for(int i = 0; i<e.menu.length;i++)
			{
				if(select == i)
				{
					e.count[i] +=1;
					e.total += e.count[i]*e.price[i];
					
				}
				//System.out.println(e.count[i]);
			}
			
			System.out.println("------------------");
			
				if(select == 4)
				{
					System.out.println("돈을 입력하세요");
					int money = sc.nextInt();
					for(int i = 0; i<e.menu.length;i++)
					{
					if(e.count[i]!=0)
					{
						System.out.println(e.menu[i]+"  "+e.count[i]+"  "+e.count[i]*e.price[i]);
					}
					}
					int n = money-e.total;
					System.out.println("------------------");
					System.out.println("합계금액    "+e.total);
					System.out.println("받은금액    "+money);
					System.out.println("------------------");
					System.out.println("잔   돈    "+n);
					break;
			}
			
		}
		
	}

}
