class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[][] PARK = new int[park.length][park[0].length()];

        int startY = 0;
        int startX = 0;
        int parkY = park.length - 1;
        int parkX = park[0].length() - 1;
        
        // 초기 시작 위치를 찾는 부분
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    startY = i;
                    startX = j;
                }
                PARK[i][j] = park[i].charAt(j);
            }
        }

        // 각 명령어를 처리하는 부분
        for (int j = 0; j < routes.length; j++) {
            char op = routes[j].charAt(0);
            int n = Character.getNumericValue(routes[j].charAt(2));
            int currX = startX;
            int currY = startY;
            boolean bool = true;

            if (op == 'E') {
                for (int i = 0; i < n; i++) {
                    currX++;
                    if (currX > parkX || park[currY].charAt(currX) == 'X') {
                        bool = false;
                        break;
                    }
                }
                if (bool) {
                    startX = currX;
                }
            } else if (op == 'W') {
                for (int i = 0; i < n; i++) {
                    currX--;
                    if (currX < 0 || park[currY].charAt(currX) == 'X') {
                        bool = false;
                        break;
                    }
                }
                if (bool) {
                    startX = currX;
                }
            } else if (op == 'N') {
                for (int i = 0; i < n; i++) {
                    currY--;
                    if (currY < 0 || park[currY].charAt(currX) == 'X') {
                        bool = false;
                        break;
                    }
                }
                if (bool) {
                    startY = currY;
                }
            } else if (op == 'S') {
                for (int i = 0; i < n; i++) {
                    currY++;
                    if (currY > parkY || park[currY].charAt(currX) == 'X') {
                        bool = false;
                        break;
                    }
                }
                if (bool) {
                    startY = currY;
                }
            }
        }
        
        answer[0] = startY;
        answer[1] = startX;

        return answer;
    }
}
