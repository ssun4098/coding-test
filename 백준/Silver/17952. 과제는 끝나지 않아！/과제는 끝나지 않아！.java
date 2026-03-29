import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());
            int answer = 0;

            Stack<int[]> stack = new Stack<>();

            for(int i = 0; i < n; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                int flag = Integer.parseInt(st.nextToken());

                if(flag == 1) {
                    int score = Integer.parseInt(st.nextToken());
                    int time = Integer.parseInt(st.nextToken());

                    stack.push(new int[]{score, time});
                }

                if(!stack.isEmpty()) {
                    stack.peek()[1]--;

                    if(stack.peek()[1] == 0) {
                        answer += stack.pop()[0];
                    }
                }
            }

            System.out.println(answer);
        }
    }
}