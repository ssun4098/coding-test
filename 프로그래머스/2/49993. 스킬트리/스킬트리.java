class Solution {
    public int solution(String skill, String[] skill_trees) {
        if(skill.length() == 1) {
            return skill_trees.length;
        }
        
        int answer = 0;
        
        for(String skillTree: skill_trees) {
            boolean flag = true;
            int[] array = new int[30];
            
            for(int i = 0; i < skillTree.length(); i++) {
                char s = skillTree.charAt(i);
                array[s - 'A'] = i;
            }
            
            for(int i = 1; i < skill.length(); i++) {
                int now = skillTree.indexOf(skill.charAt(i));
                if(now == -1) {
                    continue;
                }
                int before = skillTree.indexOf(skill.charAt(i-1));
                if(before == -1 || now < before) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                answer++;
            }
        }
        
        
        return answer;
    }
}