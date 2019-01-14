import java.util.*

class DNASequenceHybridization {

    private val scanner: Scanner = Scanner(System.`in`)

    fun start() {
        System.out.println("Podaj długość k : ")
        val k: Int = scanner.nextInt()
        PermutationCreator.printAllKLength(k)
        val permutationsList = PermutationCreator.possibleNucleotyde

        System.out.println("Podaj ilość substringów o długości k :")
        val n: Int = scanner.nextInt()

        var errorCounter = 0
        val listOfSequence = mutableListOf<String>()

        for (i in 0..n) {
            val sequence= scanner.nextLine().trim()

            when {
                sequence.length != k -> errorCounter++
                permutationsList.contains(sequence).not() -> errorCounter++
                listOfSequence.contains(sequence) -> errorCounter++
                else -> listOfSequence.add(sequence)
            }

            if (errorCounter > 3) {
                System.out.println("Error")
                return
            }
        }

        val superString = SuperStringUtil.createSuperString(listOfSequence.toSet())
        System.out.println("Najlepszy SuperString to : $superString")

    }
}
