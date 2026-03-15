import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        List<Node> nodes = new ArrayList<>();
        
        int totalPicks = picks[0] + picks[1] + picks[2];
        
        for(int i = 0; i < minerals.length && nodes.size() < totalPicks; i += 5) {
            int score = 0;
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            
            for(int j = i; j < i + 5 && j < minerals.length; j++) {
                if(minerals[j].equals("diamond")) {
                    score += 25;
                    diamond++;
                }
                else if(minerals[j].equals("iron")) {
                    score += 5;
                    iron++;
                }
                else {
                    score += 1;
                    stone++;
                }
            }
            
            nodes.add(new Node(score, diamond, iron, stone));
        }
        
        Collections.sort(nodes, (a, b) -> b.score - a.score);
        
        int pickIndex = 0;
        
        for(Node node : nodes) {
            
            while(pickIndex < 3 && picks[pickIndex] == 0) {
                pickIndex++;
            }
            
            if(pickIndex == 3)
                break;
            
            picks[pickIndex]--;
            
            if(pickIndex == 0) {
                answer += node.diamond;
                answer += node.iron;
                answer += node.stone;
            }
            else if(pickIndex == 1) {
                answer += node.diamond * 5;
                answer += node.iron;
                answer += node.stone;
            }
            else {
                answer += node.diamond * 25;
                answer += node.iron * 5;
                answer += node.stone;
            }
        }
        
        return answer;
    }
    
    static class Node {
        int score;
        int diamond;
        int iron;
        int stone;
        
        public Node(int score, int diamond, int iron, int stone) {
            this.score = score;
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }
}