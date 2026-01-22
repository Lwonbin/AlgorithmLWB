import java.io.*;
import java.util.*;

public class Main {

    static List<int[]> combos = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> home = new ArrayList<>();
    static int M, C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        chicken = new ArrayList<>();
        home = new ArrayList<>();


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                int cur = Integer.parseInt(st.nextToken());
                if(cur == 1){
                    home.add(new int[]{i,j});
                }else if(cur == 2){
                    chicken.add(new int[]{i,j});
                }
            }
        }

        C = chicken.size();
        makeCombos(0,0, new int[M]);


        int answer = Integer.MAX_VALUE;

        for(int[] pick : combos){
            answer = Math.min(answer, cityDist(chicken, home, pick));
        }

        System.out.println(answer);


    }


    static void makeCombos(int idx, int cnt, int[] pick){
        if(cnt == M){
            combos.add(pick.clone());
            return;
        }

        if(idx == C) return;

        if(C - idx < M - cnt) return;

        pick[cnt] = idx;
        makeCombos(idx+1, cnt+1, pick);
        makeCombos(idx+1, cnt, pick);



    }


    static int cityDist(List<int[]> chicken, List<int[]> home, int[] pick){
        int sum = 0;

        for(int[] h : home){
            int hx = h[0];
            int hy = h[1];

            int best = Integer.MAX_VALUE;

            for(int idx : pick){
                int[] c = chicken.get(idx);
                int dist = Math.abs(hx - c[0]) + Math.abs(hy-c[1]);
                if(dist < best){
                    best = dist;
                }
            }
            sum += best;

        }

        return sum;
    }


}
