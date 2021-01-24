import java.util.Scanner;

public class BAEKJOON_10773_제로 {
 public static void main(String[] args) {
	 
	 Scanner scan = new Scanner(System.in);
	 int K = scan.nextInt();
	 int[] stack = new int[K]; //K짜리 스택 
	 int sum = 0; //합계
	 int top = -1;
	 
	 for(int i = 0; i < K; i++) {
		 int num = scan.nextInt();
		 
		 if(num == 0) { //0 외치면 
			 top--;  //최근 수 지운다
		 }
		 else { //이외의 숫자 외치면
			 stack[++top] = num; //쌓아준다
		 }
		 
	 }
	 
	 for(int i = 0; i <= top; i++) { //합계 구하기
		 sum += stack[i];
	 }

		System.out.println(sum);

	}
}	