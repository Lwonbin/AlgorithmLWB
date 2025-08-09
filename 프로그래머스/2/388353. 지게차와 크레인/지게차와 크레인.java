import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        
        map = new char[storage.length+2][storage[0].length()+2];
        visited = new boolean[storage.length+2][storage[0].length()+2];
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                    map[i][j] = '-';
            }
        }
        
        for(int i=1; i<=storage.length; i++){
            for(int j=1; j<=storage[0].length(); j++){
                map[i][j] = storage[i-1].charAt(j-1);
            }
        }
        
        
    
        
        
        
        
        for(int i=0; i<requests.length; i++){
            String cur = requests[i];
            if(cur.length() == 2){
                deleteCur(cur.charAt(0));
            }else{
                bfs(cur.charAt(0));
            }
            
        }
        
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j] != ' ' && map[i][j] != '-'){
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
    
    
    static void bfs(char target){
    visited = new boolean[map.length][map[0].length];
    
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0,0});
    visited[0][0] = true;
    
    while(!queue.isEmpty()){
        int[] cur = queue.poll();
        int curX = cur[0];
        int curY = cur[1];
        
        for(int i=0; i<4; i++){
            int nx = curX + dx[i];
            int ny = curY + dy[i];
            
            if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length){
                if(!visited[nx][ny]) {
                    // 빈칸이면 계속 탐색
                    if(map[nx][ny] == '-' || map[nx][ny] == ' ') {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                    // 타겟이면 지우지만 큐에는 넣지 않음
                    else if(map[nx][ny] == target) {
                        visited[nx][ny] = true;
                        map[nx][ny] = ' ';
                    }
                }
            }
        }
    }
}

    
    
    
    static void deleteCur(char cur){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j] == cur){
                    map[i][j] = ' ';
                }
            }
        }
    }
}