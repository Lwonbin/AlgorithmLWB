    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static class jewel{
            int weight;
            int value;

            jewel(int weight, int value){
                this.weight = weight;
                this.value = value;
            }
        }

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            List<jewel> jewels = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<Integer> bags = new ArrayList<>();


            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int M = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                jewels.add(new jewel(M, V));
            }

            for(int i = 0;i <K; i++){
                int C = Integer.parseInt(br.readLine());
                bags.add(C);
            }

            Collections.sort(bags);
            Collections.sort(jewels, (o1,o2) ->{
                return o1.weight - o2.weight;
            });

            long sum = 0;

            PriorityQueue<jewel> pq = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);

            int idx = 0;

            for(int i=0; i<K; i++){
                while(idx < N && jewels.get(idx).weight <= bags.get(i)){
                    pq.add(jewels.get(idx));
                    idx++;
                }

                if(!pq.isEmpty()){
                    jewel cur = pq.poll();
                    sum+= cur.value;
                }

            }

            System.out.println(sum);





        }

    }