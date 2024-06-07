package com.flypost.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flypost.dataclasses.DeliverySerializable
import com.flypost.dataclasses.deliveryToSerializable
import com.flypost.http.PostOffice
import com.flypost.http.RetrofitClient
import kotlinx.coroutines.launch

class DeliveryInfoViewModel(
    val deliverySerializable: DeliverySerializable,
) : ViewModel() {
    var officeFrom by mutableStateOf<PostOffice?>(null)
    var officeTo by mutableStateOf<PostOffice?>(null)

    init {
        getPostOffices()
    }

    private fun getPostOffices(){
        viewModelScope.launch {
            officeFrom = RetrofitClient.flyPostAPIService.getOffice(deliverySerializable.send_from)[0]
            officeTo = RetrofitClient.flyPostAPIService.getOffice(deliverySerializable.send_to)[0]
        }
    }
}