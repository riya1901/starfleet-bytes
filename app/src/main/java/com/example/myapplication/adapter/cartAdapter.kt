package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CartItemBinding


//adapter me new->kotlinclass->name->enter;
//recycler view ke aage class banynge and cartadapter ke sare elemnt extract krnge ,rightclick and export,,
//oncreatviewholdder/onbinding/get count yahi extracted elemnet haai,
class cartAdapter(private val cartItems:MutableList<String>,private val cartitemprices:MutableList<String>,private val cartimage:MutableList<Int>): RecyclerView.Adapter<cartAdapter.cartViewHolder>() {


private val itemQuantity=IntArray(cartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cartViewHolder {
     val binding=CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)//is line se hold kr liya an return krnge cartview
        return cartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: cartViewHolder, position: Int) {
       //now bind data here
        holder.bind(position)
    }

    override fun getItemCount(): Int =cartItems.size //size return krnge ki recycler view ki size

    inner class cartViewHolder( private val binding: CartItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
    binding.apply {
        val quantity=itemQuantity[position]//sare buttons ko bind kr liya jo v cart item me the
        cartfoodname.text=cartItems[position]
        cartfoodprice.text=cartitemprices[position]
        cartfoodimage.setImageResource(cartimage[position])
        cartitemquantity.text=quantity.toString()

        minus.setOnClickListener{
           //call function here
           decreaseQuantity(position)
        }
        plus.setOnClickListener{
         increaseQuantity(position)
        }
        cartdelete.setOnClickListener {

           val itemPosition=adapterPosition
            if(itemPosition !=RecyclerView.NO_POSITION){//yaha se check hoga ki recycler view me position hai ya nhi
                deleteitem(itemPosition)
            }

        }

    }
 }

           private fun increaseQuantity(position: Int){
                if(itemQuantity[position]<10){
                    itemQuantity[position]++
                    binding.cartitemquantity.text=itemQuantity[position].toString()//new position ko add krega quantity show jaha hoga

                }
            }
         private fun decreaseQuantity(position: Int) {
            if (itemQuantity[position] > 1) {
                itemQuantity[position]--
                binding.cartitemquantity.text =
                    itemQuantity[position].toString()//new position ko add krega quantity show jaha hoga

            }
        }
         private fun deleteitem(position: Int){
            cartItems.removeAt(position)
            cartitemprices.removeAt(position)
            cartimage.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,cartItems.size)
        }


//binding complete hua h yaha se

    }


}