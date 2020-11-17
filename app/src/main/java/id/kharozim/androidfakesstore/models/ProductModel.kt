package id.kharozim.androidfakesstore.models

import com.google.gson.annotations.SerializedName

data class ProductModel(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("price")
	val price: Double,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("category")
	val category: String
)
