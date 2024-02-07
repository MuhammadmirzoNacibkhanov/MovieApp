package com.example.movieapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.MovieVenomBinding


class Adaptermain(private val listener: ((id: Int) -> Unit)) :
    RecyclerView.Adapter<Adaptermain.MyViewHolder>() {
    private val list: ArrayList<Mymodel> = ArrayList<Mymodel>()
    fun setList(list: List<Mymodel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    private var itemCardListener: ((id: Int) -> Unit)? = null

    fun setClickListener(card: ((id: Int) -> Unit)) {
        itemCardListener = card
    }

    inner class MyViewHolder(binding: MovieVenomBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding
        fun onBind(model: Mymodel) {
            binding.root.setOnClickListener {
                listener.invoke(model.id)
            }
            binding.image.setImageResource(model.image)
            binding.name.text = model.name

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            MovieVenomBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


}