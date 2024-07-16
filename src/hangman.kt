import kotlin.random.Random

val words = listOf("bla","bli","blo")
var word = ""
var guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0

fun setupGame(){
    val wordIndex = Random.nextInt(words.size)
    word = words[wordIndex].uppercase()
    for (i in word.indices){
        guesses.add('_')
    }

    var gameOver = false
    do{
        printGameStatus()
        println("Please enter a letter ")
        val input = readLine()?:""

        if(input.isEmpty()){
            println("That is invalid")
        }
        else{
            val letter = input[0].uppercase().single()
            if(word.contains(letter)){
                for(i in word.indices){
                    if(word[i] == letter)
                        guesses[i] = letter
                }
                if(!guesses.contains('_'))
                    gameOver = true
            }else{
                println("Wrong")
                remainingGuesses--
                mistakes++
                if(mistakes == 6){
                    gameOver = true
                }

            }
        }
    }while(!gameOver)
    printGameStatus()

    if(mistakes == 6){
        println("Sorry, you lost. The word was $word")
    }else{
        println("You won!")
    }


}

fun print0Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}
fun print1Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}
fun print2Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |      | ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}
fun print3Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /| ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}
fun print4Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}
fun print5Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     /  ")
    println(" /|\\      ")
    println("/ | \\     ")
}
fun print6Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     / \\")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun printGameStatus(){
    when (mistakes){
        0 -> print0Mistakes()
        1 -> print1Mistakes()
        2 -> print2Mistakes()
        3 -> print3Mistakes()
        4 -> print4Mistakes()
        5 -> print5Mistakes()
        6 -> print6Mistakes()
    }

    print("Word: ")
    for(element in guesses) {
        print("$element ")
    }
    println("\n You have $remainingGuesses guess(es) left")
}


fun main(args : Array<String>){
    setupGame()


}