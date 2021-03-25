package com.example.motionlayoutprac

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.transition.*
import com.example.motionlayoutprac.databinding.MainActivity3Binding
import kotlin.math.exp


class MainActivity3 : AppCompatActivity() {
    lateinit var binding: MainActivity3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_three)
        binding.button2.setOnClickListener {
            //handleTouch()
//            slide()
//            fade()



            //s dsdajdjaskdjkasd
        }


    }



    private fun fade() {
        var fade=Fade(Visibility.MODE_OUT)
        TransitionManager.beginDelayedTransition(binding.parentLayout,fade)
        fade.addTarget(binding.button2)
        binding.button2.visibility=View.GONE

    }

    private fun slide() {
        var slideTransition=Slide(Gravity.RIGHT)
        slideTransition.duration=2000

        TransitionManager.beginDelayedTransition(binding.parentLayout, slideTransition)
        binding.button2.visibility= View.GONE


    }

    private fun handleTouch() {
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()

        binding.button2.setMinimumWidth(500)
        binding.button2.setMinimumHeight(350)

        var transition = ChangeBounds()
        transition.duration = 2000
        transition.setPathMotion(ArcMotion())

        TransitionManager.beginDelayedTransition(binding.parentLayout, transition);

        val set = ConstraintSet()

        set.clone(binding.parentLayout)

        set.connect(
            binding.button2.id, ConstraintSet.BOTTOM,
            ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0
        )
        set.clear(binding.button2.id, ConstraintSet.TOP)

        set.connect(
            binding.button2.id, ConstraintSet.RIGHT,
            binding.parentLayout.id, ConstraintSet.RIGHT, 0
        )
        set.clear(binding.button2.id, ConstraintSet.LEFT)

        set.constrainWidth(binding.button2.id, ConstraintSet.WRAP_CONTENT)

        set.applyTo(binding.parentLayout)
    }
}