import java.util.*;
class Solution {
    static int N,r;
    static int[] arr;
    static List<int[]> list = new ArrayList<>();
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        N = n;
        r = 5;
        arr = new int[r];
        comb(1,0);
        for(int i=0; i<list.size(); i++){
            int[] cur = list.get(i);
            boolean check = false;
            
            for(int j=0; j<q.length; j++){
                int count = 0;
                for(int z=0; z<r; z++){
                    for(int k=0; k<r; k++){
                        if(cur[k] == q[j][z]){
                            count++;
                        }
                    }
                }
                if(ans[j] != count){
                    check = true;
                    break;
                }
            }
            
            if(!check){
                answer++;
            }
            
        }
        
        
        return answer;
    }
    
    static void comb(int start, int depth){
        
        if(depth == r){
            list.add(arr.clone());
            return;
        }
        
        
        for(int i=start;i<=N; i++){
            arr[depth] = i;
            comb(i+1, depth+1);
        }
        
        
    }
}