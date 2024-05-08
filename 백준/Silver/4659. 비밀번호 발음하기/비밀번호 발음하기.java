import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String password = br.readLine();
            if(password.equals("end")){
                break;
            }
            if (password.contains("a") || password.contains("e") || password.contains("i") || password.contains("o") || password.contains("u")) {
                if (password.length() == 1 || password.length() == 2) {
                    bw.write("<" + password + ">" + " is acceptable." + "\n");
                } else {
                    int count = 0;
                    for (int i = 0; i < password.length() - 2; i++) {
                        if (password.charAt(i) == 'a' || password.charAt(i) == 'e' || password.charAt(i) == 'i' || password.charAt(i) == 'o' || password.charAt(i) == 'u') {
                            if (password.charAt(i + 1) == 'a' || password.charAt(i + 1) == 'e' || password.charAt(i + 1) == 'i' || password.charAt(i + 1) == 'o' || password.charAt(i + 1) == 'u') {
                                if (password.charAt(i + 2) == 'a' || password.charAt(i + 2) == 'e' || password.charAt(i + 2) == 'i' || password.charAt(i + 2) == 'o' || password.charAt(i + 2) == 'u') {
                                    count++;
                                }
                            }
                        } else if (password.charAt(i) != 'a' && password.charAt(i) != 'e' && password.charAt(i) != 'i' && password.charAt(i) != 'o' && password.charAt(i) != 'u') {
                            if (password.charAt(i + 1) != 'a' && password.charAt(i + 1) != 'e' && password.charAt(i + 1) != 'i' && password.charAt(i + 1) != 'o' && password.charAt(i + 1) != 'u') {
                                if (password.charAt(i + 2) != 'a' && password.charAt(i + 2) != 'e' && password.charAt(i + 2) != 'i' && password.charAt(i + 2) != 'o' && password.charAt(i + 2) != 'u') {
                                    count++;
                                }
                            }
                        }
                    }
                    if (count > 0) {
                        bw.write("<" + password + ">" + " is not acceptable." + "\n");
                    } else {
                        int count2 = 0;
                        int count3=0;
                        for (int j = 0; j < password.length() - 1; j++) {
                            if (password.charAt(j) == password.charAt(j + 1)) {
                                if (password.charAt(j) == 'e' || password.charAt(j) == 'o') {
                                    count2++;
                                }else{
                                    count3++;
                                }
                            }
                        }
                        if (count3 > 0) {
                            bw.write("<" + password + ">" + " is not acceptable." + "\n");
                        } else if(count2>0){
                            bw.write("<" + password + ">" + " is acceptable." + "\n");
                        }else{
                            bw.write("<" + password + ">" + " is acceptable." + "\n");
                        }

                    }

                }

            }else{
                bw.write("<" + password + ">" + " is not acceptable." + "\n");
            }


        }







        br.close();
        bw.flush();
        bw.close();
    }
}
