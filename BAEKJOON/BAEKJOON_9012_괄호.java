import java.util.Scanner;

public class BAEKJOON_9012_괄호 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T  = scan.nextInt();
		
		//N 신경 노
		int cnt = 0;
		boolean flag = false;
		
		for(int t = 0; t < T; t++) {
			int count = 0;
			String c = scan.next();
			
			//입력된 문자열 길이만큼 반복
			for(int i = 0; i < c.length(); i++) {
		
				if(c.charAt(i) == '(') 
					count ++;
				else if(c.charAt(i) == ')') 
					count--;
				
				//어느순간 ) 가 (보다 많이 나타나면
				if(count < 0)
					break;
				
			}
			
			
			if(count== 0) //( 와 ) 수가 같으면
				System.out.println("YES");
			else
				System.out.println("NO");
			
		}
		

	}
}
