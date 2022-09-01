package com.example.hw_6_1_counter.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hw_6_1_counter.MainViewModel
import com.example.hw_6_1_counter.R
import com.example.hw_6_1_counter.databinding.FragmentButtonBinding

class ButtonFragment : Fragment () {

    private lateinit var binding: FragmentButtonBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        binding = FragmentButtonBinding.inflate(layoutInflater)
        return binding.root
        //ViewModelProvider соединяет MainViewModel с жизненым циклом MainActivity
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPlus.setOnClickListener {
            // var text = ++sum
            // binding.tvCounter.text = "${++sum}"
            viewModel.onIncrementClick()
        }
        binding.btnMinus.setOnClickListener {
            viewModel.onDecrementClick()
        }
        viewModel.counter.observe(this) {
            binding.tvCounter.text = it.toString()
            //вывод результата в editText
        }
    }
}