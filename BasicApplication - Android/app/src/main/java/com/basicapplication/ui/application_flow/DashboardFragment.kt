package com.basicapplication.ui.application_flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.basicapplication.R
import com.basicapplication.data.viewmodel.DashboardViewModel
import com.basicapplication.databinding.FragmentMainBinding
import com.basicapplication.utils.extensions.launchAndRepeatWithViewLifecycle
import org.koin.android.ext.android.get

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val dashboardViewModel = get<DashboardViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeUiState()
    }

    private fun observeUiState() = launchAndRepeatWithViewLifecycle {

        dashboardViewModel.uiState.collect { uiState ->
            when (uiState.state) {
                DashboardViewModel.UiState.State.Initial -> Unit
                DashboardViewModel.UiState.State.Data -> {
                    Toast.makeText(requireContext(), uiState.modelsList.toString(), Toast.LENGTH_LONG).show()
                }
                DashboardViewModel.UiState.State.Error -> {
                    Toast.makeText(requireContext(), uiState.errorMessage, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}