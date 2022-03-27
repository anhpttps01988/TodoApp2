package anh.ptt.data.datasource.remote.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BuyResponse(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("price") val price: Float? = null,
    @SerializedName("quantity") val quantity: Int? = null,
    @SerializedName("type") val type: Int? = null
): Serializable