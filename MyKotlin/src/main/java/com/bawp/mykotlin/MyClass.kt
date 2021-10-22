package com.bawp.mykotlin


fun main() {
    /**
     * var - mutable
     * val - immutable
     * Best practice - In essence, use val over var
     *
     * val name: String = "James" - explicitly initializing a variable
     *
     * Another way to initialize variables
     * val name: String
     * name = "James"
     * Basic Types in Kotlin:
     * (Whole Numbers)
     *  - Int
     *  - Byte
     *  - Short
     *  Floating Points Types:
     *   (Decimal Numbers):
     *    - Double
     *    - Float
     *    Note: for precision, use Double.
     *    val e = 2.7182818284
          val eFloat = 2.7182818284f
    val amount = 0
    when (amount) {
    in 1..100 -> print("This amount is between 1 and 100")
    !in 10..90 -> print("This amount is outside the range")
    999 -> print("Really Close")
    1000 -> print("Rich but not there...")
    1100 -> print("You've made it!")
    else -> {
    print("$amount is just not going to work")
    }
    }

    //    calculate(first = 12,
    //        second = 199,
    //        message = "Hey",
    //        multipleOf = 2)
    // calculate( message = "Hello there", multipleOf = 3)
    val catAge = calculateCatAge(age = 2)
    if (checkAge(catAge))
    print("This cat is old ($catAge)")
    else
    print("This cat is young ($catAge)")

     //Collections - Introduction
    val myListOfNames = listOf("James", "Paul", "Rafael", "Gina")
    val myMutableList = mutableListOf(12, 34, 45, 123)

    println("Number of elements ${myMutableList.size}")
    println("Second element ${myMutableList[1]}")
    println("Index of element \"45\" ${myMutableList.indexOf(45)}")


    for (item in myMutableList) {
    println(item)
    }

    myListOfNames.forEach {
    println(it)

    }
     */

}

//Generics
fun createGenerics() {
    val lisOfItems = listOf("Rafael", "Gina", "George", "James")

    val person = Person(name = "Joe", lastName = "Ball", age = 23)
    val aroni =  Person(name = "Ruti",
        lastName = "Machava",
        age = 54)
    val ruti = Person(name = "Ruti",
        lastName = "Machava",
        age = 54)
    val listOfPeople = listOf(person, aroni, ruti)
    val listOfNumbers = listOf(23, 45, 45)
    val finder = Finder(list = listOfPeople)
    finder.findItem(element = aroni ){
        println("Found $it")
    }
}
class Finder<T>(private val list: List<T>) {
    fun findItem(element: T, foundItem: (element: T?) -> Unit) {
         val itemFoundList = list.filter {
               it == element
         }
        if (itemFoundList.isNullOrEmpty()) foundItem(null) else
            foundItem(itemFoundList.first())

    }
}
fun createDataClass() {
    val person = Person(name = "Joe", lastName = "Ball", age = 23)
    val aroni =  Person(name = "Ruti",
        lastName = "Machava",
        age = 54)
    val ruti = Person(name = "Ruti",
        lastName = "Machava",
        age = 54)
    val listOfPeople = listOf(person, aroni, ruti)
    listOfPeople.forEach { item ->
        println(item.age)
    }
}
data class Person(val name: String, val lastName: String, val age: Int)

//Extension Functions
fun String.append(toAppend: String): String = this.plus(toAppend)
fun String.removeFirstAndLastChars(): String = this.substring(1, this.length - 1)

//-----
class Button(val label: String): ClickEvent {
    override fun onClick(message: String) {
        println("Clicked by $label and here's a message $message")
    }


}

class Character(val name: String): ClickEvent {
    override fun onClick(message: String) {
         println("Clicked by $name and here's a message $message")
    }

}

//Interfaces
interface ClickEvent {
    fun onClick(message: String)

}












fun createCar() {
    val car = Car(color = "Green", model = "LLm")
    car.color = "Black"
    println("Car color: ${car.color} model: ${car.model}" )
    car.speed(minSpeed = 100, maxSpeed = 199)
    car.drive()

    //Truck
    val truck = Truck(color = "Magenta", model = "F16")
    truck.drive()
    truck.speed(minSpeed = 20, maxSpeed = 90)
}


class Truck(color: String, model: String) : Car(color, model) {
     override fun speed(minSpeed: Int, maxSpeed: Int) {
         val fullSpeed = minSpeed * maxSpeed
         println("Truck full speed: $fullSpeed")

     }

    override fun drive() {
        println("Vroommm... Like a truck!!!")
    }

}


open class Car (var color: String ,
           val model: String) {

//    init {
//        if (color == "Green") {
//
//            println("Yayy Green")
//        }else {
//            println("$color is not Green")
//
//        }
//
//    }

   open fun speed(minSpeed: Int, maxSpeed: Int) {
        println("Min speed is $minSpeed and MaxSpeed: $maxSpeed")
   }
    open fun drive() {
        println("Drive...vroommmm")
    }
}















//https://medium.com/mobile-app-development-publication/kotlin-collection-functions-cheat-sheet-975371a96c4b
//Collections
fun kCollections() {
    val myMutableList = mutableListOf(12, 34, 45, 123)
    myMutableList.add(34)

    val empty = emptyList<String>()
    val emptySet = emptySet<Int>()
    val emptyMap = emptyMap<String, Int>()

    //Set
    val mySet = setOf("US", "MZ", "AU")
    val myMutableSet = mutableSetOf(1,3, 4, 5)
    myMutableSet.add(123)
    // println(myMutableSet)

    //Map
    val secretMap = mapOf("Up" to 1, "Down" to 2, "Left" to 3,
        "Right" to 4)
    val myMutableSecretMap = mutableMapOf("One" to 1,
        "Two" to 2,
        "Three" to 3)
    myMutableSecretMap["Four"] = 4
    //println(myMutableSecretMap)

    //if ("Up" in secretMap) println("Yes is in!")
    //if (4 in secretMap.values) println("Yes is in!")

    //Initializing Collections
    val myNewList = mutableListOf<String>()
    myNewList.add("hey")
    myNewList.add("There")
    for (i in 1..10) {
        myNewList.add(i,"Hey $i")
    }

    val myListOfNames = listOf("James", "Paul", "Rafael", "Gina")

    val found =  myListOfNames.filter {
        it.startsWith("r", ignoreCase = true) && it.endsWith('L',
            ignoreCase = true )

    }
    print(found)

}

val name: (String) -> Unit = {
    print("Hello, my name is $it")
}

fun showName(name: String) {
    print(name)
}
fun enhancedMessage(message: String, funAsParameter: (String) -> Int) {
    println("$message ${funAsParameter("Hey")}")
}
val catAge: (Int) -> Int = {
    it * 7}
fun calculateCatAge(age: Int): Int  = age * 7

//  val lambdaName : Type = { parameterList -> codeBody }
val add: (Int, Int) -> Int = { a, b ->  a + b  }

fun sum(a: Int, b: Int): Int {
    return a + b
}
fun checkAge(catAge: Int): Boolean {

    return catAge >= 14
}

















//val checkedAge: (Int) -> Boolean = { catAge: Int -> catAge >= 14 }
fun calculate(first: Int = 10,
              second: Int = 1000,
              message: String,
              multipleOf: Int) {
    for (i in first..second) {
        if (i%multipleOf == 0) {
            println("$i $message $multipleOf")
        }
    }
}

