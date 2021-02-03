import java.util.Arrays;

public class main {
	public static void main(String[] args) {
		
	int[] srcArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	int[] tgtArr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	System.arraycopy(srcArr, 2,  tgtArr,  1,  3);
	System.out.println(Arrays.toString(tgtArr));
		}
}
