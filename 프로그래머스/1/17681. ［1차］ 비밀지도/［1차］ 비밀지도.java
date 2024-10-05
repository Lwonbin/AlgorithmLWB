class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] arr_first = new String[n];
        String[] arr_second = new String[n];
        
        for(int i=0; i<arr1.length; i++){
            String current1 = Integer.toBinaryString(arr1[i]);
            String current2 = Integer.toBinaryString(arr2[i]);
            
            while (current1.length() < n) {
                current1 = "0" + current1;
            }
            while (current2.length() < n) {
                current2 = "0" + current2;
            }
            
            arr_first[i] = current1;
            arr_second[i] = current2;
        }
        
        
        for(int p=0; p<n; p++){
            String secretMap = "";
            for(int q=0; q<n; q++){
                if(arr_first[p].charAt(q) == '1' || arr_second[p].charAt(q)=='1'){
                    secretMap += "#";
                }else{
                    secretMap += " ";
                }
            }
            answer[p] = secretMap;
        }

        

        
        
        return answer;
    }
}