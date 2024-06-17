package com.example.myapplication.fragment

import android.os.Bundle
//import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.myapplication.MenubottomsheetFragment
import com.example.myapplication.R
import com.example.myapplication.adapter.popularadapter
import com.example.myapplication.databinding.FragmentHome2Binding
import java.util.ArrayList


class homeFragment2 : Fragment() {

    private lateinit var binding: FragmentHome2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHome2Binding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding.viewmenu.setOnClickListener{
            val   bottomsheetdialogue=MenubottomsheetFragment()
            bottomsheetdialogue.show(parentFragmentManager,"test")
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    val imageList = ArrayList<SlideModel>()
    imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
    imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
    imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))


    val imageSlider = binding.imageSlider
    imageSlider.setImageList(imageList)
    imageSlider.setImageList(imageList, ScaleTypes.FIT )

    imageSlider.setItemClickListener(
    object : ItemClickListener {
        override fun doubleClick(position: Int) {
            TODO("Not yet implemented")
        }

        override fun onItemSelected(position: Int) {
            val itemPosition = imageList[position]
            val itemMessage = "select Image $position"
            Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
        }
    })
    /* adding recycler view*/
    val FoodName = listOf("Burger", "samosa", "maggie", "roll")
    val price = listOf("$5", "$10", "$15", "$8")
    val foodImages =
        listOf(R.drawable.burger2, R.drawable.samosa, R.drawable.maggie, R.drawable.roll)

    /*add adapter*/
    val adapter = popularadapter(FoodName, price, foodImages)//binding.kaha show krwana h
    binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    binding.recyclerView.adapter=adapter


}

    companion object {

    }
}