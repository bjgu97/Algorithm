import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class BJ_2529_부등호 {
    static List<String> list = new ArrayList<>();
    public static boolean check(String key, String [] s) { 
        for(int i=1; i<key.length(); i++) {
            if(s[i-1].equals("<")) {
                if(!(key.charAt(i-1)-'0' < key.charAt(i)-'0')) {
                    return false;
                }
            }
            else {
                if(!(key.charAt(i-1)-'0' > key.charAt(i)-'0')) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void go(String[] s, boolean [] visited, String key, int size){
        if(key.length() == size) {
            if(check(key, s)) {
                list.add(key);
            }
            return;
        }
        if(key.length() > size )
            return;
        for(int i=0; i<=9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                go(s, visited, key+i, size);
                visited[i] = false; 
            }
        }
    }
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] s = new String[N];
        for(int n = 0; n < N; n++) {
        	s[n] = st.nextToken();
        }
        boolean [] visited = new boolean[10];
        
        go(s,visited, "", N+1);
        
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }

}