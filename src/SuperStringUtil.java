import java.util.HashSet;
import java.util.Set;

final class SuperStringUtil {

    static String createSuperString(Set<String> subStrings) {
        int totalStrings = subStrings.size();
        String[] match = new String[totalStrings];
        int i = 0;

        for (String superString : subStrings) {
            Set<String> temp = new HashSet<>(subStrings);
            String maxSuperString = superString;
            while (temp.size() > 1) {

                String subString = "";
                String nextMaxSuperString = maxSuperString;

                for (String nextString : temp) {

                    if (!nextString.equals(nextMaxSuperString)) {
                        String superTemp = getSuperString(maxSuperString, nextString);
                        if (nextMaxSuperString.equals(maxSuperString) || nextMaxSuperString.length() > superTemp.length()) {
                            nextMaxSuperString = superTemp;
                            subString = nextString;
                        }
                    }
                }

                temp.remove(maxSuperString);
                temp.remove(subString);
                maxSuperString = nextMaxSuperString;
                temp.add(maxSuperString);
            }

            match[i] = maxSuperString;
            System.out.println(match[i]);
            i++;
        }

        String bestAns = match[0];

        for (i = 1; i < match.length; i++) {
            if (bestAns.length() > match[i].length()) {
                bestAns = match[i];
            }
        }

        return bestAns;
    }

    private static String getSuperString(String superString, String someString) {
        String result = superString;

        int endIndex = someString.length() - 1;

        while (endIndex > 0 && !superString.endsWith(someString.substring(0, endIndex))) {
            endIndex--;
        }

        if (endIndex > 0) {
            result += someString.substring(endIndex);
        } else {
            result += someString;
        }

        return result;
    }
}
