package com.bignerdranch.nyethack

open class Room(val name: String) {
    protected open val status = "Calm"

    open val lootBox: LootBox<Loot> = LootBox.random()
    open fun description() = "$name (Currently: $status)"
    open fun enterRoom() = narrate("There is nothing to do here")
}

class TownSquare : Room("The TownSquare") {
    override val status = "Bustling"
    private val bellSound = "GWONG"
    val hatDropOffBox = DropOffBox<Hat>()
    val gemDropOffBox = DropOffBox<Gemstones>()
    final override fun enterRoom() {
        narrate("The villagers rally and cheer as the hero enters")
        ringBell()
    }

    fun <T> sellLoot(loot: T): Int where T : Loot, T : Sellable {
        return when (loot) {
            is Hat -> hatDropOffBox.sellLoot(loot)
            is Gemstones -> gemDropOffBox.sellLoot(loot)
            else -> 0
        }
    }

    private fun ringBell() = narrate("The bell tower announces the hero's presence: $bellSound")
}

open class MonsterRoom(
    name: String,
    var monster: Monster? = Goblin()
) : Room(name) {

    override fun description() =
        super.description() + " (Creature: ${monster?.description ?: "None"})"

    override fun enterRoom() {
        if (monster == null) super.enterRoom()
        else narrate("Danger is lurking is this room")
    }
}