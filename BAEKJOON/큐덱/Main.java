package 큐덱;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	static Stack hight = new Stack();
	static Stack index = new Stack();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");

		for (int i = 1; N >= i; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		hight.push(arr[1]);
		index.push(1);
		bw.write(""+0);

		for (int i = 2; N >= i; ++i) {
			while (true) {
				if (!hight.isEmpty()) {
					int top = hight.peek();
					if (top > arr[i]) {
						bw.write(" " + index.peek());
						hight.push(arr[i]);
						index.push(i);
						break;
					} else {
						hight.pop();
						index.pop();
					}
				} else {
					bw.write(" " + 0);
					hight.push(arr[i]);
					index.push(i);
					break;
				}
			}
		}
		bw.flush();
	}
}