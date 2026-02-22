    import java.io.*;
    import java.util.*;

    public class Main {


        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

           int n = Integer.parseInt(br.readLine());

           StringTokenizer st = new StringTokenizer(br.readLine());

           String[] arr = new String[n];

           for(int i=0; i<n; i++){
               arr[i] = st.nextToken();
           }

           Arrays.sort(arr, (o1, o2) -> {
               return (o2+o1).compareTo(o1+o2);
           });


           if(arr[0].equals("0")){
               System.out.println(0);
               return;
           }
           for(int i =0; i<n; i++){
               System.out.print(arr[i]);
           }


        }
    }