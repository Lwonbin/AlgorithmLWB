    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static class Point {
            int start;
            int end;

            Point(int start, int end){
                this.start = start;
                this.end = end;
            }
        }

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int N = Integer.parseInt(br.readLine());

            List<Point> list = new ArrayList<>();



            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new Point(x,y));
            }


            Collections.sort(list, (o1,o2) -> {
                if(o1 == o2){
                    return o1.end-o2.end;
                }
                return o1.start - o2.start;
            });


            int maxEnd = -1000000000;

            int sum = 0;
            for(Point cur : list){
                int start = cur.start;
                int end = cur.end;

                if(maxEnd < end ){
                    if(maxEnd <= start){
                        sum += end-start;
                    }else{
                        sum +=  end-start - (maxEnd-start);
                    }
                    maxEnd = end;
                }
            }







            System.out.println(sum);






        }

    }