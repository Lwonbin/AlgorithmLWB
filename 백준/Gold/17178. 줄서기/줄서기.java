import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        Stack<Integer> wating = new Stack<>();
        Queue<Integer> line = new LinkedList<>();
        List<Integer> correct = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                int cur = toKey(st.nextToken());
                line.add(cur);
                correct.add(cur);
            }
        }

        Collections.sort(correct);


        int idx = 0;
        while(!line.isEmpty()){
            if(!wating.isEmpty() && wating.peek().equals(correct.get(idx))){
                wating.pop();
                idx++;
            }else if(line.peek().equals(correct.get(idx))){
                line.poll();
                idx++;
            }else{
                wating.add(line.poll());
            }
        }

        boolean check =true;

        while(!wating.isEmpty()){
            if(wating.peek().equals(correct.get(idx))){
                wating.pop();
                idx++;
            }else{
                check = false;
                break;
            }
        }

        if(check){
            System.out.println("GOOD");
        }else{
            System.out.println("BAD");
        }






    }

    static int toKey(String s){
        char c = s.charAt(0);
        int num = Integer.parseInt(s.substring(2));

        return (c - 'A')*1000 + num;

    }


}