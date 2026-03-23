import java.util.*;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Solution {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm");

    public String solution(String m, String[] musicinfos) {

        int maxPlayTime = -1;
        String answer = "(None)";

        m = normalize(m);

        for(String info : musicinfos) {

            String[] arr = info.split(",");

            String startTime = arr[0];
            String endTime = arr[1];
            String name = arr[2];
            String music = arr[3];

            int playTime = (int) Duration.between(
                    LocalTime.parse(startTime, FORMATTER),
                    LocalTime.parse(endTime, FORMATTER)
            ).toMinutes();

            String playedMusic = buildMelody(music, playTime);
            playedMusic = normalize(playedMusic);

            if(!playedMusic.contains(m)) {
                continue;
            }

            if(playTime > maxPlayTime) {
                maxPlayTime = playTime;
                answer = name;
            }
        }

        return answer;
    }

    // 재생시간만큼 멜로디 생성 (# 포함 음 단위 처리)
    private String buildMelody(String music, int playTime) {

        List<String> notes = new ArrayList<>();

        for(int i = 0; i < music.length(); i++) {

            if(i + 1 < music.length() && music.charAt(i+1) == '#') {
                notes.add(music.substring(i, i+2));
                i++;
            } 
            else {
                notes.add(String.valueOf(music.charAt(i)));
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < playTime; i++) {
            sb.append(notes.get(i % notes.size()));
        }

        return sb.toString();
    }

    // # 음 치환
    private String normalize(String s) {

        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }
}