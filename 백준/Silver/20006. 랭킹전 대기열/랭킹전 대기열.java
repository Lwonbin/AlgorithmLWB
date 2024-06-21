import java.io.*;
import java.util.*;

public class Main {
    public static class Room{
        int level;
        int count;
        ArrayList<Player> players = new ArrayList<Player>();

        Room (int level, Player player) {
            this.level = level;
            this.players.add(player);
            this.count = 1;
        }
    }

    // 플레이어 클래스
    public static class Player implements Comparable<Player> {
        int level;      // 플레이어 레벨
        String name;    // 플레이어 이름

        Player (int level, String name) {
            this.level = level;
            this.name = name;
        }

        // 이름 사전순으로 정렬
        @Override
        public int compareTo(Player p) {
            return (this.name).compareTo(p.name);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Room> dq = new ArrayDeque<>();

        for(int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            boolean check = false;

            for (Room room : dq) {
                if (Math.abs(level - room.level) <= 10 & room.count < m) {
                    room.players.add(new Player(level, name));
                    room.count += 1;
                    check = true;
                    break;
                }
            }

            if (!check) {
                dq.addLast(new Room(level, new Player(level, name)));
            }

        }

        for(Room room : dq){
            if(room.count ==m){
                System.out.println("Started!");
            }else{
                System.out.println("Waiting!");
            }

            Collections.sort(room.players);


            for(int i=0; i<room.players.size(); i++){
                System.out.printf("%d %s\n", room.players.get(i).level, room.players.get(i).name);
            }


        }
    }
}
