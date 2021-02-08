import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 좋은아침_연습 {
   // static char[] src = {'a', 'b', 'c', 'd'};
	static int[] numbers;
	static int N, M, totalCnt;
	static boolean[] isSelected;
	
    public static void main(String[] args) {
    	N =  2; // N개 고른다. 
        M = 4; // 1부터 M까지의 자연수 중에서. 
    	numbers = new int[N];
        isSelected = new boolean[M+1]; //1부터 6개까지 수 중에서.
        
        System.out.println("순열");
        //makePermutation(0);
        
        System.out.println("중복순열");
        //makePermutationDup(0);
        
        System.out.println("조합");
        makeCombination(0,  1);
        
        System.out.println("중복조합");
        //makeCombinationDup(0, 1);        
        
        System.out.println("부분집합");
       // powerSet();
        
    }
    
	///////////////////////////////
	//       순열: mPn           //
	///////////////////////////////
    static void makePermutation(int cnt) {
    	if(cnt == N) {
    		System.out.println(Arrays.toString(numbers));
    		return;
    	}
    	for(int i = 1; i <= M; i++) {
    		if(isSelected[i]) continue;
    		
    		numbers[cnt] = i;
    		isSelected[i] = true;
    		makePermutation(cnt+1);
    		isSelected[i] = false;
    	}
    }
    
    ///////////////////////////////
    //       중복순열: M^N       //
    ///////////////////////////////
    static void makePermutationDup(int cnt) { //cnt : 뽑은 자리
    	if(cnt == N) {
    		totalCnt++;
    		System.out.println(Arrays.toString(numbers));
    		return;
    	}
    	for(int i = 1; i <= M; i++) {
    		numbers[cnt] = i; 
    		makePermutationDup(cnt+1);
    	}
    }
    
    ///////////////////////////////
    //       중복조합: mHn      //
    ///////////////////////////////
    static void makeCombinationDup(int cnt, int start) {
    	if(cnt == N) {
    		totalCnt++;
    		System.out.println(Arrays.toString(numbers));
    		return;
    	}
    	for(int i = start; i <= M; i++) {
    		numbers[cnt] = i;
    		makeCombinationDup(cnt+1, i);
    	}
    }
	    
	///////////////////////////////
	//           조합: mCn       //
	///////////////////////////////
    static void makeCombination(int cnt, int start) {
    	if(cnt == N) {
    		totalCnt++;
    		System.out.println(Arrays.toString(numbers));
    		return;
    	}
    	for(int i = start; i <= M; i++) {
    		numbers[cnt] = i;
    		makeCombination(cnt+1, i+1);
    	}
    }
    
    
	///////////////////////////////
	//           부분집합        //
	///////////////////////////////
    //static void powerSet();
}