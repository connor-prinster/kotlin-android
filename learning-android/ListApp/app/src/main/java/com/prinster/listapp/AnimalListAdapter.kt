package com.prinster.listapp

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class AnimalListAdapter(val items : ArrayList<Animal>, private val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        parent.background = ContextCompat.getDrawable(context, R.drawable.list_item_background)
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.animalType.text = items[position].getAnimalType()
        holder.animalDesc.text = items[position].getAnimalDesc()
        val isDangerous = items[position].getDangerous()
        if(isDangerous) {
            holder.setBackground(ContextCompat.getDrawable(context, R.drawable.list_item_background_dangerous))
        }
        holder.animalImage.setImageDrawable(
            ContextCompat.getDrawable(context, items[position].getImage())
        )
    }
}

class ViewHolder (private val view: View) : RecyclerView.ViewHolder(view) {
    var isDangerous = view.background!!
    val animalType = view.animal_type!!
    val animalDesc = view.animal_desc!!
    val animalImage = view.animal_image!!

    fun setBackground(background: Drawable?) {
        view.background = background!!
    }
}