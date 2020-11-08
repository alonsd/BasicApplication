package com.basicapplication.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.basicapplication.R
import com.basicapplication.databinding.FragmentMainBinding
import com.basicapplication.utils.network.Resource
import com.basicapplication.view.viewmodel.MainViewModel
import org.koin.android.ext.android.get

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val mainViewModel = get<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        mainViewModel.apiData.observe(viewLifecycleOwner, { resource ->

            when (resource) {
                is Resource.Loading -> {
                    //show loading to UI
                }
                is Resource.Completed -> {
                    Log.d("ApiResult", resource.data.toString())
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), resource.throwable.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}