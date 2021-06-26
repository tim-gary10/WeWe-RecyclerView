package com.garyjmj.wewerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.garyjmj.wewerecyclerview.databinding.ActivityAnimalDetailsBinding
import kotlinx.android.synthetic.main.activity_animal_details.*

class AnimalDetailsActivity : AppCompatActivity() {
    lateinit var databinding: ActivityAnimalDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding =  DataBindingUtil.setContentView(this, R.layout.activity_animal_details)

        detail_name_textView.text = getIntent().getStringExtra("ANIMALNAME")
        detail_eat_textView.text = getIntent().getStringExtra("ANIMALEAT")

//        detail_iamgeView.setImageResource(getIntent().getStringExtra("ANIMALIMG").toInt())
        getIntent().getStringExtra("ANIMALIMG")?.let { detail_iamgeView.setImageResource(it.toInt()) }
    }
}