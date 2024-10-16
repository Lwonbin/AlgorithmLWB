import java.io.*;
import java.util.*;
public class Main {
    static int count, num, connections;
    static boolean[] visited;
    static List[] computers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        connections = Integer.parseInt(br.readLine());

        visited = new boolean[num+1];
        computers = new List[num+1];
        count = 0;

        for(int i=1; i<num+1; i++){
            computers[i] = new ArrayList<Integer>();
        }

        StringTokenizer st;
        for(int i=0; i<connections; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers[a].add(b);
            computers[b].add(a);
        }

        dfs(1);

        System.out.println(count-1);
        br.close();

    }


    private static void dfs(int start){
        if(!visited[start]){
            visited[start] = true;
            count++;
            for(int i=0; i< computers[start].size(); i++){
                dfs((Integer) computers[start].get(i));
            }
        }
    }
}
