package com.example.myapplication.fragment

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.cartAdapter
import com.example.myapplication.databinding.CartItemBinding
import com.example.myapplication.databinding.FragmentCartBinding

//we have to add items in cart fragment;

class cartFragment : Fragment() {
//1st enable binding
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)
        val cartFoodName=listOf("Burger","sandwich","momo","sandich")
        val cartitemprice=listOf("$1","$2","$4","$6",)
        val cartimage= listOf(R.drawable.burger2, R.drawable.samosa, R.drawable.maggie, R.drawable.roll)
val adapter=cartAdapter(ArrayList(cartFoodName),ArrayList(cartitemprice),ArrayList(cartimage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter=adapter



        return binding.root
    }

    companion object {

    }
}