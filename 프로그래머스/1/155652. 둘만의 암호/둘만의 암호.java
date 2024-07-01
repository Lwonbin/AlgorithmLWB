import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();
        
        // Skip 문자열을 Set에 추가하여 검색을 빠르게 만듦
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int count = 0;
            int p = 0;

            // index만큼 이동
            while (count < index) {
                ch++;
                if (ch > 'z') {
                    ch -= 26;
                }
                // skipSet에 포함되지 않는 문자만 count 증가
                if (!skipSet.contains(ch)) {
                    count++;
                }
            }
            sb.append(ch);
        }
        answer = sb.toString();
        return answer;
    }
}