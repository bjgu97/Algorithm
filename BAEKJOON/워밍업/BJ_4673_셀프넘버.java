package 워밍업;

public class BJ_4673_셀프넘버 {
	static int sum;
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		boolean[] check = new boolean[10001];
		
		for (int i = 1; i < 100001; i++){
			int n = d(i);
		
			if(n <= 10000){	// 10000 안넘는 수 중 생성자 존재하는 수들
				check[n] = true;
			}
		}
         
		for (int i = 1; i < 10001; i++) {
			if (!check[i]) {	
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	public static int d(int n) {
		int sum = n;
		
		while(n != 0) {
			sum = sum + (n % 10);
			n = n / 10;
		}
		return sum;
	}
}
