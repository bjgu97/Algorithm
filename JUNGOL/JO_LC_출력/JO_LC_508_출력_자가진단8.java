package start_1.JO_LC_출력;

public class JO_LC_508_출력_자가진단8 {

	public static void main(String[] args) {
//		다음과 같이 출력되는 프로그램을 작성하라.
//
//		(각 요소들은 10칸씩 공간을 확보하여 오른쪽으로 정렬하여 출력한다.)
//		 item     count     price
//	       pen        20       100
//	      note         5        95
//	    eraser       110        97
		
		System.out.printf("%10s%10s%10s\n", "item", "count", "price");
		System.out.printf("%10s%10d%10d\n", "pen", 20, 100);
		System.out.printf("%10s%10d%10d\n", "note", 5, 95);
		System.out.printf("%10s%10d%10d", "eraser", 110, 97);
		
	}

}
