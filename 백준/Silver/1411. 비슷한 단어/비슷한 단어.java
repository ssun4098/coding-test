import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = i+1; j < list.size(); j++) {
                String word1 = list.get(i);
                String word2 = list.get(j);
                Map<Character, Character> map1 = new HashMap<>();
                Map<Character, Character> map2 = new HashMap<>();
                boolean flag = true;
                for(int k = 0; k < word1.length(); k++) {
                    char word1Cursor = word1.charAt(k);
                    char word2Cursor = word2.charAt(k);
                    if(map1.containsKey(word1Cursor) && map1.get(word1Cursor) != word2Cursor) {
                        flag = false;
                        break;
                    }
                    if(map2.containsKey(word2Cursor) && map2.get(word2Cursor) != word1Cursor) {
                        flag = false;
                        break;
                    }
                    if(!map1.containsKey(word1Cursor) || !map2.containsKey(word2Cursor)) {
                        map1.put(word1Cursor, word2Cursor);
                        map2.put(word2Cursor, word1Cursor);
                    }
                }
                if(flag) {
                    answer++;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}