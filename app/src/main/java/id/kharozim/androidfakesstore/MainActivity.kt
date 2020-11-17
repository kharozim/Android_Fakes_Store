package id.kharozim.androidfakesstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import id.kharozim.androidfakesstore.databinding.ActivityMainBinding
import id.kharozim.androidfakesstore.models.ProductModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        ProductClient.productService.getAllProdutct()
            .enqueue(object : Callback<List<ProductModel>> {
                override fun onResponse(
                    call: Call<List<ProductModel>>,
                    response: Response<List<ProductModel>>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            Log.e("TAG", "onResponse: ${Gson().toJson(response.body())}",)
                        }
                    } else {
                        Log.e("TAG", "Response gagal",)
                    }
                }

                override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                    Log.e("TAG", "${t.message}", )
                }

            })

    }
}