class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        for(int i=0; i<photo.length; i++){
            int sum = 0;
            for(int j=0; j<photo[i].length; j++){
                for(int p=0; p<name.length; p++){
                        if(photo[i][j].equals(name[p])){
                            sum += yearning[p];
                            break;
                        }
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}