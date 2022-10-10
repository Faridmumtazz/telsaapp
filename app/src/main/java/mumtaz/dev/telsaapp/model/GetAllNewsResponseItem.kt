package mumtaz.dev.telsaapp.model


import com.google.gson.annotations.SerializedName

data class GetAllNewsResponseItem(
    @SerializedName("id")
    val id: String,
    @SerializedName("judul")
    val judul: String,
    @SerializedName("rilis")
    val rilis: String
)