package anh.ptt.data.datasource.remote.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CallResponse(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("number") val number: Long? = null
) : Serializable