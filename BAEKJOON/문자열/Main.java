package 문자열;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        boolean[] used = new boolean[26];
        int[] arr = new int[128];
        for(int i = 0; i < 26; ++i)
            arr[i+'a'] = arr[i+'A'] = i;
        System.out.println(Arrays.toString(arr));
        
        while(n-- > 0){
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int index = -1;
            while(st.hasMoreTokens()){
                String tmp = st.nextToken();
                char c = tmp.charAt(0);
                index++;
                if(!used[arr[c]]){
                    used[arr[c]] = true;
                    break;
                }
                index += tmp.length();
            }
            if(index == str.length()){
                for(int i = 0; i < str.length(); ++i){
                    char c = str.charAt(i);
                    if(str.charAt(i) == ' ')
                        continue;
                    if(!used[arr[c]]){
                        used[arr[c]] = true;
                        index = i;
                        break;
                    }
                }
            }

            if(index != str.length()){
                for(int i = 0; i < index; ++i)
                    bw.write(str.charAt(i));
                bw.write("["+str.charAt(index)+"]");
                for(int i = index+1; i < str.length(); ++i)
                    bw.write(str.charAt(i));
                bw.write("\n");
            }
            else
                bw.write(str+"\n");
        }
        bw.flush();
    }
}