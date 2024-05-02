import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken().toUpperCase();

        HashMap<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int maxCount = 0;
        char mostFrequentChar = ' ';
        boolean isDuplicate = false;

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            char key = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount) {
                maxCount = count;
                mostFrequentChar = key;
                isDuplicate = false; // 새로운 최빈값을 발견했으므로 중복 여부를 다시 초기화
            } else if (count == maxCount) {
                isDuplicate = true; // 최빈값과 동일한 빈도의 문자를 발견했음을 표시
            }
        }

        if (isDuplicate) {
            System.out.println("?");
        } else {
            System.out.println(mostFrequentChar);
        }

        br.close();
    }
}
