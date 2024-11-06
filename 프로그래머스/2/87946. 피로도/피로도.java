class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, boolean[] visited, int count){
        answer = Math.max(answer, count);
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && dungeons[i][0]<=k){
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, visited, count+1);
                visited[i] = false;
            }
        }
    }
}