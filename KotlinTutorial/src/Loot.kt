/**
 * Created by Angela Jensen for Android Oreo with Kotlin course
 */

enum class LootType {
    POTION, RING, ARMOR
}

enum class LootDataType {
    NAME, TYPE, VALUE, ALL
}

class Loot (private var name: String, private var type: LootType,
            private var value: Double) {

    fun getData(request: LootDataType = LootDataType.ALL): String {
        return when (request) {
            LootDataType.NAME -> name
            LootDataType.TYPE -> type.toString()
            LootDataType.VALUE -> value.toString()
            LootDataType.ALL -> toString()
        }
    }

    fun setData(input: LootDataType = LootDataType.ALL, nameIn: String = name,
                typeIn: LootType = type, valueIn: Double = value){
        when (input) {
            LootDataType.NAME -> name = nameIn
            LootDataType.TYPE -> type = typeIn
            LootDataType.VALUE -> value = valueIn
            LootDataType.ALL -> {
                name = nameIn
                type = typeIn
                value = valueIn
            }
        }
    }

    override fun toString(): String = "    $name is a ${type.toString().toLowerCase()} worth $value"

}