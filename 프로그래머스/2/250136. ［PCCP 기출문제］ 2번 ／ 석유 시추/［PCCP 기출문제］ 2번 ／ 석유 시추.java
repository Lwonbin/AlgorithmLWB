import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M;
    static int[][] sum;
    static boolean[][] visited;
    static int[][] group;
    static int cnt = 1;
    public int solution(int[][] land) {
        int answer = 0;
        
        int[] maxValue = new int[land[0].length];
        N = land.length;
        M = land[0].length;
        
        sum = new int[N][M];
        visited = new boolean[N][M];
        group = new int[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    bfs(i,j, land);
                }
            }
        }
        

        
        for(int j=0; j<M; j++){
            boolean[] used = new boolean[cnt];
            int total = 0;
            for(int i=0; i<N; i++){
                if(sum[i][j] >0 && !used[group[i][j]]){
                    total += sum[i][j];
                    used[group[i][j]] = true;
                }
            }
            
            answer = Math.max(answer, total);
        }
        

        
        return answer;
    }
    
    static void bfs(int x, int y, int[][] land){
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{x,y});
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        int count = 1;
        group[x][y] = cnt;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(!visited[nx][ny] && land[nx][ny] == 1){
                        count++;
                        group[nx][ny] = cnt;
                        visited[nx][ny] = true;
                        list.add(new int[]{nx,ny});
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
        cnt++;
        
        for(int[] cur : list){
            int curX = cur[0];
            int curY = cur[1];
            sum[curX][curY] = count;
        }
    }
}