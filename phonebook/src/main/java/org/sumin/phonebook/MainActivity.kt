package org.sumin.phonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import org.sumin.phonebook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentList = listOf(DialFragment(),ListFragment())
        val adapter = FragmentAdapter(this)

        adapter.fragmentList = fragmentList
        binding.viewpager.adapter = adapter

        //탭설정
        val tabTitles = listOf<String>("키패드","연락처")
        TabLayoutMediator(binding.tabs, binding.viewpager){tab,position->
            tab.text = tabTitles[position]
        }.attach()
    }
} 