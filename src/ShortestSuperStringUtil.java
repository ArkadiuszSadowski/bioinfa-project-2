import java.util.ArrayList;
import java.util.List;

public class ShortestSuperStringUtil {
    class Overlap {
        public Integer max;
        public String longestOverlap;
        Overlap(Integer i, String s) {
            max = i;
            longestOverlap = s;
        }
    }

    public String createSuperString(List<String> substringList) {
        List<String> copyList = new ArrayList<>(substringList);
        int count = substringList.size();
        String [] stringsToRemove = new String[2];
        for (int i = count; i >0; i--) {
            int longestOverlap = 0;
            String longestOverlapString = "";
            for (String a : copyList) {
                for (String b : copyList) {
                    if (!a.equals(b)) {
                        Overlap overlap = findOverlap(a, b);
                        if (longestOverlap < overlap.max) {
                            longestOverlap = overlap.max;
                            longestOverlapString = overlap.longestOverlap;
                            stringsToRemove[0] = a;
                            stringsToRemove[1] = b;
                        }
                    }
                }
            }
            if (longestOverlap == 0 && copyList.size() > 1) {
                String first = copyList.get(0);
                String second = copyList.get(1);
                first += second;
                copyList.remove(0);
                copyList.remove(1);
                copyList.add(first);
            } else {
                copyList.add(longestOverlapString);
                copyList.remove(stringsToRemove[0]);
                copyList.remove(stringsToRemove[1]);
            }
        }
        return copyList.get(0);
    }

    private Overlap findOverlap(String a, String b) {
        String longestOverlap = ""; // najdłuższy ciąg z pary
        int max = 0;
        int length;
        if(a.length() < b.length()) {
            length = a.length();
        } else {
            length = b.length();
        }
        for (int i = 1; i <= length; i++) {
            if (a.substring(0,i).equals(b.substring(length-i))) {
                if (max < i) {
                    max = i;
                    longestOverlap = b + a.substring(i);
                }
            }
        }
        return new Overlap(max, longestOverlap);
    }
}