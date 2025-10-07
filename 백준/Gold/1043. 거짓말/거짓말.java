import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int truthCount = Integer.parseInt(st.nextToken());
        boolean[] truth = new boolean[N + 1]; // 진실 여부 저장

        if (truthCount > 0) {
            for (int i = 0; i < truthCount; i++) {
                int t = Integer.parseInt(st.nextToken());
                truth[t] = true;
            }
        }



        List<Integer>[] parties = new ArrayList[M+1];
        List<Integer>[] person = new ArrayList[N+1];

        for(int i=1; i<M+1; i++){
            parties[i] = new ArrayList<>();
        }
        for(int i=1; i<N+1; i++){
            person[i] = new ArrayList<>();
        }

        for(int i=1; i<M+1; i++){
            st = new StringTokenizer(br.readLine());
            int partyCount = Integer.parseInt(st.nextToken());
            for(int j=0; j<partyCount; j++){
                int partyPerson = Integer.parseInt(st.nextToken());
                person[partyPerson].add(i);
                parties[i].add(partyPerson);
            }
        }


        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<N+1; i++){
            if(truth[i]){
                queue.add(i);
            }
        }


        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int personIdx : person[cur]){
                for(int nextPerson : parties[personIdx]){
                    if(!truth[nextPerson]){
                        queue.add(nextPerson);
                        truth[nextPerson] = true;
                    }
                }
            }
        }

        int result = 0;

        for( int i=1; i<M+1; i++){
            boolean canLie = true;
            for(int p : parties[i]){
                if(truth[p]){
                    canLie = false;
                    break;
                }
            }
            if(canLie){
                result++;
            }
        }


        System.out.println(result);







        br.close();

    }
}
