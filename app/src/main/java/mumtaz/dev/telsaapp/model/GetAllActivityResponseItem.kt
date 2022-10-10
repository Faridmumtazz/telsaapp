package mumtaz.dev.telsaapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GetAllActivityResponseItem(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("judul")
    val judul: String,
    @SerializedName("rilis")
    val rilis: String,
    @SerializedName("updated_at")
    val updatedAt: String
) : Serializable