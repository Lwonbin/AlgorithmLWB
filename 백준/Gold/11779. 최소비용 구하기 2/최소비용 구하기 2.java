    import java.io.*;
    import java.util.*;

    public class Main {

        static class Bus{
            int to;
            int cost;

            Bus(int to, int cost){
                this.to = to;
                this.cost = cost;
            }
        }

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

           int n = Integer.parseInt(br.readLine());
           int m = Integer.parseInt(br.readLine());

           List<Bus>[] list = new List[n+1];

           for(int i=0; i<n+1; i++){
               list[i] = new ArrayList<>();
           }

           for(int i=0; i<m; i++){
               StringTokenizer st = new StringTokenizer(br.readLine());
               int start = Integer.parseInt(st.nextToken());
               int to = Integer.parseInt(st.nextToken());
               int cost = Integer.parseInt(st.nextToken());

               list[start].add(new Bus(to, cost));
           }


           StringTokenizer st2 = new StringTokenizer(br.readLine());

           int startCity = Integer.parseInt(st2.nextToken());
           int targetCity = Integer.parseInt(st2.nextToken());

           PriorityQueue<Bus> pq = new PriorityQueue<Bus>((o1,o2) -> o1.cost - o2.cost);

           pq.add(new Bus(startCity, 0));

           int[] dist = new int[n+1];
           int[] prev = new int[n+1];

           Arrays.fill(dist, Integer.MAX_VALUE);
           Arrays.fill(prev, -1);

           dist[startCity] = 0;



           while(!pq.isEmpty()){
               Bus cur = pq.poll();
               int curCity = cur.to;
               int curCost = cur.cost;

               if(curCost != dist[curCity]) continue;

               if(curCity == targetCity){
                   break;
               }

               for(Bus nxt : list[curCity]){
                    int nxtCity = nxt.to;
                    int nxtCost = curCost + nxt.cost;

                    if(nxtCost < dist[nxtCity]){
                        dist[nxtCity] = nxtCost;
                        prev[nxtCity] = curCity;
                        pq.add(new Bus(nxtCity, nxtCost));
                    }
               }
           }



           List<Integer> path = new ArrayList<>();
           int cur = targetCity;
           while(true){
               path.add(cur);
               if(cur == startCity){
                   break;
               }
               cur = prev[cur];
           }

           Collections.reverse(path);


           StringBuilder sb = new StringBuilder();

           sb.append(dist[targetCity]).append("\n");
           sb.append(path.size()).append("\n");
           for(int pt : path){
               sb.append(pt).append(" ");
           }

            System.out.println(sb.toString());



        }
    }