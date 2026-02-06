import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<FileName> fileNames = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            fileNames.add(new FileName(i, file));
        }
        Collections.sort(fileNames, new FileNameComparator());
        String[] answer = new String[files.length];
        for(int i = 0; i < files.length; i++) {
            FileName fileName = fileNames.get(i);
            answer[i] = fileName.getHead();
            if(!Objects.isNull(fileName.getNumber())) {
                answer[i] += fileName.getNumber();
            }
            if(!Objects.isNull(fileName.getTail())) {
                answer[i] += fileName.getTail();
            }
        }
        return answer;
    }
}

class FileNameComparator implements Comparator<FileName> {

    @Override
    public int compare(FileName o1, FileName o2) {
        // 파일명을 대소문자 구분없이 비교
        if(!o1.getHead().equalsIgnoreCase(o2.getHead())) {
            return o1.getHead().compareToIgnoreCase(o2.getHead());
        }
        // NUMBER 숫자 정렬
        int number1 = Integer.parseInt(o1.getNumber());
        int number2 = Integer.parseInt(o2.getNumber());
        if(number1 > number2) {
            return 1;
        } else if(number1 < number2) {
            return -1;
        }
        return 0;
    }
}

class FileName {
    private int index;
    private String head;
    private String number;
    private String tail;

    public FileName(int index, String file) {
        String[] part = file.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)"); // head와 number를 분리
        this.head = part[0];

        if(part.length > 1) {
            this.number = part[1];
        }
        if (part.length > 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i < part.length; i++) {
                sb.append(part[i]);
            }
            this.tail = sb.toString();
        }
        this.index = index;
    }

    public String getHead() {
        return head;
    }

    public String getNumber() {
        return number;
    }

    public String getTail() {
        return tail;
    }

    public int getIndex() {
        return index;
    }
}