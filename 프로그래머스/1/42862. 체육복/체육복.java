import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // Arrays.sort(lost);
        // Arrays.sort(reserve);
        
        int[] arr = new int[n+1];
        
        
        for(int i=1; i<=n; i++){
            arr[i] = 1;
        }
        
        for(int j=0; j<lost.length; j++){
            int target = lost[j];
            arr[target] = arr[target]-1;
        }
        
        for(int j=0; j<reserve.length; j++){
            int target = reserve[j];
            arr[target] = arr[target] +1 ;
        }
        
        for(int i=1; i<=n; i++){
            System.out.print(arr[i] +" ");
        }
        

        
        for(int i=1; i<=n; i++){
            if(i==n && arr[i] == 2){
                if(arr[i-1] == 0){
                    arr[i-1] += 1;
                    arr[i] -= 1;
                }
            }else if(i==1 && arr[i] == 2){
                if(arr[i+1] == 0){
                    arr[i+1] += 1;
                    arr[i] -=1;
                }
            }
            
            else{
                if(arr[i] == 2){
                if(arr[i-1] == 0){
                    arr[i-1] += 1;
                    arr[i] -= 1;
                }else if(arr[i+1] == 0){
                    arr[i+1] += 1;
                    arr[i] -=1;
                }
                }
            }
            
            
            
        }
        
        for(int i=1; i<=n; i++){
            if(arr[i] == 1 || arr[i] == 2){
                answer++;
            }
        }
        
        
        
        
        
        return answer;
    }
}