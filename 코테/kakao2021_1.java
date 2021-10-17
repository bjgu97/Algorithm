import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
        
        HashMap<String, List<String>> hmap1 = new HashMap<>();
		HashMap<String, Integer> hmap2 = new HashMap<>();
//		
		for(String id : id_list) {
			hmap1.put(id, new ArrayList<>());
			hmap2.put(id, 0);
		}
//		
		for(String s : report) {
			String[] sArr = s.split(" ");
			
            if(!hmap1.get(sArr[0]).contains(sArr[1])){
			    hmap1.get(sArr[0]).add(sArr[1]); // 각 캐릭터가 누구 신고했는지 저장.
			    hmap2.put(sArr[1], hmap2.get(sArr[1]) + 1); // 각 캐릭터 신고당한 횟수 저장.
            }
		}

		int idx = 0;
		
		List<String> temp = new ArrayList<>(); 
		
		for(String s : hmap2.keySet()) {
			if(hmap2.get(s) >= k) { // k번 이상 신고당했으면
				temp.add(s); // temp에 저장.
			}
		}
				
		for(String s : id_list) {
			for(String p : temp) {
				if(hmap1.get(s).contains(p)) { // 각 캐릭터가 신고한 사람 중 temp 에 있는 캐릭터가 있으면
					answer[idx]++; // 저장.
				}
			}
			idx++;
		}

        
        return answer;
    }
}