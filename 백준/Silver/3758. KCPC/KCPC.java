import java.io.*;
import java.util.*;

public class Main {
    static class Team{
        int id;
        int[] scoreList;
        int submitNum;
        int lastSubmit;
        int totalScore;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());


        for(int T=0; T<testcase; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제의 개수
            int t = Integer.parseInt(st.nextToken());// 당신 팀의 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리의 개수

            Team[] list = new Team[n];


            for (int i = 0; i < m; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int id2 = Integer.parseInt(st2.nextToken());//팀 ID
                int problemNum = Integer.parseInt(st2.nextToken());//문제 번호 j
                int score = Integer.parseInt(st2.nextToken());// 흭듹한 점수 s

                if (list[id2 - 1] == null) {
                    list[id2 - 1] = new Team();
                    list[id2 - 1].id = id2;
                    list[id2 - 1].scoreList = new int[k + 1];
                }

                list[id2 - 1].scoreList[problemNum] = Math.max(score, list[id2 - 1].scoreList[problemNum]);
                list[id2 - 1].submitNum++;
                list[id2 - 1].lastSubmit = i;
            }


            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += list[i].scoreList[j];
                }
                list[i].totalScore = sum;
            }


            Arrays.sort(list, new Comparator<Team>() {
                @Override
                public int compare(Team o1, Team o2) {
                    if (o1.totalScore == o2.totalScore) {
                        if (o1.submitNum == o2.submitNum) {
                            return o1.lastSubmit - o2.lastSubmit;
                        }
                        return o1.submitNum - o2.submitNum;
                    }
                    return o2.totalScore - o1.totalScore;
                }
            });

            for (int i = 0; i < n; i++) {
                if (list[i].id == t) {
                    bw.append(String.valueOf(i+1)+"\n");
                }
            }
        }








        br.close();
        bw.flush();
        bw.close();

    }
}
