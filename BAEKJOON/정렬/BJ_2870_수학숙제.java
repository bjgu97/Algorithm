package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BJ_2870_수학숙제 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] NArr = new int[N];
		List<BigInteger> list = new ArrayList<>();
		for(int n = 0; n < N; n++) {
			String[] sArr = br.readLine().split("\\D");
			
			for(int i = 0; i < sArr.length; i++) {
				if(!sArr[i].equals("")) {
					list.add(new BigInteger(sArr[i]));
				}
			}
		}
		Collections.sort(list);
		for(BigInteger a : list)
			System.out.println(a);
	}
}
