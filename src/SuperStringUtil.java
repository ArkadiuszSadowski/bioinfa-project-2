import java.util.HashSet;
import java.util.Set;

final class SuperStringUtil {

    static String createSpectrum(Set<String> subStrings) {
        int totalStrings = subStrings.size();
        String[] match = new String[totalStrings];
        int i = 0;

        for (String superString : subStrings) {
            Set<String> temp = new HashSet<>(subStrings);
            String maxSpectrum = superString;
            while (temp.size() > 1) {

                String subString = "";
                String nextMaxSuperString = maxSpectrum;

                for (String nextString : temp) {

                    if (!nextString.equals(nextMaxSuperString)) {
                        String superTemp = getSpectrum(maxSpectrum, nextString);
                        if (nextMaxSuperString.equals(maxSpectrum) || nextMaxSuperString.length() > superTemp.length()) {
                            nextMaxSuperString = superTemp;
                            subString = nextString;
                        }
                    }
                }

                temp.remove(maxSpectrum);
                temp.remove(subString);
                maxSpectrum = nextMaxSuperString;
                temp.add(maxSpectrum);
            }

            match[i] = maxSpectrum;
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

    private static String getSpectrum(String spectrum, String someString) {
        String result = spectrum;

        int endIndex = someString.length() - 1;

        while (endIndex > 0 && !spectrum.endsWith(someString.substring(0, endIndex))) {
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
