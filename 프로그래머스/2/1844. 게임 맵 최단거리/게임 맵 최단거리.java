import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int[][] visited;
    
    static int N,M;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visited = new int[N][M];
        
        for(int i=0; i<N; i++){
            Arrays.fill(visited[i],-1);
        }
        
        bfs(0,0, maps);
        
        return visited[N-1][M-1];
        
    }
    static void bfs(int x, int y, int[][] maps){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        visited[x][y] = 1;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            if(curX == N-1 && curY == M-1){
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(visited[nx][ny] == -1 && maps[nx][ny] == 1){
                        visited[nx][ny] = visited[curX][curY] +1;
                        queue.add(new int[]{nx,ny});
                    }
                }
                
            }
        }
    }
    
}
