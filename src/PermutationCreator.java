import java.util.ArrayList;
import java.util.List;

class PermutationCreator {
    static List<String> possibleNucleotyde = new ArrayList<>();
    private static final char[] set = {'A', 'G', 'C', 'T'};

    static void printAllKLength(int k) {
        int n = set.length;
        printAllKLengthRec(set, "", n, k);
    }

    static void printAllKLengthRec(char[] set,
                                   String prefix,
                                   int n, int k) {

        if (k == 0) {
            possibleNucleotyde.add(prefix);
            return;
        }

        for (int i = 0; i < n; ++i) {

            String newPrefix = prefix + set[i];

            printAllKLengthRec(set, newPrefix, n, k - 1);
        }
    }

}
