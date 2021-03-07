package study8;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Bj_1931회의실배정 {

    static int n;
    static int m;
    static LinkedList<int[]> list = new LinkedList<>();
    static int visit=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list.add(new int[] {a,b});
        }

        Collections.sort(list,new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }

        });

        //입력확인

        int c=0;
        for(int i=0;i<list.size();i++) {
            if(visit<=list.get(i)[0]) {
                c++;
                visit=list.get(i)[1];
            }
        }

        System.out.println(c);

    }
}