    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String N = br.readLine();


            Integer[] arr = new Integer[N.length()];

            for(int i=0; i<N.length(); i++){
                arr[i] = Integer.parseInt(N.charAt(i)+"");
            }


            boolean check = false;
            int sum = 0;
            for(int i =0; i<N.length(); i++){
                if(arr[i] == 0 ){
                    check = true;
                }

                sum+=arr[i];
            }

            if(check && sum % 3 == 0){
                Arrays.sort(arr, Collections.reverseOrder());
                for(int i=0; i<N.length(); i++){
                    System.out.print(arr[i]);
                }
            }else{
                System.out.println(-1);
            }








        }

    }