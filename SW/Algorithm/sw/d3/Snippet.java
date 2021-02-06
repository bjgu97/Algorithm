package Algorithm.sw.d3;

public class Snippet {
	for (int t = 0; t < 10; t++) {
	         queue.clear();
	         int num = 1;
	         int temp = 0;
	
	         int tc = Integer.parseInt(input.readLine());
	         String[] s = input.readLine().split(" ");
	
	         for (int i = 0; i < 8; i++) {
	            queue.add(Integer.parseInt(s[i]));
	         }
	
	         while (true) {
	            temp = queue.poll();
	            temp = temp - num;
	            num++;
	            if (temp <= 0) {
	               queue.add(0);
	               break;
	            }
	            queue.add(temp);
	
	            if (num == 6)
	               num = 1;
	         }
	
	         output.append("#").append(tc).append(" ");
	         for (Integer integer : queue) {
	            output.append(integer).append(" ");
	         }
	
	         System.out.println(output);
	
	      }
	
	   }
}

