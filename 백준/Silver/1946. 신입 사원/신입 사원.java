    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static class score{
            int interview;
            int paper;

            score(int paper, int interview){
                this.paper = paper;
                this.interview = interview;
            }
        }

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int T = Integer.parseInt(br.readLine());

            for(int i=0; i<T; i++){
                int N = Integer.parseInt(br.readLine());
                List<score> list = new ArrayList<>();
                for(int j=0; j<N; j++){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int curPaper = Integer.parseInt(st.nextToken());
                    int curInter = Integer.parseInt(st.nextToken());
                    list.add(new score(curPaper, curInter));
                }

                Collections.sort(list, (o1, o2) -> {
                    return o1.paper - o2.paper;
                });
//
//                1 4;
//                2 3;
//                3 5;
//                4 1;
//                5 2;
                int minInter = Integer.MAX_VALUE;
                int answer = 0;
                for(score cur : list){
                    int curInter = cur.interview;
                    if(minInter > curInter){
                        answer++;
                        minInter = curInter;
                    }
                }
                System.out.println(answer);

            }








        }

    }