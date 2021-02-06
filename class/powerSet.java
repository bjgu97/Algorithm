import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class powerSet {
	static char[] src = {'a', 'b', 'c'};
	static boolean[] bools = {true, false};
	static int cnt = 0;
	
	static void print(boolean[] temp) {
		cnt++;
		List<Character> list1 = new ArrayList<>();
		List<Character> list2 = new ArrayList<>();
		for(int i = 0; i < temp.length; i++) {
			if(temp[i]) { //선택된 상태라면
				//System.out.print(src[i]);
				list1.add(src[i]);
			}
			if(!temp[i]) {
				list2.add(src[i]);
			}
		}
		System.out.printf("%s, %s\n", list1, list2);
	}
	
	// 2개에서 3개 고르는 중복 순열
	static void powersetLoop() {
		for(int i = 0; i < bools.length; i++) {
			for(int j = 0; j < bools.length; j++) {
				for(int k = 0; k < bools.length; k++) {
					//System.out.println(bools[i] + ", " + bools[j] + ", " + bools[k]);
					print(new boolean[] {bools[i], bools[j], bools[k]});				}
			}
		}
	}
	
	static void powerSetRecursive(int toChoose, boolean[] choosed) {
		if(toChoose == 0) {
			print(choosed);
			return;
		}
		for(int i = 0; i < bools.length; i++) {
			choosed[choosed.length - toChoose] = bools[i];
			powerSetRecursive(toChoose-1, choosed);
		}
	}
	

	static void powerSetRecursive2(int toChoose, boolean[] choosed) {
		if(cnt == 1 << (src.length-1))
				return;
		if(toChoose == 0) {
			print(choosed);
			return;
		}
		
		choosed[choosed.length - toChoose] = true;
		powerSetRecursive2(toChoose-1, choosed);
		choosed[choosed.length - toChoose] = false;
		powerSetRecursive2(toChoose-1, choosed);
	}
	
	
	public static void main(String[] args) {
		//powersetLoop();
		int r = 3;
		
		//powerSetRecursive(r,  new boolean[r]);
		powerSetRecursive2(r, new boolean[r]);
		
		//부분집합의 개수: 
		//System.out.println(1 << src.length);
		// 우리가 필요한건 절반
		//System.out.println(1 << src.length -1);
	}

}
