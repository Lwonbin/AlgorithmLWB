import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Person> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int index = i;
            Person person1 = new Person(age, name, index);
            list.add(person1);
        }

        list.sort((o1,o2) -> {
           int cmp = o1.age - o2.age;
           if(cmp==0){
               return o1.index - o2.index;
           }
           return cmp;
        });


        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).age +" " +list.get(i).name);
        }


        br.close();


    }


    static class Person{
        int age;
        String name;

        int index;

        Person(int age, String name, int index){
            this.age = age;
            this.name = name;
            this.index = index;
        }

    }
}
