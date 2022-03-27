package anh.ptt.domain.entities

data class BuyEntity(
    val id: Int,
    val name: String,
    val price: Float,
    val quantity: Int,
    val type: Int
)