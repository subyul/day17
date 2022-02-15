package day17;
import java.util.Scanner;
class Ex12{
	String [][] game = new String[3][3];
	int turn = 0;
	int win = 0;
	
}
public class ClassEx12 {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ex12 e = new Ex12();
		while (true)
		{
			System.out.println("=== ∆Ω≈√≈‰ ===");
			for(int i = 0;i<e.game.length;i++)
			{
				for(int j = 0; j<e.game.length;j++)
				{
				e.game[i][j]="[ ]";
				System.out.print(e.game[i][j]);
				}
				System.out.println();
			}
			e.turn++;
			if(e.turn%2==0)
			{
				System.out.println("[p2]¿Œµ¶Ω∫ ¿‘∑¬");
				int idx2 = sc.nextInt();
				for(int i = 0; i<e.game.length;i++)
					e.game[0][idx2] = "[X]";
				
				
				
			}
			else
			{
				System.out.println("[p1]¿Œµ¶Ω∫ ¿‘∑¬");
				int idx1 = sc.nextInt();
				for(int i = 0; i<e.game.length;i++)
				{
					e.game[0][idx1] = "[O]";
				}
				
			}
		}
	}

}
