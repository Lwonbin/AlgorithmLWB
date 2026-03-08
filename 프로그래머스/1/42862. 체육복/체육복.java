import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // Arrays.sort(lost);
        // Arrays.sort(reserve);
        
        int[] arr = new int[n+1];
        
        
        for(int i=1; i<=n; i++){
            arr[i] = 0;
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
            if(arr[i] == -1){
                if(i-1>=1 && arr[i-1] > 0){
                    arr[i-1]--;
                    arr[i]++;
                }else if(i+1 <=n && arr[i+1] >0){
                    arr[i+1]--;
                    arr[i]++;
                }
            }
        }
        
        
        for(int i=1; i<=n; i++){
            if(arr[i] >=0){
                answer++;
            }
        }
        
        
        
        
        return answer;
    }
}