import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Solution {
    static class Point {
		String state;
		String time;
		Long amount;
		
		Point(String state, String time, Long amount) {
			this.state = state;
			this.time = time;
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "Point [state=" + state + ", time=" + time + ", amount=" + amount + "]";
		}
		
	}
    
    static class Point2 {
		String carNum;
		Long money;
		
		Point2(String carNum, Long money) {
			this.carNum = carNum;
			this.money = money;
		}

		@Override
		public String toString() {
			return "Point2 [carNum=" + carNum + ", money=" + money + "]";
		}
		
		
	}
    
    public Object[] solution(int[] fees, String[] records) throws ParseException{
         Object[] answer = {};
	     
	     HashMap<String, Point> hmap = new HashMap<>();
	     
	     for(String record : records) {
	    	 System.out.println("record: " + record);
	    	 String[] arr = record.split(" ");
	    	 
	    	 String time = arr[0];
	    	 String carNum = arr[1];
	    	 String state = arr[2];
	    	 
	    	 if(!hmap.containsKey(carNum)) {
	    		 hmap.put(carNum, new Point(state, time, 0l));
	    	 }
	    	 else {
	    		 if(hmap.get(carNum).state.equals("IN") && state.equals("OUT")) {
	    			 SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	    			 Date time1 = format.parse(hmap.get(carNum).time);
	    			 Date time2 = format.parse(time);
	    			 
//	    			 System.out.println("time1: " + time1);
//	    			 System.out.println("time2: " + time2);
	    			 
	    			 long diff = (time2.getTime() - time1.getTime()) / (60*1000);
	    			 	    			 
	    			 hmap.put(carNum, new Point(state, "", hmap.get(carNum).amount + diff));
	    		 }
	    		 else {
	    			 hmap.put(carNum, new Point(state, time, hmap.get(carNum).amount));
	    		 }
	    	 }
	    	 
//	    	 System.out.println(hmap);

	     }
	 
	     for(String key : hmap.keySet()) {
    		 if(hmap.get(key).state.equals("IN")) {
    			 SimpleDateFormat format = new SimpleDateFormat("HH:mm");
    			 Date time1 = format.parse(hmap.get(key).time);
    			 Date time2 = format.parse("23:59");
    			 long diff = (time2.getTime() - time1.getTime()) / (60*1000);
    			 
    			 hmap.put(key, new Point("IN", "23:59", hmap.get(key).amount + diff)); 
    		 }
    	 }
	     
	     System.out.println(hmap);
	     List<Point2> list = new ArrayList<>();
	     
	     for(String key : hmap.keySet()) {
	    	 long amount = hmap.get(key).amount; // 누적시간
	    	 long money = 0;
	    	 if(amount < fees[0]) {
	    		 money = fees[1];
	    	 }
	    	 else {
	    		 money = fees[1] + ((long) Math.ceil((double)(hmap.get(key).amount - fees[0]) / fees[2]) * fees[3]);
	    	 }
	    	 list.add(new Point2(key, money));
	     }
	     
	     System.out.println(list);
	     
	     Collections.sort(list, (o1, o2) -> {
	    	 return o1.carNum.compareTo(o2.carNum);
	     });
	     
	     System.out.println(list);
	     
	     List<Long> answerList = new ArrayList<>();
	     
	     for(Point2 p : list) {
	    	 answerList.add(p.money);
	     }
	     
	     System.out.println(answerList);
	     
	     answer = answerList.toArray();
	     
		 return answer;
    }
}