package com.varunshankar.example22

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.varunshankar.example22.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.varunshankar.example22.CustomListData
import com.varunshankar.example22.MyRVAdapter

class MasterListFragment : Fragment() {
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView = inflater.inflate(R.layout.fragment_masterlist_layout, container, false)

        //Get the recycler view
        mRecyclerView = fragmentView.findViewById<View>(R.id.rv_Master) as RecyclerView

        //Tell Android that we know the size of the recyclerview doesn't change
        mRecyclerView!!.setHasFixedSize(true)

        //Set the layout manager
        layoutManager = LinearLayoutManager(activity)
        mRecyclerView!!.layoutManager = layoutManager

        //Get data from main activity
        val customListData = requireArguments().getParcelable<CustomListData>("item_list")
        val inputList = customListData!!.itemList

        //Set the adapter
        mAdapter = MyRVAdapter(inputList!!)
        mRecyclerView!!.adapter = mAdapter
        return fragmentView
    }
}