package id.kharozim.androidfakesstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.kharozim.androidfakesstore.databinding.ActivityCheckoutProductBinding

class CheckoutProduct : AppCompatActivity() {
    private val binding by lazy { ActivityCheckoutProductBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}