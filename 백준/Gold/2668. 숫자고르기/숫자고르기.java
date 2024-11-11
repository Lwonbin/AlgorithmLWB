import java.io.*;
import java.util.*;
public class Main {
    static int[] num;
    static boolean[] visited;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));




        int N = Integer.parseInt(br.readLine());
        num = new int[N+1];

        for(int i=1; i<=N; i++){
            num[i]= Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();

        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            visited[i] = true;
            dfs(i,i);
            visited[i] = false;
        }

        Collections.sort(list);
        bw.write(list.size()+"\n");
        for(int i=0; i<list.size();i++){
            bw.write(list.get(i)+"\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }


    public static void dfs(int start, int target){
        if(visited[num[start]]==false){
            visited[num[start]] = true;
            dfs(num[start], target);
            visited[num[start]]=false;
        }

        if(num[start]==target) list.add(target);
    }
}
