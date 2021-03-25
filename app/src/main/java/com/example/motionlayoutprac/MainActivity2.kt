package com.example.motionlayoutprac

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.transition.TransitionManager
import com.example.motionlayoutprac.databinding.MainActivity2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: MainActivity2Binding
    var textVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)
        binding.button.setOnClickListener {
            TransitionManager.beginDelayedTransition(binding.linearLayout)
            binding.textView.visibility = if (textVisible) View.GONE else View.VISIBLE
            textVisible = !textVisible



        }
    }
}