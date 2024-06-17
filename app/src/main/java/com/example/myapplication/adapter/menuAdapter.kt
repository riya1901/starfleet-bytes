package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.MenuItemBinding

class menuAdapter(private  val menuitems:MutableList<String>,private  val menuitemsprice:MutableList<String>,private  val menuimages:MutableList<Int>):RecyclerView.Adapter<menuAdapter.menuViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): menuViewHolder {
//2)  enable binding
        val binding=MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return menuViewHolder(binding)
            //binding done
    }

    override fun onBindViewHolder(holder: menuViewHolder, position: Int) {
        // 3)  yah pr view holder ke lye view ko hold krwana h
        holder.bind(position)//define it in menuviewholder class;
    }

    override fun getItemCount(): Int = menuitems.size

    //1)enabling binding
     inner class menuViewHolder (private val binding:MenuItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
            //items ko show krwana h unki id ....
            binding.apply {
                menufoodname.text=menuitems[position]
                menufoodprice.text=menuitemsprice[position]
                menuImage.setImageResource(menuimages[position])
            }
        }
        //4)define bind function


    }
}