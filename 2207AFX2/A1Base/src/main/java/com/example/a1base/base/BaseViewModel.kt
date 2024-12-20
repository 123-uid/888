package com.example.a1base.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BaseViewModel @Inject constructor(
    private val baseRest: BaseRest
) : ViewModel() {


    val c = Channel<BaseInt>(Channel.UNLIMITED)
    private val state =MutableStateFlow<BaseStr>(BaseStr.baseStr)
    val sta :StateFlow<BaseStr>
        get() = state

    init {
        viewModelScope.launch {
            c.receiveAsFlow().collect({
                when(it){
                    is BaseInt.baseInt->{
                        getBasrFlie()
                    }
                }
            })
        }
    }

     private fun getBasrFlie() {
        viewModelScope.launch {
           baseRest.getflie()
               .flowOn(Dispatchers.IO)
               .catch {  }
               .collect{
                   state.value = BaseStr.BaseFlie(it.data)
               }
        }
    }
}

