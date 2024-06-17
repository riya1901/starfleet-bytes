package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.PopularItemBinding
/*popularadapter(yaha variables initilise kr rhe h*/
class popularadapter(private val items:List<String>,private val prices:List<String>,private val images:List<Int>) : RecyclerView.Adapter<popularadapter.PopularViewHolder>{
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int):PopularViewHolder{
       return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context) ,parent,false))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item=items[position]
        val image=images[position]
        val price=prices[position]
        /* item and image ko holder me return krwenge ,,,,bind ka class v banao popoular viwe holder me */
        holder.bind(item,price,image)
    }

    override fun getItemCount(): Int {
        //yaha pr return krnge
        return items.size
    }
      class PopularViewHolder(private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root){
         private val imageview=binding.imageView
        fun bind(item:String,price:String,image:Int){/* bind function create kr rhe h*/
            binding.foodname.text=item
            binding.price.text=price
            imageview.setImageResource(image)
        }
    }
}