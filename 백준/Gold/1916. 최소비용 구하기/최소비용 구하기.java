    import java.io.*;
    import java.util.*;

    public class Main {

        static class Bus{
            int to;
            int value;

            Bus(int to, int value){
                this.to = to;
                this.value = value;
            }
        }


        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            List<Bus>[] list = new List[N+1];

            for(int i=0; i<N+1; i++){
                list[i] = new ArrayList<>();
            }




            for(int i=0; i<M; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int startBus = Integer.parseInt(st.nextToken());
                int endBus = Integer.parseInt(st.nextToken());
                int busValue = Integer.parseInt(st.nextToken());
                list[startBus].add(new Bus(endBus, busValue));
            }

            StringTokenizer st = new StringTokenizer(br.readLine());

            int startCity = Integer.parseInt(st.nextToken());
            int targetCity = Integer.parseInt(st.nextToken());

            int[] dist = new int[N+1];
            Arrays.fill(dist, Integer.MAX_VALUE);


            PriorityQueue<Bus> pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);

            pq.add(new Bus(startCity, 0));
            dist[startCity] = 0;

            while(!pq.isEmpty()){
                Bus cur = pq.poll();
                int nxtCity = cur.to;
                int cityValue = cur.value;

                if(cityValue != dist[nxtCity]) continue;

                if(nxtCity == targetCity){
                    break;
                }

                for(Bus nxt : list[nxtCity]){
                    int nCost = nxt.value + cityValue;
                    if(nCost < dist[nxt.to]){
                        dist[nxt.to] = nCost;
                        pq.add(new Bus(nxt.to, nCost));
                    }
                }
            }

            System.out.println(dist[targetCity]);


        }
    }