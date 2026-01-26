import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int[] array = new int[stringTokenizer.countTokens()];
            for(int i = 0 ; i < array.length; i++) {
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            boolean[][] visited = new boolean[array[0] + 1][array[1] + 1];
            Deque<Node> deque = new ArrayDeque<>();
            Set<String> answer = new HashSet<>();
            deque.add(new Node(0, 0));

            while(!deque.isEmpty()) {
                Node node = deque.poll();

                if(visited[node.getA()][node.getB()]) {
                    continue;
                }

                visited[node.getA()][node.getB()] = true;

                int c = array[2] - node.getB() - node.getA();
                if(node.getA() == 0) {
                    answer.add(String.valueOf(c));
                }


                // a -> b
                if(node.getA() > 0 && node.getB() < array[1]) {
                    int move = Math.min(node.getA(), array[1] - node.getB());
                    int nextA = node.getA() - move;
                    int nextB = node.getB() + move;
                    deque.add(new Node(nextA, nextB));
                }

                // a -> c
                if(node.getA() > 0 && c < array[2]) {
                    int move = Math.min(node.getA(), array[2] - c);
                    int nextA = node.getA() - move;;
                    deque.add(new Node(nextA, node.getB()));
                }

                // b -> a
                if(node.getB() > 0 && node.getA() < array[0]) {
                    int move = Math.min(node.getB(), array[0] - node.getA());
                    int nextA = node.getA() + move;
                    int nextB = node.getB() - move;
                    deque.add(new Node(nextA, nextB));
                }

                // b -> c
                if(node.getB() > 0 && c < array[2]) {
                    int move = Math.min(node.getB(), array[2] - c);
                    int nextB = node.getB() - move;
                    deque.add(new Node(node.getA(), nextB));
                }

                // c -> a
                if(c > 0 && node.getA() < array[0]) {
                    int move = Math.min(c, array[0] - node.getA());
                    int nextA = node.getA() + move;
                    deque.add(new Node(nextA, node.getB()));
                }

                // c -> b
                if(c > 0 && node.getB() < array[1]) {
                    int move = Math.min(c, array[1] - node.getB());
                    int nextB = node.getB() + move;
                    deque.add(new Node(node.getA(), nextB));
                }
            }

            bw.write(answer.stream()
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Node {
        private int a;
        private int b;

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
