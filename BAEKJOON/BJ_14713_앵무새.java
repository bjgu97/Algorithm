import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ_14713_앵무새 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Queue> list = new ArrayList<>();
		
		for(int n = 0; n < N; n++) {
			Queue<String> queue = new LinkedList<>();
			
			String s = br.readLine();
			String[] sArr = s.split(" ");
			for(String ss : sArr) {
				queue.add(ss);
			}
			list.add(queue);
		}
		
		String L = br.readLine();
		String[] LArr = L.split(" ");
		boolean flag = true;
		
		for(int a = 0; a < LArr.length; a++) {
			String word = LArr[a];
			int tmp = 0;
			for(int b = 0; b < list.size(); b++) {
				if(!list.get(b).isEmpty() && list.get(b).peek().equals(word)) {
					list.get(b).poll();
				}
				else {
					if(list.get(b).isEmpty() || (!list.get(b).isEmpty() && !list.get(b).peek().equals(word))) {
						tmp++;
					}
				}
			}
			
			if(tmp == N) {
				flag = false;
			}
			
//			for(int b = 0; b < list.size(); b++) {
//				System.out.println("@@@ " + list.get(b));
//			}
//			System.out.println();
		}
		for(int b = 0; b < list.size(); b++) {
			if(!list.get(b).isEmpty()) {
				flag = false;
			}
		}
		
		if(flag)
			System.out.println("Possible");
		else
			System.out.println("Impossible");
		
	}
}
