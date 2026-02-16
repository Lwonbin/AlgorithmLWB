    import java.io.*;
    import java.util.*;

    public class Main {
        static int[] Switch;

        public static void main(String[] args) throws IOException {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int N = Integer.parseInt(br.readLine());

            Switch = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=1; i<N+1; i++){
                Switch[i] = Integer.parseInt(st.nextToken());
            }

            Switch[0] = -100;

            int cnt = Integer.parseInt(br.readLine());


            for(int i=0; i<cnt; i++){
                st = new StringTokenizer(br.readLine());
                int sex = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());


                if(sex == 1){
                    int idx = 1;
                    while(true){
                        if(count * idx <= N){
                            if(Switch[count * idx] == 0){
                                Switch[count * idx] = 1;
                            }else if(Switch[count * idx] == 1){
                                Switch[count * idx] = 0;
                            }
                        }else{
                            break;
                        }
                        idx++;
                    }
                }else{
                    int idx = 1;
                    while(true) {

                        if(count+idx > N || count - idx < 1){
                            break;
                        }

                        if (Switch[count + idx] == Switch[count - idx]) {
                            idx++;
                        } else {
                            break;
                        }

                    }

                    ChangeSwitch(idx-1, count);

                }

            }

            int cur = 0;
            for(int i=1; i<=N; i++){

                System.out.print(Switch[i] +" ");
                cur++;

                if(cur % 20 == 0){
                    System.out.println();
                }

            }

            br.close();

        }

        static void ChangeSwitch(int idx, int count){
            int min = count - idx;
            int max = count + idx;


            for(int i= min; i<=max; i++){
                if(Switch[i] == 0){
                    Switch[i] = 1;
                }else if(Switch[i] == 1){
                    Switch[i] = 0;
                }
            }

        }
    }