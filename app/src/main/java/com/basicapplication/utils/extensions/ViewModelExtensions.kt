package com.basicapplication.utils.extensions

import com.basicapplication.data.viewmodel.MainViewModel
import com.basicapplication.model.models.BasicApplicationModel
import com.basicapplication.model.models.ServerErrorResponseModel
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.crypto.SealedObject

//private fun <T : Any, K : SealedObject> getMainFragmentData(
//    scope: CoroutineScope,
//    dataFlow : MutableStateFlow<K>,
//    predicate: suspend () -> NetworkResponse<T, ServerErrorResponseModel>
//) =
//    scope.launch(Dispatchers.IO) {
//        when (val response = predicate()) {
//            is NetworkResponse.Success -> {
//                sortData(response)
//            }
//            is NetworkResponse.ServerError -> dataFlow.value = MainViewModel.MainFragmentActions.ShowError(response.body?.message!!)
//            is NetworkResponse.NetworkError -> dataFlow.value = MainViewModel.MainFragmentActions.ShowError(response.error.message!!)
//            is NetworkResponse.UnknownError -> dataFlow.value = MainViewModel.MainFragmentActions.ShowError(response.error.message!!)
//        }
//    }
//
//private fun <T : Any> sortData(response: NetworkResponse.Success<T>) {
//    when (val data = response.body) {
//        is BasicApplicationModel -> {
//            dataFlow.value = MainViewModel.MainFragmentActions.ShowDataTypeOne(data)
//        }
//    }
//}