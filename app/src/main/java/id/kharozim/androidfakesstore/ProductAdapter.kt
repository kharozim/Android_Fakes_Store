package id.kharozim.androidfakesstore

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import id.kharozim.androidfakesstore.models.ProductModel

class ProductAdapter(private val context: Context) :
    RecyclerView.Adapter<ProductAdapter.ProductViewholder>() {

    private val products = listOf<ProductModel>()
    fun setData(data: List<ProductModel>) {
        products = data
        notifyDataSetChanged()
    }


    class ProductViewholder {

    }
}