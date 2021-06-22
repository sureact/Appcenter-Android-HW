package org.sumin.phonebook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sumin.phonebook.databinding.ItemRecyclerBinding

internal class CustomAdapter:RecyclerView.Adapter<Holder>() {
    var listData = listOf<String>("베르무트","버본","럼","키안티","진","워커","스카치","코른","칼바도스")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val name = listData.get(position)
        holder.setName(name)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}
internal class Holder(val binding: ItemRecyclerBinding):RecyclerView.ViewHolder(binding.root){
    fun setName(name: String){
        binding.textName.text = name
    }
}