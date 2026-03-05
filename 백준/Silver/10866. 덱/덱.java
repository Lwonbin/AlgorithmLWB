    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int N = Integer.parseInt(br.readLine());

            Deque<String> dq = new ArrayDeque<>();

            for(int i=0; i<N; i++){
                String[] cur = br.readLine().split(" ");

                if(cur.length == 2){
                    if(cur[0].equals("push_back")){
                        dq.addLast(cur[1]);
                    }else if(cur[0].equals("push_front")){
                        dq.addFirst(cur[1]);
                    }
                }else{
                    if(cur[0].equals("pop_front")){
                        if(!dq.isEmpty()){
                            System.out.println(dq.pollFirst());
                        }else{
                            System.out.println(-1);
                        }
                    }else if(cur[0].equals("pop_back")){
                        if(!dq.isEmpty()){
                            System.out.println(dq.pollLast());
                        }else{
                            System.out.println(-1);
                        }
                    }else if(cur[0].equals("front")){
                        if(!dq.isEmpty()){
                            System.out.println(dq.peekFirst());
                        }else{
                            System.out.println(-1);
                        }
                    }else if(cur[0].equals("back")){
                        if(!dq.isEmpty()){
                            System.out.println(dq.peekLast());
                        }else{
                            System.out.println(-1);
                        }
                    }

                    else if(cur[0].equals("size")){
                        System.out.println(dq.size());
                    }else if(cur[0].equals("empty")){
                        if(dq.isEmpty()){
                            System.out.println(1);
                        }else{
                            System.out.println(0);
                        }
                    }
                }

            }



        }

    }