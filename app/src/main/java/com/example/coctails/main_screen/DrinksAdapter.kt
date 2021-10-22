package com.example.coctails.main_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coctails.R
import kotlinx.android.synthetic.main.drink_item.view.*

class DrinksAdapter : RecyclerView.Adapter<DrinksAdapter.MainHolder>() {

    private var mListNotes = emptyList<AppNote>()


    class MainHolder(view: View) : RecyclerView.ViewHolder(view) {
        val drinkName: TextView = view.drink_name
        val drinkDescr: TextView = view.drink_description
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.drink_item, parent, false)
        return MainHolder(view)
    }

    override fun getItemCount(): Int = mListNotes.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.drinkName.text = mListNotes[position].text
        holder.drinkDescr.text = mListNotes[position].name
    }

    fun setList(list: List<AppNote>) {
        mListNotes = list
        notifyDataSetChanged()
    }

}