class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int min_length = 1000000;
        int left = 0, sum = 0;
        
        // right 포인터를 0부터 끝까지 순회
        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            
            // 합이 k를 넘는다면, left 포인터를 증가시키며 합을 줄임
            while (sum > k && left <= right) {
                sum -= sequence[left];
                left++;
            }
            
            // 합이 k와 같다면 최소 길이 갱신
            if (sum == k) {
                if (right - left < min_length) {
                    min_length = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        
        return answer;
    }
}
