class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = 1;
        }
        //arr에는 1 1 1 1 1 1 1 1 이 있을 것 이다.  
        for(int i=0; i<section.length; i++){
            arr[section[i]-1] = 0;
        }
        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i]);
        // }
        
        for(int i=0; i<n; i++){

            if(arr[i] == 0){
                for(int j=i; j<i+m; j++){
                    if(j>=n){
                        break;
                    }
                    arr[j] = 1;
                }
                
                answer++;
            }
    
            System.out.println();
            
        }
        
        
        
        return answer;
    }
}