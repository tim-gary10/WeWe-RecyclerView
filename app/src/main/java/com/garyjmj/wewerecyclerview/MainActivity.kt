package com.garyjmj.wewerecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.garyjmj.wewerecyclerview.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnAnimalItemClickListner {

    lateinit var binding: ActivityMainBinding
    lateinit var AnimalsList: ArrayList<MyAnimals>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        AnimalsList = ArrayList()

        addAnimals()

        Animal_RecyclerView.layoutManager = LinearLayoutManager(this)
        Animal_RecyclerView.addItemDecoration(DividerItemDecoration(this, 1))
        Animal_RecyclerView.adapter = AniamlAdapter(AnimalsList, this)
    }

    fun addAnimals() {
        AnimalsList.add(MyAnimals("Cat","Fish",R.drawable.cat))
        AnimalsList.add(MyAnimals("cow","Grass", R.drawable.cow))
        AnimalsList.add(MyAnimals("Deer","Grass", R.drawable.deer))
        AnimalsList.add(MyAnimals("Dog", "Meat", R.drawable.dog))
        AnimalsList.add(MyAnimals("Duck", "Meat", R.drawable.duck))
        AnimalsList.add(MyAnimals("GoldFish", "Pop Corn", R.drawable.goldfish))
        AnimalsList.add(MyAnimals("Horse", "Grass", R.drawable.horse))
        AnimalsList.add(MyAnimals("Panda", "Zhu", R.drawable.panda))
        AnimalsList.add(MyAnimals("Rabbit", "Carrot", R.drawable.rabbit))


    }

    override fun onItemClick(item: MyAnimals, position: Int) {

//        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, AnimalDetailsActivity::class.java)
        intent.putExtra("ANIMALNAME", item.name)
        intent.putExtra("ANIMALEAT", item.eat)
        intent.putExtra("ANIMALIMG", item.photo.toString())
        startActivity(intent)

    }
}