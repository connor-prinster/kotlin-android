package com.prinster.listapp

import android.content.Context
import android.content.Intent
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
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentAnimal: Animal = items[position]

        holder.animalType.text = currentAnimal.getAnimalType()
        holder.animalDesc.text = currentAnimal.getAnimalDesc()
        val isDangerous = items[position].getDangerous()
        if(isDangerous) {
            holder.setBackground(ContextCompat.getDrawable(context, R.drawable.list_item_background_dangerous))
        }
        holder.animalImage.setImageDrawable(
            ContextCompat.getDrawable(context, currentAnimal.getImage())
        )

        holder.itemView.setOnClickListener {
//            Toast.makeText(context, "You clicked on ${currentAnimal.getAnimalType()}", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, AnimalDetails::class.java)
            intent.putExtra("type", currentAnimal.getAnimalType())
            intent.putExtra("desc", currentAnimal.getAnimalDesc())
            intent.putExtra("img", currentAnimal.getImage())
            context.startActivity(intent)
        }
    }
}

class ViewHolder (private val view: View) : RecyclerView.ViewHolder(view) {

    val animalType = view.animal_type!!
    val animalDesc = view.animal_desc!!
    val animalImage = view.animal_image!!

    fun setBackground(background: Drawable?) {
        view.background = background!!
    }
}