import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){

            String def = br.readLine();

            int arrN = Integer.parseInt(br.readLine());
            Deque<String> deque = new ArrayDeque<>();
            String arr = br.readLine();
            String subArr = arr.substring(1,arr.length()-1);
            String[] ARR = subArr.split(",");


            for(int j=0; j<ARR.length; j++){
                if(!ARR[j].equals("R") && !ARR[j].equals("D") && !ARR[j].isEmpty()){
                    deque.addLast(ARR[j]);
                }
            }

            int curDist = 1;
            boolean check = true;

            for(int j=0; j<def.length(); j++){
                if(def.charAt(j)=='R'){
                    curDist = -curDist;
                }else if(def.charAt(j)=='D'){
                    if(deque.isEmpty()){
                        bw.write("error"+"\n");
                        check = false;
                        break;
                    }

                    if(curDist == 1){
                        deque.pollFirst();
                    }else{
                        deque.pollLast();
                    }
                }
            }
            if(check){
                if(curDist==1){
                    bw.write("[");
                    while(!deque.isEmpty()){
                        if(deque.size()==1){
                            bw.write(deque.pollFirst());
                            break;
                        }
                        bw.write(deque.pollFirst() +",");
                    }
                    bw.write("]");
                }else{
                    bw.write("[");
                    while(!deque.isEmpty()){
                        if(deque.size()==1){
                            bw.write(deque.pollLast());
                            break;
                        }
                        bw.write(deque.pollLast() +",");
                    }
                    bw.write("]");
                }

                bw.write("\n");
            }

        }


        br.close();
        bw.flush();
        bw.close();
    }
}
