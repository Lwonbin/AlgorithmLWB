import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[a];
        int frontcheck = 0;
        int backcheck = 0;
        for(int i=0; i<a; i++){
            String command = br.readLine();
            if(command.length()>=6){
                int pushNum = Integer.parseInt(command.split(" ")[1]);
                arr[backcheck++] = pushNum;
            }else if(command.equals("front")){
                if(frontcheck == backcheck){
                    bw.write(-1+"\n");
                }else{
                    bw.write(arr[frontcheck]+"\n");
                }
            }else if(command.equals("pop")){
                if(frontcheck==backcheck){
                    bw.write(-1+"\n");
                }else{
                    bw.write(arr[frontcheck++]+"\n");
                }
            }else if(command.equals("size")){
                bw.write(backcheck-frontcheck+"\n");
            }else if(command.equals("empty")){
                if(frontcheck == backcheck){
                    bw.write(1+"\n");
                }else{
                    bw.write(0+"\n");
                }
            } else if (command.equals("back")) {
                if (frontcheck == backcheck) {
                    bw.write("-1\n");
                } else {
                    bw.write(arr[backcheck - 1] + "\n");
                }
            }

        }
        br.close();
        bw.flush();
        bw.close();
    }
}