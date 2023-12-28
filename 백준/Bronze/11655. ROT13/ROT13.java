import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = br.readLine().toCharArray();
        char[] ROT13 = new char[arr.length];
        for(int i=0; i<arr.length; i++){
            if(Character.isDigit(arr[i]) || Character.isWhitespace(arr[i])){
                ROT13[i] = arr[i];
            }

            else {
                int num = arr[i];
                if(Character.isUpperCase(arr[i]) && num+13 > 90){
                    ROT13[i] = (char) (num + 13 -26);
                }else if(Character.isLowerCase(arr[i]) && num+13 > 122){
                    ROT13[i] = (char) (num + 13 - 26);
                }else{
                    ROT13[i] = (char) (num + 13);
                }
            }
        }

        for(int j=0; j< ROT13.length; j++){
            bw.write(ROT13[j]);
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
