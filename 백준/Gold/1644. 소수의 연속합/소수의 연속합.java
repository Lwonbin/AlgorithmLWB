    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int N = Integer.parseInt(br.readLine());

            List<Integer> primes = new ArrayList<>();


            for(int i=2; i<=N; i++){
                boolean check = true;
                for(int j=2; j<=Math.sqrt(i); j++){
                    if(i % j == 0){
                        check = false;
                        break;
                    }
                }
                if(check){
                    primes.add(i);
                }
            }

            if(N < 2){
                System.out.println(0);
                return;
            }

            int start = 0;
            int end = 1;

            int sum = primes.get(0);

            int answer = 0;

            while(start <= end){



                if(sum < N){
                    if(end >= primes.size()){
                        break;
                    }
                    sum+=primes.get(end);
                    end++;
                }else{
                    if(sum==N) answer++;
                    sum-=primes.get(start);
                    start++;
                }


            }
            System.out.println(answer);





        }

    }