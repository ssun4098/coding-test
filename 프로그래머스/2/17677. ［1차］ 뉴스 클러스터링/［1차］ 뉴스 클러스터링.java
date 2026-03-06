import java.util.*;

class Solution {
    public static int VAL = 65536;
    
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> str1Group = new ArrayList<>();
        List<String> str2Group = new ArrayList<>();
        
        extractGroup(str1, str1Group);
        extractGroup(str2, str2Group);
        
        // 모두 공집합일 경우
        if(str1Group.isEmpty() && str2Group.isEmpty()) {
            return VAL;
        }
        
        Collections.sort(str1Group);
        Collections.sort(str2Group);

        int intersection = 0;

        for (String s : str1Group) {
            if (str2Group.remove(s)) { 
                intersection++;
            }
        }

        int union = str1Group.size() + str2Group.size();

        double f = (double) intersection / union;

        return (int) (f * VAL);
            }
    
    public void extractGroup(String str, List<String> strGroup) {
         for(int i = 0; i < str.length() - 1; i++) {
            String substring = str.substring(i, i+2).toUpperCase();
            char first = substring.charAt(0);
            char second = substring.charAt(1);
            
            if(Character.isLetter(first) && Character.isLetter(second)) {
                strGroup.add(substring);
            }
        }
    }
}

// FR, RA, AN, NC, CE, RE, EN, CH
