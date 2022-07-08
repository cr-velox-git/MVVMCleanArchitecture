package com.noobdev.propermvvmarcitecture.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noobdev.propermvvmarcitecture.domain.model.DomainResponse
import com.noobdev.propermvvmarcitecture.domain.usecase.GetDataUseCase
import com.noobdev.propermvvmarcitecture.utils.Resource
import com.noobdev.propermvvmarcitecture.utils.UiErrorText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class ViewModelClass
@Inject
constructor(
    private val getDataUseCase: GetDataUseCase
) : ViewModel() {

    private val _response: MutableLiveData<DomainResponse> = MutableLiveData()
    val response: LiveData<DomainResponse> get() = _response

//    private val _error:MutableLiveData<String> = MutableLiveData()
//    val error: LiveData<String> get() = _error

    var error by mutableStateOf<UiErrorText?>(null)
        private set


    init {
        Log.d("ViewModel","view model initiated")
        viewModelScope.launch {
            val response = getDataUseCase.invoke("random no use value just to get error in UiErrorText")
            when (response) {
                is Resource.Success -> {
                    _response.value = response.data
                    Log.d("ViewModel","data response success")
                }
                is Resource.Error -> {
                    error = response.message
                    Log.d("ViewModel","data response failed")
                    Log.d("ViewModel",error.toString())

                }
            }
        }
    }
}