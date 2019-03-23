import java.util.*

/**
 * Created by Angela Jensen for Android Oreo with Kotlin course
 */

class VampireKing(name: String): Vampire(name) {
    init {
        hitPoints = 140
        maxHP = hitPoints
        lives = 5
    }

    override fun takeDamage(damage: Int) {
        super.takeDamage(damage/2)
    }

    fun runAway(): Boolean {
        return lives < 2
    }

    fun dodges(): Boolean {
        val rand = Random()
        val chance = rand.nextInt(6)
        return chance > 3
    }

}