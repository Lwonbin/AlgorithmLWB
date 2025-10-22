import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        char value;
        Node left;
        Node right;

        Node(char value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static Node[] tree;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        tree = new Node[N+1];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            char leftvalue = st.nextToken().charAt(0);
            char rightvalue = st.nextToken().charAt(0);

            if(tree[value - 'A'] == null){
                tree[value - 'A'] = new Node(value);
            }
            if(leftvalue != '.'){
                tree[leftvalue - 'A'] = new Node(leftvalue);
                tree[value - 'A'].left = tree[leftvalue - 'A'];
            }
            if(rightvalue != '.'){
                tree[rightvalue - 'A'] = new Node(rightvalue);
                tree[value - 'A'].right = tree[rightvalue - 'A'];
            }
        }


        preorder(tree[0]);
        System.out.println();

        inorder(tree[0]);
        System.out.println();

        postorder(tree[0]);

        br.close();
        bw.flush();
        bw.close();
    }


    static void preorder(Node node){
        if(node == null) return ;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    static void postorder(Node node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}
