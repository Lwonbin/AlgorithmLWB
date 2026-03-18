    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static int N;
        static char[][] student;
        static int[] selected;
        static int answer = 0;
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



            student = new char[5][5];
            selected = new int[7];

            for(int i=0; i<5; i++){
                String str = br.readLine();
                for(int j=0; j<5; j++){
                    student[i][j] = str.charAt(j);
                }
            }

            dfs(0, 0, 0, 0);

            System.out.println(answer);

        }



        static void dfs(int depth, int start, int sCnt, int yCnt){
            if(yCnt >= 4) return;
            if(depth == 7){
                if(possible()){
                    answer++;
                }
                return;
            }


            for(int i = start; i < 25; i++){
                selected[depth] = i;

                int r = i /5;
                int c = i% 5;

                if(student[r][c] == 'S'){
                    dfs(depth +1, i+1, sCnt +1, yCnt);
                }else{
                    dfs(depth +1, i+1, sCnt, yCnt+1);
                }

            }

        }

        static boolean possible(){
            boolean[] picked = new boolean[25];
            for(int x : selected){
                picked[x] = true;
            }

            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[25];

            queue.add(selected[0]);
            visited[selected[0]] = true;
            int count = 1;

            int[] dx = {-1,1,0,0};
            int[] dy = {0,0,-1,1};

            while(!queue.isEmpty()){
                int cur = queue.poll();
                int r = cur/ 5;
                int y = cur%5;

                for(int i=0; i<4; i++){
                    int nr = r + dx[i];
                    int ny = y +dy[i];

                    int next = nr*5 + ny;

                    if(nr>=0 && ny>=0 && nr <5 && ny<5){
                        if(picked[next] && !visited[next]){
                            queue.add(next);
                            visited[next] = true;
                            count++;
                        }
                    }

                }
            }


            return count == 7;







        }








    }