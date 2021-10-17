import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_3691_컴퓨터조립 {
	static class Product {
		String name;
		int price;
		long quality;
		
		Product(String name, int price, long quality) {
			this.name = name;
			this.price = price;
			this.quality = quality;
		}

		@Override
		public String toString() {
			return "product [name=" + name + ", price=" + price + ", quality=" + quality + "]";
		}
				
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 컴퓨터의 성능 = 가장 안좋은 부품의 성능
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 부품의 개수
			int B = Integer.parseInt(st.nextToken()); // 예산
			
			HashMap<String, List<Product>> hmap = new HashMap<>();
			for(int n = 0; n < N; n++) {
				// type name price quality
				st = new StringTokenizer(br.readLine());
				String type = st.nextToken();
				String name = st.nextToken();
				int price = Integer.parseInt(st.nextToken());
				long quality = Long.parseLong(st.nextToken());
				
				if(hmap.containsKey(type)) {
					hmap.get(type).add(new Product(name, price, quality));
				}
				else {
					hmap.put(type, new ArrayList<>());
					hmap.get(type).add(new Product(name, price, quality));
				}

				System.out.println(hmap);
			}
			
		}
	}
}
