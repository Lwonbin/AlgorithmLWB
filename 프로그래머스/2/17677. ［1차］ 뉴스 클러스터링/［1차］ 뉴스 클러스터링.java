import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        
        multipleList(list1, str1);
        multipleList(list2, str2);
        
        if(list1.size()==0 && list2.size()==0){
            return 65536;
        }
        
        double union = 0.0;
        double intersec = 0.0;
        
        for(int i=0; i<list1.size(); i++){
            String str = list1.get(i);
            
            if(list2.contains(str)){
                intersec++;
                list2.remove(str);
            }
            union++;
        }
  
        return (int)(intersec/(union+list2.size()) * 65536);
        

        
        

    }
    
    private static void multipleList(List<String> list, String str){
        for(int i=0; i<str.length()-1; i++){
            String s = str.substring(i, i + 2).replaceAll("[^a-zA-Z]", "");
            if(s.length()==2){
                list.add(s);
            }
        }
    }
}