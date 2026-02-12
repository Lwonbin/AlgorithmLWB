    import java.io.*;
    import java.util.*;

    public class Main {
        static int[] dx = {0,1,0,-1};
        static int[] dy = {1,0,-1,0};

        static char[][] map;
        static int R, C;

        public static void main(String[] args) throws IOException {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            StringTokenizer st = new StringTokenizer(br.readLine());

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new char[R][C];

            for(int i=0; i<R; i++){
                String cur = br.readLine();
                for(int j=0; j<C; j++){
                    map[i][j] = cur.charAt(j);
                }
            }

            List<int[]> list = new ArrayList<>();

            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j] == 'X'){
                        boolean check = deleteRand(i,j);
                        if(check){
                            list.add(new int[]{i,j});
                        }
                    }
                }
            }

            for(int[] cur : list){
                int x = cur[0];
                int y = cur[1];

                map[x][y] = '.';
            }


            int maxX = 0;
            int maxY = 0;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;





            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j] == 'X'){
                        if(i > maxX){
                            maxX = i;
                        }
                        if(j > maxY){
                            maxY = j;
                        }
                        if(i < minX){
                            minX = i;
                        }
                        if(j < minY){
                            minY = j;
                        }
                    }
                }
            }



            for(int i=minX; i<=maxX; i++){
                for(int j= minY; j<=maxY; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }




        }


        static boolean deleteRand(int x, int y){

            int cnt = 0;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx < 0 || ny <0 || nx>= R || ny>=C || map[nx][ny] == '.'){
                    cnt++;
                }
            }

            if(cnt >=3){
                return true;
            }else{
                return false;
            }
        }
    }