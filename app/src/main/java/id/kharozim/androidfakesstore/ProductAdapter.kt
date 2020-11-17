package id.kharozim.androidfakesstore

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.kharozim.androidfakesstore.databinding.ItemProductBinding
import id.kharozim.androidfakesstore.models.ProductModel

class ProductAdapter(private val context: Context) :
    RecyclerView.Adapter<ProductAdapter.ProductViewholder>() {


    val sharedPreferences = LocalData(context)

    private var products = listOf<ProductModel>()
    fun setData(data: List<ProductModel>) {
        products = data
        notifyDataSetChanged()
    }

    inner class ProductViewholder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(product: ProductModel) {
            binding.tvNameProduct.text = product.title
            binding.tvPrice.text = "$${product.price}"
            Glide.with(binding.root).load(product.image).circleCrop().into(binding.ivImage)
            binding.btAdd.setOnClickListener {
                Log.e("TAG", "bindData: ${product.id}")

                val shared = sharedPreferences.checkoutArray.toMutableList()
                shared.add("${product.id}")
                sharedPreferences.checkoutArray = shared.toTypedArray()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewholder {
        val viewHolder = ProductViewholder(
            ItemProductBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: ProductViewholder, position: Int) {
        holder.bindData(products[position])
    }

    override fun getItemCount(): Int = products.size


}