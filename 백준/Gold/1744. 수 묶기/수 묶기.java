    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



            int N = Integer.parseInt(br.readLine());

            int checkMinus = 0;
            int checkPlus = 0;
            int checkZero = 0;
            int checkOne = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i=0; i<N; i++){
                int cur = Integer.parseInt(br.readLine());

                if(cur == 1){
                    checkOne++;
                }
                else if(cur > 0){
                    checkPlus++;
                    pq.add(cur);
                }else if(cur <0){
                    checkMinus++;
                    pq.add(cur);
                }else{
                    checkZero++;
                }
            }



            Integer[] minus = new Integer[checkMinus];
            Integer[] plus = new Integer[checkPlus];

            for(int i=0; i<checkMinus; i++){
                minus[i] = pq.poll();
            }

            for(int i=0; i<checkPlus; i++){
                plus[i] = pq.poll();
            }


            Arrays.sort(plus, Collections.reverseOrder());



            int sum = 0;
            sum += checkOne;


            if(checkMinus % 2 == 0){
                for(int i=0; i<checkMinus; i+=2){
                    sum += minus[i] * minus[i+1];
                }
            }else if(checkMinus % 2 == 1){
                if(checkMinus >1){
                    for(int i=0; i<checkMinus-1; i+=2){
                        sum += minus[i] * minus[i+1];
                    }
                }

                if(checkZero == 0){
                    sum+= minus[checkMinus-1];
                }
            }


            if(checkPlus == 1){
                sum+= plus[0];
            }else if(checkPlus % 2 == 0){
                for(int i=0; i<checkPlus; i+=2){
                    sum += plus[i] * plus[i+1];
                }
            }else if(checkPlus % 2 == 1){
                for(int i=0; i<checkPlus-1; i+=2){
                    sum+= plus[i] * plus[i+1];
                }
                sum+=plus[checkPlus-1];
            }




            System.out.println(sum);






        }

    }