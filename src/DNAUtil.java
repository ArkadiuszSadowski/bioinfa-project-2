import com.sun.istack.internal.NotNull;

import java.security.SecureRandom;
import java.util.Random;

class DNAUtil {

    static String createDNASequence(@NotNull int length) {
        String DNAArray = "ACTG";
        Random random = new SecureRandom();
        StringBuilder sequence = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sequence.append(DNAArray.charAt(random.nextInt(4)));
        }

        return sequence.toString();
    }


    static String[] createCodonsFrom(@NotNull String sequence) {
        int numberOfCodons = sequence.length() - 2;
        String[] codons = new String[numberOfCodons];

        for (int i = 0; i < numberOfCodons; i++) {
            codons[i] = sequence.substring(i, i + 3);
        }

        return codons;
    }

}
