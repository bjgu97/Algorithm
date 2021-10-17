import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_10434_행복한소수 {
    static boolean[] prime = new boolean[10001];
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        initPrime();

        for(int n = 0; n < N; n++) {
            list = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 순서
            int B = Integer.parseInt(st.nextToken()); // 수

            sb.append(A).append(" ");
            sb.append(B).append(" ");
            sb.append(func(B)).append("\n");
            System.out.println(list);
        }
        System.out.println(sb);
    }
    static String func(int B) {
        boolean flag = false;
        
        int BB = B;
        while(true) {
            int tempB = square(BB);
            int initB = tempB;
            if(tempB == 1 && !prime[B]) { // 행복한수이고 소수이면
                flag = true;
                break;
            }
            else if(tempB == 1 && prime[B]) { // 행복한수이지만 소수 아니면
                flag = false;
                break;
            }
            else if(list.contains(initB)) { // 다시 자기 자신으로 돌아오면(무한루프)
                flag = false;
                break;
            }
            else {
            	list.add(tempB);
                BB = tempB;
            }
        }

        if(flag)
            return "YES";
        else
            return "NO";
    }
    static int square(int B)  {
        String s = Integer.toString(B);
        int temp = 0;
        for(int i = 0; i < s.length(); i++) {
            temp += ((s.charAt(i) - '0') * (s.charAt(i) - '0'));
        }
        return temp;
    }
    
    static void initPrime() {
    	Arrays.fill(prime, false);
        prime[1] = true;

        for(int i = 2; i <= 10000; i++) {
            for(int j = 2; i*j <= 10000; j++) {
                prime[i*j] = true;
            }
        }
    }
    
}