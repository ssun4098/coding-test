import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            Wheel[] wheels = new Wheel[4];

            for(int i = 0; i < 4; i++) {
                String[] values = br.readLine().split("");
                Deque<String> deque = new ArrayDeque<>();
                String left = "";
                String right = "";
                for(int j = 0; j < 8; j++) {
                    String value = values[j];
                    if(j == 2) {
                        right = value;
                    }
                    if(j == 6) {
                        left = value;
                    }
                    deque.add(value);
                }
                wheels[i] = new Wheel(deque, left, right);
            }
            int n = Integer.parseInt(br.readLine());

            for(int i = 0; i < n; i++) {
                StringTokenizer command = new StringTokenizer(br.readLine(), " ");
                int number = Integer.parseInt(command.nextToken()) - 1;
                int direction = Integer.parseInt(command.nextToken());
                int leftDirection = -direction;
                int rightDriect = -direction;
                int[] rotations = new int[4];

                rotations[number] = direction;
                // 좌측 비교
                for(int j = number; j > 0; j--) {
                    String left = wheels[j].getLeft();
                    String right = wheels[j-1].getRight();

                    if(left.equals(right)) {
                        break;
                    }
                    rotations[j-1] = leftDirection;
                    leftDirection = -leftDirection;
                }

                // 우측 비교
                for(int j = number; j < 3; j++) {
                    String right = wheels[j].getRight();
                    String left = wheels[j+1].getLeft();

                    if(left.equals(right)) {
                        break;
                    }
                    rotations[j+1] = rightDriect;
                    rightDriect = -rightDriect;
                }

                for(int j = 0; j < 4; j++) {
                    if(rotations[j] == -1) {
                        wheels[j].reverseRotation();
                    }
                    if(rotations[j] == 1) {
                        wheels[j].forwardRotation();
                    }
                }
            }

            int point = 0;

            if(wheels[0].getDeque().poll().equals("1")) {
                point += 1;
            }

            if(wheels[1].getDeque().poll().equals("1")) {
                point += 2;
            }

            if(wheels[2].getDeque().poll().equals("1")) {
                point += 4;
            }

            if(wheels[3].getDeque().poll().equals("1")) {
                point += 8;
            }


            bw.write(String.valueOf(point));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Wheel {
        private Deque<String> deque;
        private String left; // 좌측 접점 정보(S/N)
        private String right; // 좌측 접점 정보(S/N)

        public Wheel(Deque<String> deque, String left, String right) {
            this.deque = deque;
            this.left = left;
            this.right = right;
        }

        public Deque<String> getDeque() {
            return deque;
        }

        public String getLeft() {
            return left;
        }

        public String getRight() {
            return right;
        }

        public void forwardRotation() {
            deque.addFirst(deque.pollLast());
            setLR();
        }

        public void reverseRotation() {
            deque.addLast(deque.pollFirst());
            setLR();
        }

        public void setLR() {
            List<String> list = new ArrayList<>(deque);
            left = list.get(6);
            right = list.get(2);
        }
    }
}