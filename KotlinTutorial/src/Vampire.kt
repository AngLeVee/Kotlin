/**
 * Created by Angela Jensen for Android Oreo with Kotlin course
 */

open class Vampire (name: String): Enemy(name, 20, 3) {
    override fun takeDamage(damage: Int) {
        super.takeDamage(damage/2)
    }
}