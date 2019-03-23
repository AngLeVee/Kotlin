import kotlin.math.absoluteValue
/**
 * Created by Angela Jensen for Android Oreo with Kotlin course
 */

fun main() {
    println("Hello World")
    println("My first Kotlin program")

    var angela: String
    angela = "Angela Jensen"
    println(angela)

    var yn: String
    val yes = hashSetOf("Y", "y", "Yes", "yes")

    do {
        //Print menu
        println()
        println("Menu")
        println("---------------")
        println("1. Fruits")
        println("2. Name")
        println("3. Age")
        println("4. Player info")
        println("5. Enemies")
        print("> "); var number = readLine()!!.toInt().absoluteValue
        println()

        if (number < 1) {
            println("Please a non-zero number")
            print("> "); number = readLine()!!.toInt()
            println()
        }

        when(number){
            1 -> {
                val apples = 6
                val oranges = 5
                var fruit: Int = apples + oranges
                if (fruit == 1)
                    println("There is $fruit fruit")
                else
                    println("There are $fruit fruits")
                println("A quarter of the apples is ${apples/4}")
            }

            2 -> {
                println("My name is " + angela)
                println("My name is $angela")
                println("In all caps: ${angela.toUpperCase()}")
                println("I can print \$angela")
            }
            3 -> {
                println("What year were you born?")
                print("> "); var year = readLine()!!.toIntOrNull()

                var i = 1
                while (year == null && i <= 3)
                {
                    println("Please enter a number")
                    print("> "); year = readLine()!!.toIntOrNull()
                    i ++
                }

                if (year == null)
                    year = 2018

                println("Age you turned in which year:")
                for (i in 0..2) {
                    val oldYear = 2018 - (i * 5)
                    println("$oldYear: ${oldYear - year}")
                }
                println()
                println("Age you will be in which year:")
                for (i in 0 until 3){
                    val newYear = 2025 + (i * 5)
                    println("$newYear: ${newYear - year}")
                }
                println()
                println("Step version of age you'll be")
                for (i in 0..10 step 5){
                    val oldYear = 2020 + i
                    println("$oldYear: ${oldYear - year}")
                }
                println()
                println("forEach version of age you turned")
                (0..2).forEach {
                    val oldYear = 2018 - it * 5
                    println("$oldYear: ${oldYear - year}")
                }
            }

            4 -> {
                println("Enter a player name")
                print("> "); var name = readLine()!!.toString()

                var player = Player(name, level = 1)
                player.show()
                println(player)
                println()
                println(player.getData())
                println()
                println("Change player name?")
                print("> "); yn = readLine()!!.toString()

                if(yn in yes) {
                    println("Enter new name:")
                    print("> ")
                    player.setData(PlayerDataType.NAME, nameIn = readLine()!!.toString())
                    println("New Name: ${player.getData(PlayerDataType.NAME)}")
                }
                println()

                player.addLoot(Loot("Red Potion", LootType.POTION, 7.50))
                player.addLoot(Loot("Chainmail", LootType.ARMOR, 40.50))
                player.showInventory()
            }

            5 -> {
                println("Fight a generic enemy?")
                print("> ")
                if (readLine()!!.toString() in yes) {

                }
                val enemy = Enemy("Test", 10, 2)
                println(enemy)
                enemy.takeDamage(5)
                enemy.takeDamage(5)
                println()
                val troll = Troll("Test Troll")
                println(troll)
                troll.takeDamage(8)
                troll.takeDamage(30)
                println()
                val vampire = Vampire("Vlad")
                vampire.takeDamage(20)
                vampire.takeDamage(40)
                println()
                val vampKing = VampireKing("Dracula")
                while (vampKing.lives > 0) {
                    if (vampKing.runAway()) {
                        println("${vampKing.name} got away!")
                        break
                    }

                    if (!vampKing.dodges())
                        vampKing.takeDamage(200)
                    else
                        println("${vampKing.name} dodged")
                }
            }

            else ->
                println("Invalid number")
        }

        println()
        println("Pick another?")
        print("> "); yn = readLine()!!.toString()
    }while (yn in yes)

}