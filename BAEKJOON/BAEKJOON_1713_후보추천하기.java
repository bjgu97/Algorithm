import java.util.Scanner;

public class BAEKJOON_1713_후보추천하기 {
	static int NArr[] = new int[N];
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int N = scan.nextInt();//액자 개수
	int P = scan.nextInt();//사람 개수
	
	 //액자 
	int PArr[] = new int[P]; 
	
	for(int i = 0; i < P; i++) {
		PArr[i] = scan.nextInt();
	} //PArr 배열에 사람 등록 완료
	
	for(int i = 0; i < P; i++) {
		//후보자가 틀에 없을 때
			//새로 추가 
		if(NArr[PArr[i]] == 0) {
			
		}
	}
	//후보자가 틀에 있을 때
		//하나 증가
	
	
}
}
