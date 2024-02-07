package com.example.exameight.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exameight.data.common.Resource
import com.example.exameight.domain.useCase.GetTripsUseCase
import com.example.exameight.presentation.mapper.toPresentation
import com.example.exameight.presentation.model.TripUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TripsViewModel @Inject constructor(private val getTripsUseCase: GetTripsUseCase) :
    ViewModel() {


    private val _tripsFlow = MutableSharedFlow<Resource<List<TripUI>>>()
    val tripsFlow: SharedFlow<Resource<List<TripUI>>> = _tripsFlow.asSharedFlow()


    fun getTripList() {
        viewModelScope.launch {

            getTripsUseCase.invoke().collect() {
                when (it) {
                    is Resource.Loading -> _tripsFlow.emit(Resource.Loading())
                    is Resource.Success -> {
                        _tripsFlow.emit(Resource.Success(it.responseData.map { trip ->
                            trip.toPresentation()
                        }))
                    }
                    is Resource.Failed -> _tripsFlow.emit(Resource.Failed(it.message))
                }
            }
        }
    }


}