package com.example.hw_6_1_counter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hw_6_1_counter.MainViewModel
import com.example.hw_6_1_counter.databinding.FragmentHistoryBinding
import com.example.hw_6_1_counter.fragments.adapters.HistoryAdapter

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var viewModel: MainViewModel
    private val adapter = HistoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvClick.adapter = adapter
        viewModel.historyClick.observe(viewLifecycleOwner) {
            adapter.initList(it)
            println(it.toString())
        }
    }
}
