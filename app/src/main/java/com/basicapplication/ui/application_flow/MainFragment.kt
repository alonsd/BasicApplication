package com.basicapplication.ui.application_flow

import android.os.Bundle
import android.util.Log
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
        Log.d("MainFragment", "onViewCreated: ${LogicTest.twoSum(intArrayOf(11, 15, 2, 7), 9)}")
    }


    fun twoSum2(nums: IntArray, target: Int): IntArray? {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[j] == target - nums[i]) {
                    return intArrayOf(i, j)
                }
            }
        }
        // In case there is no solution, we'll just return null
        return null
    }

    fun twoSum3(nums: IntArray, target: Int): IntArray? {
        val map: MutableMap<Int, Int> = HashMap()
        for (i in nums.indices) {
            map[nums[i]] = i
        }
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement) && map[complement] != i) {
                return intArrayOf(i, map[complement]!!)
            }
        }
        // In case there is no solution, we'll just return null
        return null
    }


    private fun init() = mainViewModel.getBasicApplicationDataTypeOne()

    private fun handleData() {

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