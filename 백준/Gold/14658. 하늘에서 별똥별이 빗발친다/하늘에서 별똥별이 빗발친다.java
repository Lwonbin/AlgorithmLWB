import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N,M,L,K;
    static List<int[]> stars;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stars = new ArrayList<>();


        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            stars.add(new int[]{x,y});

        }

        int result = 0;
        for(int[] s1: stars){
            for(int[] s2: stars){

                //이게 트램펄린 위치
                int x = s1[0];
                int y = s2[1];

                x = Math.min(x, N-L);
                y = Math.min(y, M-L);

                int count = checkXY(x,y);
                result = Math.max(count, result);
            }
        }


        System.out.println(K-result);
        br.close();
    }



    static int checkXY(int x, int y){
        int count = 0;
        for(int[] cur : stars){

            if(cur[0] >= x && cur[0] <= x+L && cur[1] >=y && cur[1] <=y+L){

                count++;
            }
        }
        return count;
    }

}
