import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(0, 0));
        visited[0][0] = true;
        boolean stop = false;
        while(!deque.isEmpty()) {
            int size = deque.size();
            answer++;
            
            for(int i = 0; i < size; i++) {
                Node now = deque.pollFirst();
                
                if(now.getY() + 1 == maps.length && now.getX() + 1 == maps[0].length) {
                    stop = true;
                    break;
                }
                
                // 상
                if(now.getY() > 0 && maps[now.getY() - 1][now.getX()] == 1 && !visited[now.getY() - 1][now.getX()]) {
                    visited[now.getY() - 1][now.getX()] = true;
                    deque.add(new Node(now.getX(), now.getY() - 1));
                }
                
                // 하
                if(now.getY() < maps.length - 1 && maps[now.getY() + 1][now.getX()] == 1 && !visited[now.getY() + 1][now.getX()]) {
                    visited[now.getY() + 1][now.getX()] = true;
                    deque.add(new Node(now.getX(), now.getY() + 1));
                }
                
                // 좌
                if(now.getX() > 0 && maps[now.getY()][now.getX() - 1] == 1 && !visited[now.getY()][now.getX() - 1]) {
                    visited[now.getY()][now.getX() - 1] = true;
                    deque.add(new Node(now.getX() - 1, now.getY()));
                }
                
                // 우
                if(now.getX() < maps[0].length - 1 && maps[now.getY()][now.getX() + 1] == 1 && !visited[now.getY()][now.getX() + 1]) {
                    visited[now.getY()][now.getX() + 1] = true;
                    deque.add(new Node(now.getX() + 1, now.getY()));
                }
            }
            
            if(stop) {
                break;
            }
        }
        
        if(stop) {
            return answer;
        }
        
        return  -1;
    }
}

class Node {
    private int x;
    private int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}