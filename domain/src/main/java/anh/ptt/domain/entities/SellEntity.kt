package anh.ptt.domain.entities

data class SellEntity(
    val id: Int,
    val name: String,
    val price: Int,
    val quantity: Int,
    val type: Int
)