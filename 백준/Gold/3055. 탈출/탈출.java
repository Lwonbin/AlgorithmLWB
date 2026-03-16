    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static Character[][] map;
        static boolean[][] visited;

        static int[] dx = {-1,1,0,0};
        static int[] dy = {0,0,-1,1};

        static int C,R;

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



            StringTokenizer st = new StringTokenizer(br.readLine());

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new Character[R][C];
            visited = new boolean[R][C];

            Queue<int[]> hogQ = new ArrayDeque<>();
            Queue<int[]> waterQ = new ArrayDeque<>();


            for(int i=0; i<R; i++){
                String str = br.readLine();
                for(int j=0; j<C; j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == 'S'){
                        hogQ.add(new int[]{i,j});
                        map[i][j] = '.';
                    }else if(map[i][j] =='*'){
                        waterQ.add(new int[]{i,j});
                    }

                }
            }

            int answer = 0;

            while(!hogQ.isEmpty()){

                int waterSize = waterQ.size();
                for(int i=0; i<waterSize; i++){
                    int[] cur = waterQ.poll();
                    int curX = cur[0];
                    int curY = cur[1];
                    for(int j=0; j<4; j++){
                        int nx = curX + dx[j];
                        int ny = curY + dy[j];
                        if(nx >=0 && ny>=0 && nx < R && ny <C){
                            if(!visited[nx][ny] && map[nx][ny] == '.'){
                                map[nx][ny] = '*';
                                waterQ.add(new int[]{nx, ny});
                            }
                        }
                    }
                }


                int hogSize = hogQ.size();
                for(int i=0; i<hogSize; i++){
                    int[] cur = hogQ.poll();
                    int curX = cur[0];
                    int curY = cur[1];
                    for(int j=0; j<4; j++){
                        int nx = curX + dx[j];
                        int ny = curY + dy[j];

                        if(nx >=0 && ny>=0 && nx < R && ny <C){

                            if(map[nx][ny] == 'D'){
                                System.out.println(answer+1);
                                return;
                            }

                            if(!visited[nx][ny] && map[nx][ny] == '.'){
                                hogQ.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }

                answer++;

            }


            System.out.println("KAKTUS");


        }

    }