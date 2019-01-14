import java.util.*

class DNASequenceHybridization {

    private val scanner: Scanner = Scanner(System.`in`)

    fun start() {
        System.out.println("Podaj długość k : ")
        val k: Int = scanner.nextInt()
        PermutationCreator.printAllKLength(k)
        val permutationsList = PermutationCreator.possibleNucleotyde

        System.out.println("Podaj liczbę słów o długości k :")
        val n: Int = scanner.nextInt()

        var errorCounter = 0
        val listOfSequences = mutableListOf<String>()

        for (i in 0..n) {
            val sequence= scanner.nextLine().trim()

            when {
                sequence.length != k -> errorCounter++
                permutationsList.contains(sequence).not() -> errorCounter++
                listOfSequences.contains(sequence) -> errorCounter++
                else -> listOfSequences.add(sequence)
            }

            if (errorCounter > 3) {
                System.out.println("Liczba błędów użytkownika większa niż 3. Uruchom program ponownie!")
                return
            }
        }

        val shortestSuperStringUtil = ShortestSuperStringUtil()
        val superString = shortestSuperStringUtil.createSuperString(listOfSequences)
        System.out.println("Spectrum to : $superString")

    }
}
