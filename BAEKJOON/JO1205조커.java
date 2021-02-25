import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1205조커 {

    static int[] arr = new int[1000001];
    static int N, min = 987654321, max;
    static int zeroCnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num]++;
            if(num != 0) {
                min = Math.min(min, num);
            }
            max = Math.max(max, num);
            if(num == 0) {
                zeroCnt++;
            }
        }

        int res = 0;
        int cnt = 0;

        if(zeroCnt > N / 2) {
            System.out.println(N);
            return;
        }

        for(int i = min; i <= max; i++) {

            if(arr[i] == 0) {
                int zero = zeroCnt;
                int index = i + 1;

                while(zero > 0) {
                    if(arr[index] > 0) {
                        index++;
                    } else {
                        zero--;
                        index++;
                    }

                    if(index > max) {
                        cnt += zero + 1;
                        break;
                    }
                    cnt++;
                }

                res = Math.max(res, cnt);
                cnt = 0;

            } else {
                cnt++;
            }
        }

        if(res == 0) {
            res = Math.max(res, cnt);
        }

        System.out.println(res);
    }

}