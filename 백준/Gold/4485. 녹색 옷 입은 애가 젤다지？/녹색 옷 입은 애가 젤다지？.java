import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            if (N == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            int result = bfs(map, visited, 0, 0, N);
            System.out.println("Problem "+count+": "+result);
            count ++;


        }


        br.close();
        bw.flush();
        bw.close();
    }


    static int bfs(int[][] map, boolean[][] visited, int x, int y, int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[x][y] = map[x][y];
        pq.add(new Node(x, y, map[x][y]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.x][cur.y] < cur.cost) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    int newCost = map[nx][ny] + cur.cost;
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.add(new Node(nx, ny, newCost));
                    }
                }
            }
        }

        return dist[N-1][N-1];
    }

}
