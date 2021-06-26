package com.garyjmj.wewerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.my_item.view.*

class AniamlAdapter(var itemsFromList: ArrayList<MyAnimals>, var clickListner: OnAnimalItemClickListner) :
        RecyclerView.Adapter<AnimalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_item, parent, false)

        return AnimalViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
//        holder.animalName.text = itemsFromList.get(position).name
//        holder.animalEat.text = itemsFromList.get(position).eat
//        holder.animallImg.setImageResource(itemsFromList.get(position).photo)
        holder.initialize(itemsFromList.get(position), clickListner)

    }

    override fun getItemCount(): Int {
        return itemsFromList.size
    }
}




class AnimalViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
    var animalName = itemView.Name_TextView
    var animalEat = itemView.Eat_TextView
    var animallImg = itemView.Img_ImageView

    fun initialize(item: MyAnimals, action: OnAnimalItemClickListner){
        animalName.text = item.name
        animalEat.text = item.eat
        animallImg.setImageResource(item.photo)

        itemView.setOnClickListener{
            action.onItemClick(item, adapterPosition)
        }
    }
}