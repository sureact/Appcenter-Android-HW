package org.sumin.phonebook

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sumin.phonebook.databinding.FragmentDialBinding

class DialFragment : Fragment() {

    var input = ""
    var end = 0
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDialBinding.inflate(inflater,container,false)
        binding.number0.setOnClickListener {
            Log.d("t","호출")
            input = input+"0"
            binding.textView.text = input
            end++
        }
        binding.number1.setOnClickListener {
            Log.d("t","호출")
            input = input+"1"
            binding.textView.text = input
            end++
        }
        binding.number2.setOnClickListener {
            Log.d("t","호출")
            input = input+"2"
            binding.textView.text = input
            end++
        }
        binding.number3.setOnClickListener {
            Log.d("t","호출")
            input = input+"3"
            binding.textView.text = input
            end++
        }
        binding.number4.setOnClickListener {
            Log.d("t","호출")
            input = input+"4"
            binding.textView.text = input
            end++
        }
        binding.number5.setOnClickListener {
            Log.d("t","호출")
            input = input+"5"
            binding.textView.text = input
            end++
        }
        binding.number6.setOnClickListener {
            Log.d("t","호출")
            input = input+"6"
            binding.textView.text = input
            end++
        }
        binding.number7.setOnClickListener {
            Log.d("t","호출")
            input = input+"7"
            binding.textView.text = input
            end++
        }
        binding.number8.setOnClickListener {
            Log.d("t","호출")
            input = input+"8"
            binding.textView.text = input
            end++
        }
        binding.number9.setOnClickListener {
            Log.d("t","호출")
            input = input+"9"
            binding.textView.text = input
            end++
        }
        binding.numberStar.setOnClickListener {
            Log.d("t","호출")
            input = input+"*"
            binding.textView.text = input
            end++
        }
        binding.numberUndo.setOnClickListener {
            end--
            if (end<0) end = 0
            input = input.substring(0,end)
            binding.textView.text = input
        }
        return binding.root
    }

}

