import java.util.Scanner;

class DNASequenceHybridization {

    private Scanner system = new Scanner(System.in);

    void start() {
        System.out.println("Please type in how long DNA you want to be: ");
        int lenght = system.nextInt();
        String sequence = DNAUtil.createDNASequence(lenght);
        String[] codons = DNAUtil.createCodonsFrom(sequence);
        System.out.println("Generated sequence is : " + sequence);
        printCodons(codons);

    }

    private void printCodons(String[] codons) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < codons.length; i++) {
            output.append(codons[i]);
            if (i != codons.length - 1) {
                output.append(", ");
            }
        }

        System.out.println("Codons are : { " + output + " }");
    }
}
