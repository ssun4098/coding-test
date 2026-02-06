import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            List<User> users = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
                users.add(new User(i, Integer.parseInt(stringTokenizer.nextToken()), stringTokenizer.nextToken()));
            }
            Collections.sort(users, new MainComparator());
            for(User user: users) {
                bw.write(user.getAge() + " " + user.getName());
                bw.newLine();
            }
        }
    }
}

class MainComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if (o1.getAge() != o2.getAge()) {
            return o1.getAge() - o2.getAge();
        }
        return o1.getIndex() - o2.getIndex();
    }
}

class User {
    private int index;
    private int age;
    private String name;

    public User(int index, int age, String name) {
        this.index = index;
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}