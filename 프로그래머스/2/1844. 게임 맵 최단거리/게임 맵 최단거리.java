import java.util.*;
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer = 0;
    
    static int[][] visited;
    static int[][] map;
    static int n,m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        visited = new int[n][m];
        
        bfs(maps, visited);
        
        answer = visited[maps.length-1][maps[0].length-1];
        
        if(answer==0){
            return -1;
        }
        
        
        return answer;
    }
    
    public static void bfs(int[][] maps, int[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        
        int x=0;
        int y =0;
        visited[x][y] = 1;
        
        queue.add(new int[]{x,y});
        
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int curx = current[0];
            int cury = current[1];
            
            for(int i=0; i<4; i++){
                int mx = curx+  dx[i];
                int my = cury + dy[i];
                
                if(mx<0 || my<0 || mx>=n || my>=m){
                    continue;
                }
                
                if(visited[mx][my]==0 && maps[mx][my]==1){
                    visited[mx][my] = visited[curx][cury]+1;
                    queue.add(new int[]{mx,my});
                }
            }
        }
        
    }
}