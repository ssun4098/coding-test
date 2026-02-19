import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        Map<String, String> nicknameMap = new HashMap<>();
        List<Node> nodes = new ArrayList<>();
        
        for(String record: records) {
            StringTokenizer st = new StringTokenizer(record, " ");
            String action = st.nextToken();
            String userId = st.nextToken();
            if(action.equals("Leave")) {
                 nodes.add(new Node(userId, action));
                 continue;
            }
            
            String nickname = st.nextToken();
            nicknameMap.put(userId, nickname);
            if(action.equals("Enter")) {
                nodes.add(new Node(userId, action));
            }
        }
        List<String> answer = new ArrayList<>();
        
        for(Node node: nodes) {
            if(node.getAction().equals("Enter")) {
                answer.add(nicknameMap.get(node.getUserId()) + "님이 들어왔습니다.");
            } else {
                answer.add(nicknameMap.get(node.getUserId()) + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[0]);
    }
}

class Node {
    private String userId;
    private String action;
    
    public Node(String userId, String action) {
        this.userId = userId;
        this.action = action;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public String getAction() {
        return action;
    }
}