    import java.io.*;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());

            for(int i=0; i<N; i++){
                StringBuilder sb = new StringBuilder();
                String p = br.readLine();
                int n = Integer.parseInt(br.readLine());

                String cur = br.readLine();
                String newCur = cur.substring(1, cur.length()-1);


                String[] arr = newCur.split(",");

                Deque<Integer> queue = new ArrayDeque<>();

                boolean check0 = true;
                if(n == 0){
                    for(int j=0; j<p.length(); j++){
                        if(p.charAt(j)=='D'){
                            check0 = false;
                        }
                    }
                    if(!check0){
                        System.out.println("error");
                        continue;
                    }else{
                        System.out.println("[]");
                        continue;
                    }
                }



                for(int j=0; j<arr.length; j++){
//                    System.out.print(arr[j]);
                    queue.add(Integer.parseInt(arr[j]));
                }

                int desc = 1;
                boolean check = true;

                for(int j = 0; j<p.length(); j++){

                    char curP = p.charAt(j);
                    if(curP == 'R'){
                        desc *= -1;
                    }else{
                        if(queue.isEmpty()){
                            check = false;
                            break;
                        }
                        else if(desc == 1){
                            queue.pollFirst();
                        }else if(desc == -1){
                            queue.pollLast();
                        }
                    }
                }


                if(desc == 1){
                    sb.append("[");
                    int size = queue.size();
                    for(int j=0; j<size; j++){
                        if(j == size-1){
                            sb.append(queue.pollFirst());
                        }else{
                            sb.append(queue.pollFirst()).append(",");
                        }
                    }
                    sb.append("]");
                }else if(desc == -1){
                    sb.append("[");
                    int size = queue.size();
                    for(int j=0; j<size; j++){
                        if(j == size-1){
                            sb.append(queue.pollLast());
                        }else{
                            sb.append(queue.pollLast()).append(",");
                        }
                    }
                    sb.append("]");
                }
                if(check){
                    System.out.println(sb.toString());
                }else{
                    System.out.println("error");
                }

            }




        }
    }