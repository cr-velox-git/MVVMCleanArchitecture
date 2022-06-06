package com.noobdev.propermvvmarcitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noobdev.propermvvmarcitecture.network.model.ResponseDto
import com.noobdev.propermvvmarcitecture.network.model.ResponseDtoMapper
import com.noobdev.propermvvmarcitecture.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelClass
@Inject
constructor(
private val repository: Repository

): ViewModel() {

    private val _response:MutableLiveData<ResponseDto> = MutableLiveData()
    val response: LiveData<ResponseDto> get() = _response

    init {
        viewModelScope.launch {
            val result = repository.getDataRepo(0,1000)
            _response.value = result
        }
    }
}