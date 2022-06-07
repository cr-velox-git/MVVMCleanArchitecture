package com.noobdev.propermvvmarcitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noobdev.propermvvmarcitecture.domain.model.DomainParsableResponse
import com.noobdev.propermvvmarcitecture.domain.usecase.GetDataUseCase
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
private val useCase: GetDataUseCase
): ViewModel() {

    private val _response:MutableLiveData<DomainParsableResponse> = MutableLiveData()
    val response: LiveData<DomainParsableResponse> get() = _response

    init {
        viewModelScope.launch {
            val result = useCase()
            _response.value = result
        }
    }
}