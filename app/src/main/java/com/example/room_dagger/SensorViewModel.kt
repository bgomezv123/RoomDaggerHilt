package com.example.room_dagger

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.room_dagger.domain.sensor.model.AddSensor
import com.example.room_dagger.domain.sensor.model.GetAllSensorPagedUseCase
import com.example.room_dagger.domain.sensor.model.GetSensors
import com.example.room_dagger.domain.sensor.model.SensorDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SensorViewModel @Inject constructor(
    private val getSensors: GetSensors,
    private  val addSensor: AddSensor,
    private val getAllSensorPagedUseCase: GetAllSensorPagedUseCase
) : ViewModel(){

    private val _state: MutableState<SensorState> = mutableStateOf(SensorState())
    val state : State<SensorState> get() = _state
    val sensorPageData: Flow<PagingData<SensorDomain>> = getAllSensorPagedUseCase().cachedIn(viewModelScope)

    init {
        collectSensors()
    }
    private fun collectSensors(){
        viewModelScope.launch(Dispatchers.IO) {
            val fetchSensors  = getSensors()
            Log.d("GET_ALL_SENSORS:",fetchSensors.toString())
            withContext(Dispatchers.Main){
                _state.value = _state.value.copy(sensors = fetchSensors)
            }
        }
    }


}