import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        Map<Character, Node> chiledNode = new HashMap<Character, Node>();
    }


    static class Codingnojam_Trie{
        Node rootNode = new Node();

        void insert(String str){
            Node node= this.rootNode;

            for(int i=0; i<str.length(); i++){
                node = node.chiledNode.computeIfAbsent(str.charAt(i), k -> new Node());
            }
        }

        boolean search(String str){
            Node node= this.rootNode;

            for(int i=0; i<str.length(); i++){
                node = node.chiledNode.getOrDefault(str.charAt(i), null);
                if(node == null){
                    return false;
                }
            }
            return true;
        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Codingnojam_Trie tc = new Codingnojam_Trie();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0;

        for(int i=0; i<n; i++){
            String str = br.readLine();
            tc.insert(str);
        }

        for(int i=0; i<m; i++){
            String str = br.readLine();
            boolean search = tc.search(str);

            if(search){
                count++;
            }

        }

        bw.write(count+"");


        br.close();
        bw.flush();
        bw.close();

    }
}