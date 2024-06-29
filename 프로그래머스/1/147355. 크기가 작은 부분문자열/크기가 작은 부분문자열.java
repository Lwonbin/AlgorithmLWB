class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        char[] Tarr = t.toCharArray();
        long P = Long.parseLong(p);
        int length = t.length() - p.length() +1 ;
        int count = 0;
        
        for(int i=0; i<length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<i+p.length(); j++){
                sb.append(t.charAt(j));
            }
            if(P >= Long.parseLong(sb.toString())){
                count++;
            }
            
        }
        answer = count;
        
        return answer;
    }
}