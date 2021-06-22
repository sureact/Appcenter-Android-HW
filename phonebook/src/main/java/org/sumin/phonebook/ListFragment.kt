package org.sumin.phonebook

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import org.sumin.phonebook.databinding.FragmentListBinding

class ListFragment : Fragment() {

    // RecyclerView.adapter에 지정할 Adapter
    private lateinit var customAdapter: CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListBinding.inflate(inflater,container,false)
        customAdapter = CustomAdapter()     //커스텀아답터 생성
        binding.recyclerView.adapter = customAdapter        //리사이클러뷰에 연결
        binding.recyclerView.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        Log.d("t","뷰생성됨")
        return binding.root
    }
}