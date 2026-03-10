    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] dice = new int[6];
            // 0: top, 1: bottom, 2: north, 3: south, 4: east, 5: west
            for(int i=0; i<6; i++){
                dice[i] = 0;
            }


            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            st = new StringTokenizer(br.readLine());


            for(int i=0; i<K; i++){
                int[] temp = dice.clone();
                int t = Integer.parseInt(st.nextToken());
                // 만약 1이라면? 동쪽이라면
                /*  0 -> 5
                    1 -> 4
                    4 -> 0
                    5 -> 1
                 */

                // 만약 2라면? 서쪽이라면
                /*  0 -> 4
                    1 -> 5
                    4 -> 1
                    5 -> 0
                 */
                // 만약 3라면? 북쪽이라면
                /*  2 -> 0
                    0 -> 3
                    3 -> 1
                    1 -> 2
                 */
                // 만약 4라면? 남쪽이라면
                /*  2 -> 1
                    0 -> 2
                    3 -> 0
                    1 -> 3
                 */
                if(t == 1){
                    if(y+1<0 || y+1>=M){
                        continue;
                    }
                    dice[0] = temp[5];
                    dice[1] = temp[4];
                    dice[4] = temp[0];
                    dice[5] = temp[1];
                    y++;
                }else if(t == 2){
                    if(y-1 <0 || y-1 >=M){
                        continue;
                    }
                    dice[0] = temp[4];
                    dice[1] = temp[5];
                    dice[4] = temp[1];
                    dice[5] = temp[0];
                    y--;
                }else if(t ==3) {
                    if (x - 1 < 0 || x - 1 >= N) {
                        continue;
                    }
                    dice[2] = temp[0];
                    dice[0] = temp[3];
                    dice[3] = temp[1];
                    dice[1] = temp[2];
                    x--;
                }else if(t==4){
                    if(x+1 <0 || x+1 >=N){
                        continue;
                    }
                    dice[2] = temp[1];
                    dice[0] = temp[2];
                    dice[3] = temp[0];
                    dice[1] = temp[3];
                    x++;
                }
                if(map[x][y] == 0){
                    map[x][y] = dice[1];
                }else {
                    int tempCur = map[x][y];
                    map[x][y] = 0;
                    dice[1] = tempCur;
                }


                System.out.println(dice[0]);
            }



        }

    }