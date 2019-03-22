import java.util.ArrayList

/**
 * Created by Angela Jensen for Android Oreo with Kotlin course
 */

enum class PlayerDataType {
    NAME, LIVES, LEVEL, SCORE, ALL
}

class Player(private var name:String, private var lives: Int = 3,
             private var level: Int = 1, private var score: Int = 0){
    private val inventory = ArrayList<Loot>()

    fun getData(request: PlayerDataType = PlayerDataType.ALL): String {
        return when (request){
            PlayerDataType.NAME -> name
            PlayerDataType.LIVES -> lives.toString()
            PlayerDataType.LEVEL -> level.toString()
            PlayerDataType.SCORE -> score.toString()
            PlayerDataType.ALL -> toString()
        }
    }

    fun setData(input: PlayerDataType = PlayerDataType.ALL, nameIn : String = name, livesIn: Int = lives,
                levelIn: Int = level, scoreIn: Int = score) {
        when(input){
            PlayerDataType.NAME -> name = nameIn
            PlayerDataType.LIVES -> lives = livesIn
            PlayerDataType.LEVEL -> level = levelIn
            PlayerDataType.SCORE -> score = scoreIn
            PlayerDataType.ALL -> {
                name = nameIn
                lives = livesIn
                level = levelIn
                score = scoreIn
            }
        }
    }

    fun gainLevels(levelUps: Int = 1){
        level += levelUps
    }

    fun loseLives(livesLost: Int = 1){
        lives -= livesLost
    }

    fun show(){
        if (lives > 0)
            println("$name is alive")
        else
            println("$name is dead")
    }

    fun showInventory() {
        println("$name's Inventory")
        for (loot in inventory) {
            println(loot)
        }
    }

    fun addLoot (item: Loot){
        inventory.add(item)
    }

    fun dropLoot(item: Loot): Boolean {
        return if (inventory.contains(item)){
            inventory.remove(item)
            true
        } else { false }
    }

    fun dropLoot(name: String): Boolean {
        return inventory.removeIf { it.getData(LootDataType.NAME) == name }
    }

    override fun toString(): String {
        return """
    Player name: $name
    lives: $lives
    level: $level
    score: $score
        """.trimMargin()
    }
}