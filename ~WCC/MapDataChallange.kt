fun main() {

    val rawData = mapOf(
        "users1.csv" to listOf(32, 45, 17, -1, 34),
        "users2.csv" to listOf(19, -1, 67, 22),
        "users3.csv" to listOf(15, -124, 0, 12),
        "users4.csv" to listOf(56, 32, 18, 44)
    )

    // Question 1
    fun averageAges(map: Map<String, List<Int>>) {

        var listOfAges: MutableList<Int> = mutableListOf()

        for (ageRawList in map.values) {
            var filteredData = ageRawList.filter {age -> age > 0}
            listOfAges.addAll(filteredData)
        }

        val averageAge = listOfAges.average()
        return println("The average age is $averageAge\n")
    }

    averageAges(rawData)

    // Functional programming solution
    fun average(map: Map<String, List<Int>>): Double {

        val average = map
                .flatMap { it.value }
                .filter { it > 0 }
                .average()

        return average
    }

    println(average(rawData))


    // Question 2
    fun entriesWithFaultyValues(map: Map<String, List<Int>>) {
        map.forEach { (k, v) ->
            for (i in v) {
                if (i < 0) {
                    println(k)
                }
            }
        }
    }

    entriesWithFaultyValues(rawData)


    // Functional programming solution

    // Question 3
    fun quantityOfFaultyValues(map: Map<String, List<Int>>) {
        var quantity: Int = 0

        for (arrayOfValues in map.values) {
            for (element in arrayOfValues) {
                if (element <= 0) {
                    quantity++
                }
            }
        }

        return println(quantity)
    }

    quantityOfFaultyValues(rawData)
}