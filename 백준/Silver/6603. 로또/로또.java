    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static StringBuilder sb;
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            sb = new StringBuilder();

            while(true){
                String[] lotto = br.readLine().split(" ");
                if(lotto[0].equals("0")){
                    break;
                }

                List<Integer> list = new ArrayList<>();
                for(int i=1; i<lotto.length; i++){
                    list.add(Integer.parseInt(lotto[i]));
                }

                Collections.sort(list);

                int[] arr = new int[6];
                boolean[] visited = new boolean[list.size()];

                dfs(0,0,list, arr, visited);
                sb.append("\n");

            }

            System.out.println(sb);





        }

        static void dfs(int depth, int start, List<Integer> list, int[] arr, boolean[] visited){
            if(depth == 6){
                for(int i=0; i<6; i++){
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
                return;
            }

            for(int i=start; i<list.size(); i++){
                int cur = list.get(i);
                if(visited[i]) continue;

                visited[i] = true;
                arr[depth] = cur;
                dfs(depth+1, i+1, list,arr,visited);
                visited[i] = false;

            }




        }


    }