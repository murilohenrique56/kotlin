fun main() {
    var items = listOf("murilo", "rwan", "maria")

    val mutableItems = mutableListOf("murilo", "rwan", "maria")

    val murilo = items.stream().filter {
        i -> i.startsWith("murilo")
    }.findFirst().get()


    items = items.plus(murilo)


    for (item in items) {
        println(item)
    }

    println("##########################################################")

    val rwan = mutableItems.stream().filter {
        i -> i.startsWith("rwan")
    }.map { rwan -> rwan.uppercase() }

    // mutableItems.add(rwan)
    mutableItems.forEach { i -> println(i) }

}