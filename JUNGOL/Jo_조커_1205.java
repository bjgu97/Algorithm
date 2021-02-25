import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jo_조커_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int nZero = 0;
        for(int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == 0)
                nZero++;
        }
        if(nZero == n){
            System.out.println(n);
            return;
        }
        Arrays.sort(arr);
        arr = Arrays.copyOfRange(arr, nZero, arr.length);
        bw.write(String.valueOf(straight(arr, nZero)));
        bw.flush();
    }

    static int straight(int[] arr, int nZero){
        int ret = 0;
        for(int i = 0; i < arr.length; ++i){
            ret = Math.max(ret, start(arr, i, nZero));
        }
        return ret;
    }

    static int start(int[] arr, int src, int nZero){
        int len = 1;
        int cur = src;
        while(cur < arr.length-1){
            if(arr[cur] == arr[cur+1])
                cur++;
            else if(arr[cur+1]-arr[cur]-1 <= nZero){
                nZero -= arr[cur+1]-arr[cur]-1;
                len += arr[cur+1]-arr[cur];
                cur++;
            }
            else
                break;
        }
        return len+nZero;
    }
}