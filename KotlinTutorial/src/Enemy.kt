/**
 * Created by Angela Jensen for Android Oreo with Kotlin course
 */

open class Enemy(val name: String, var hitPoints: Int, var lives: Int){
    var maxHP = hitPoints
    open fun takeDamage(damage: Int){
        var hpLeft = hitPoints - damage
        if (hpLeft > 0) {
            hitPoints = hpLeft
            println("$name took $damage damage and has $hitPoints hp left")
        } else {
            lives --
            if (lives < 1)
                println("$name took $damage damage and has died.")
            else {
                print("$name took $damage damage and lost a life")
                hitPoints = maxHP
                if (lives > 1) { print("; $lives lives left\n") }
                else { print("; $lives life left\n") }
            }
        }
    }

    override fun toString(): String {
        return "Name: $name, HP: $hitPoints, Lives: $lives"
    }
}