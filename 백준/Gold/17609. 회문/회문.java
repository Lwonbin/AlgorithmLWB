import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            // 회문인지 확인
            if (isPalindrome(str, 0, str.length() - 1)) {
                bw.write(0 + "\n");
            } 
            // 유사회문인지 확인
            else if (isPseudoPalindrome(str)) {
                bw.write(1 + "\n");
            } 
            // 둘 다 아니면
            else {
                bw.write(2 + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    // 회문 여부 확인
    public static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 유사회문 여부 확인
    public static boolean isPseudoPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                // 한 문자를 제외한 두 경우 중 하나라도 회문이면 유사회문
                return isPalindrome(str, left + 1, right) || isPalindrome(str, left, right - 1);
            }
            left++;
            right--;
        }
        return false;
    }
}
