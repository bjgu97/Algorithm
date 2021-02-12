package Algorithm.sw.d3;
public class Solution_사칙연산유효성검사 {

    static int N;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();
        int ans=1;
        int T=10;
        for(int t=1;t<=T;t++) {
            ans=1;
            N=Integer.parseInt(br.readLine()); //노드 수
            int i=0;
            for(i=1;i<=N;i++) {
                String st=br.readLine();
                String[] str=st.split(" ");

                if(str[1].equals("*")str[1].equals("+")str[1].equals("-")||str[1].equals("/")) {
                    if(str.length<3) {
                        ans=0;

                    }
                }

            }

            sb.append("#"+t+" "+ans+"\n");
        }

        System.out.println(sb);
    }
}