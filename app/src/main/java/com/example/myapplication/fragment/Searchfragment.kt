package com.example.myapplication.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.menuAdapter
import com.example.myapplication.databinding.FragmentSearchfragmentBinding


class Searchfragment : Fragment() {
    //enable binding;
    private lateinit var binding: FragmentSearchfragmentBinding
      private lateinit var  adapter: menuAdapter
   private val orignalmenufood= listOf("Burger","sandwich","momo","sandich")
    private val originalmenuitemprice=listOf("$1","$2","$4","$6",)
    private val originalmenuimage= listOf(R.drawable.burger2, R.drawable.samosa, R.drawable.maggie, R.drawable.roll)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
   private val  filteredmenufoodname= mutableListOf<String>()
    private val filteredMenuItemPrice= mutableListOf<String>()
    private val filteredMenuImage= mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
              binding= FragmentSearchfragmentBinding.inflate(inflater,container,false)
        adapter= menuAdapter(
           filteredmenufoodname,filteredMenuItemPrice,filteredMenuImage
        )
        binding.menuRecyclerView.layoutManager=LinearLayoutManager(requireContext())
          binding.menuRecyclerView.adapter=adapter
        //setup for search view
        //create function setup search view
        setUpSearchView()
//show all menun items
     showAllmenu()
        return binding.root
    }
    @SuppressLint("NotifyDataSetChanged")

    private fun showAllmenu() {
        filteredmenufoodname.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()


        filteredmenufoodname.addAll(orignalmenufood)
        filteredMenuItemPrice.addAll(originalmenuitemprice)
        filteredMenuImage.addAll(originalmenuimage)


        adapter.notifyDataSetChanged()

    }

    private fun setUpSearchView(){
        binding.searchView2.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true;
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun filterMenuItems(query: String) {
        filteredmenufoodname.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        orignalmenufood.forEachIndexed{index,foodName ->
            if(foodName.contains(query,ignoreCase = true)){
                filteredmenufoodname.add(foodName)
                filteredMenuItemPrice.add(originalmenuitemprice[index])
                filteredMenuImage.add(originalmenuimage[index])
            }
        }
        //notify adapter data set changed
        adapter.notifyDataSetChanged()

    }

    companion object {

    }
}