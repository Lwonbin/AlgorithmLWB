    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



            int N = Integer.parseInt(br.readLine());

            if(N<2){
                System.out.println(0);
                return;
            }

            List<Integer> list = new ArrayList<>();

            for (int i = 2; i <= N; i++) {
                boolean isPrime = true;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    list.add(i);
                }
            }

            int[] arr = new int[list.size()];

            for(int i=0; i<list.size(); i++){
                arr[i] = list.get(i);
            }


            int start = 0;
            int end = 0;
            int sum = 0;
            int count = 0;
            while(true){
                if(sum >= N){
                    if(sum==N){
                        count++;
                    }
                    sum -= arr[start++];
                }else{
                    if(end == arr.length) break;
                    sum += arr[end++];
                }
            }

            System.out.println(count);


            br.close();


        }
    }
