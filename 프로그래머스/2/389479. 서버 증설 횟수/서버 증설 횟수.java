import java.util.*;

// 11:06
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        List<Server> servers = new ArrayList<>();
        for(int i = 0; i < players.length; i++) {
            for (int idx = servers.size() - 1; idx >= 0; idx--) {
                if (servers.get(idx).isEnd(i)) {
                    servers.remove(idx);
                }
            }
            
            
            int player = players[i];
            int needServerCount = player / m;
            int nowServerCount = servers.size();
            // 부족할 경우
            if(nowServerCount < needServerCount) {
                for(int j = 0; j < needServerCount - nowServerCount; j++) {
                    servers.add(new Server(i, k));
                }
                //System.out.println(i + " " + (needServerCount - nowServerCount));
                answer += needServerCount - nowServerCount;
            }
            System.out.println(i + " 남는 서버의 수: " + servers.size());
        }
        
        
        return answer;
    }
}

class Server {
    private int start;
    private int end;
    
    public Server(int start, int k) {
        this.start = start;
        this.end = start + k;
    }
    
    public boolean isEnd(int i) {
        return i >= end;
    }
}