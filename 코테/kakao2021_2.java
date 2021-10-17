import java.util.Arrays;


public class kakao2021_2 {
	public static void main(String[] args) {
		int n = 437674;
		int k = 3;
		
		
		System.out.println(solution(n, k));
	}
	
	static int solution(int n, int k) {
		int answer = 0;
		
		 // 진수 변환
        String newN = "";
        while(n > 0) {
            newN = (n % k) + newN;
            n /= k;
        }

        System.out.println(newN); //211020101011

        String[] temp = newN.split("0");
        System.out.println(Arrays.toString(temp));

        for(String s : temp) {
            if(s.length() != 0 && checkPrime(s))
                answer++;
        }

        return answer;
	}
	
	static boolean checkPrime(String s) {
		Long ss = Long.parseLong(s);
		System.out.println("Ss: " + ss);
		boolean isPrime = false;
		
		if(ss == 1)
			isPrime = true;
		
		for(int i = 2; i < Math.sqrt(ss)+1; i++) {
			if(ss % i == 0) {
				isPrime = true;
				break;
			}
		}
		
		return !isPrime;
	}
}
