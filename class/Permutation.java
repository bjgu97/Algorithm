import java.util.Arrays;

public class Permutation {
	static char[] src = {'a', 'b', 'c', 'd'};
	static int r = 4;
	// 4개 중 4개 선택
	
	static int cnt = 0;
	//반복문을 이용한 세상 제일 빠른 순열!
	//테케에 따라 동적으로 바꿀 수 없다.
	static void perLoop() {
		for(int i = 0; i < src.length; i++) {
			for(int j = 0; j < src.length; j++) {
				if(j != i) { //중복 제거
					for(int k = 0; k < src.length; k++) {
						if(k != i && k != j) { //중복제거
							for(int l = 0; l < src.length; l++) {
								if(l != i && l != j && l != k) {
									System.out.println(Arrays.asList(src[i], src[j], src[k], src[l]));
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * 중복순
	 */
	static void perLoopDup() {
		for(int i = 0; i < src.length; i++) {
			for(int j = 0; j < src.length; j++) {
					for(int k = 0; k < src.length; k++) {
							for(int l = 0; l < src.length; l++) {
								if(l != i && l != j && l != k) {
									System.out.println(Arrays.asList(src[i], src[j], src[k], src[l]));
								}
							}
						}
					
				}
			
		}
	}
	
	/**
	 * 
	 * @param toChoose 뽑아야할 요소의 개수
	 * @param choosed 뽑은 것들을 저장할 배열
	 * @param visited 뽑혔는지에 대한 상태 관리 
	 */
	static void permutation(int toChoose, char[] choosed, boolean[] visited) {
		// 기저조건: 다 뽑았다면 종료
		if(toChoose == 0) {
			System.out.println(++cnt + " : " + Arrays.toString(choosed));
			return;
		}
		
		//inductive case : flat한 일을 진행.
		for(int i= 0; i < src.length; i++) {
			if(!visited[i]) { //방문하지 않았다면 <- 내가 관심있는거
				//표시
				visited[i] = true;
				
				//사용
				choosed[choosed.length - toChoose] = src[i];
				
				//이제 다음 턴으로
				permutation(toChoose-1, choosed, visited);
				
				// 안쓴척하기?
				visited[i] = false;
			}
		}
	}
	
	static void permutationDup(int toChoose, char[] choosed) {
		// 기저조건: 다 뽑았다면 종료
		if(toChoose == 0) {
			System.out.println(++cnt + " : " + Arrays.toString(choosed));
			return;
		}
		
		//inductive case : flat한 일을 진행.
		for(int i= 0; i < src.length; i++) {

				//사용
				choosed[choosed.length - toChoose] = src[i];
				
				//이제 다음 턴으로
				permutationDup(toChoose-1, choosed);
				
		}
	}
	
	public static void main(String[] args) {
		cnt = 0;
		//perLoop();
		//perLoopDup();
		//permutation(r, new char[r], new boolean[src.length]);
		permutationDup(r, new char[r]);
	}
}
