package PGMS;

import java.util.*;
import java.util.Map.Entry;

public class pgMenuRenew {

    HashMap<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        
        ArrayList<String> answerList = new ArrayList<>();
        
        for (int courseLength : course) {
            map = new HashMap<>();
            for (String order : orders) {
                String[] tmpOrder = order.split("");
                Arrays.sort(tmpOrder);
                String sortedOrder = String.join("",tmpOrder);
                combination(sortedOrder,"",0,courseLength);
                
            }
            
            int maxCount = 0;
            for (int value : map.values()) {
                maxCount = Math.max(maxCount, value);
            }
            
            if (maxCount >= 2) {
                for (Entry<String, Integer> entrySet : map.entrySet()) {
                    if (entrySet.getValue() == maxCount) {
                        answerList.add(entrySet.getKey());
                    }
                }
            }
            
        }
        Collections.sort(answerList);
        return answerList.toArray(new String[answerList.size()]);
    }
    
    public void combination(String order, String tmpCourse, int depth, int length) {
        if(depth == length) {
            map.put(tmpCourse, map.getOrDefault(tmpCourse,0)+1);
        }
        else {
            for(int i=0;i<order.length();i++) {
                combination(order.substring(i+1,order.length()),tmpCourse+order.charAt(i),depth+1,length);
            }
        }
    }
}