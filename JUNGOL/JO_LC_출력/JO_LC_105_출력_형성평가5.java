package start_1.JO_LC_출력;

public class JO_LC_105_출력_형성평가5 {

	public static void main(String[] args) {
//          Seoul     10,312,545        +91,375
//          Pusan      3,567,910         +5,868
//        Incheon      2,758,296        +64,888
//          Daegu      2,511,676        +17,230
//        Gwangju      1,454,636        +29,774

		String[] city = {"Seoul", "Pusan", "Incheon", "Daegu", "Gwangju"};
		String[] num1 = {"10,312,545", "3,567,910", "2,758,296", "2,511,676", "1,454,636"};
		String[] num2 = {"+91,375", "+5,868", "+64,888", "+17,230", "+29,774"};
		
		for(int i = 0; i < 5; i++) {
			System.out.printf("%15s%15s%15s\n", city[i], num1[i], num2[i]);
		}
	}

}
