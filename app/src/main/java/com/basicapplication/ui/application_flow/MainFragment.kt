package com.basicapplication.ui.application_flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.basicapplication.R
import com.basicapplication.data.viewmodel.MainViewModel
import com.basicapplication.databinding.FragmentMainBinding
import org.koin.android.ext.android.get

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val mainViewModel = get<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        handleData()
    }

    private fun init() = mainViewModel.getBasicApplicationDataTypeOne()

    private fun handleData()  {

        mainViewModel.actions.observe(viewLifecycleOwner) { action ->
            when (action) {
                is MainViewModel.MainViewModelActions.ShowDataTypeOne -> {
                    Toast.makeText(requireContext(), action.modelsList.toString(), Toast.LENGTH_LONG).show()
                }
                is MainViewModel.MainViewModelActions.ShowGeneralError -> {
                    Toast.makeText(requireContext(), action.errorMessage, Toast.LENGTH_LONG).show()
                }
                else -> return@observe
            }
        }
    }

}