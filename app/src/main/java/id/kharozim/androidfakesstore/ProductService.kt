package id.kharozim.androidfakesstore

import id.kharozim.androidfakesstore.models.ProductModel
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    fun getAllProdutct() : Call<List<ProductModel>>
}