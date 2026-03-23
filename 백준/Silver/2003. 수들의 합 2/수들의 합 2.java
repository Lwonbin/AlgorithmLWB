    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {



        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());

            for(int i = 0;i <N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }


            int start = 0;
            int end = 0;

            int sum = 0;


            int answer = 0;

            while(start<=end){


                if(sum < M){
                    if(end >= N){
                        break;
                    }
                    sum+=arr[end++];
                }else if(sum > M){
                    sum-=arr[start++];
                }else{
                    answer++;
                    sum-=arr[start++];

                }
            }

            System.out.println(answer);




        }

    }