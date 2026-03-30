    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static class player{
            int level;
            String name;

            player(int level, String name){
                this.level = level;
                this.name = name;
            }
        }

        static class room{
            int level;
            List<player> players = new ArrayList<>();

            room(int level){
                this.level = level;
            }
        }
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            StringTokenizer st= new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<room> lists = new ArrayList<>();


            for(int i=0 ;i<p; i++){
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                String n = st.nextToken();

                player ply = new player(l, n);
                boolean check = false;
                for(room cur : lists){
                    if(cur.players.size() < m && cur.level -10 <= l && l <= cur.level +10){
                        cur.players.add(ply);
                        check = true;
                        break;
                    }
                }

                if(!check){
                    room Room = new room(l);
                    lists.add(Room);
                    Room.players.add(ply);
                }
            }


            for(int i=0; i<lists.size(); i++){
                room curRoom = lists.get(i);
                Collections.sort(curRoom.players, (o1,o2) -> {
                    return o1.name.compareTo(o2.name);
                });
                if(curRoom.players.size() == m){
                    System.out.println("Started!");
                    for(player cur : curRoom.players){
                        System.out.println(cur.level+" "+cur.name);
                    }
                }else{
                    System.out.println("Waiting!");
                    for(player cur : curRoom.players){
                        System.out.println(cur.level+" "+cur.name);
                    }
                }
            }



        }

    }