package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.cartAdapter
import com.example.myapplication.adapter.menuAdapter
import com.example.myapplication.databinding.FragmentMenubottomsheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenubottomsheetFragment :BottomSheetDialogFragment() {
 private lateinit var binding:FragmentMenubottomsheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.buttonback.setOnClickListener{
            dismiss()//issey back ho jyega leftarrow pr click karte hi
        }
        binding= FragmentMenubottomsheetBinding.inflate(inflater,container,false)
        val menuFoodName=listOf("Burger","sandwich","momo","sandich")
        val menuitemprice=listOf("$1","$2","$4","$6",)
        val menuimage= listOf(R.drawable.burger2, R.drawable.samosa, R.drawable.maggie, R.drawable.roll)
        val adapter= menuAdapter(ArrayList(menuFoodName),ArrayList(menuitemprice),ArrayList(menuimage))
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter
        return binding.root
    }

    companion object {



    }
}