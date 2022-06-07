package com.noobdev.propermvvmarcitecture.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noobdev.propermvvmarcitecture.domain.model.DomainResponse
import com.noobdev.propermvvmarcitecture.domain.usecase.GetDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class ViewModelClass
@Inject
constructor(
private val useCase: GetDataUseCase
): ViewModel() {

    private val _response:MutableLiveData<DomainResponse> = MutableLiveData()
    val response: LiveData<DomainResponse> get() = _response

    init {
        viewModelScope.launch {
            val result = useCase()
            _response.value = result
        }
    }
}