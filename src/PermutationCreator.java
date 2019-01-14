import java.util.ArrayList;
import java.util.List;

class PermutationCreator {
    static List<String> possibleNucleotyde = new ArrayList<>();
    private static final char[] set = {'A', 'C', 'G', 'T'};

    static void printAllKLength(int k) {
        int n = set.length;
        printAllKLengthRec(set, "", n, k);
    }

    static void printAllKLengthRec(char[] set, String permutation, int n, int k) {
        if (k == 0) {
            possibleNucleotyde.add(permutation);
            return;
        }
        for (int i = 0; i < n; i++) {
            String newPermutation = permutation + set[i];
            printAllKLengthRec(set, newPermutation, n, k - 1);
        }
    }

}
