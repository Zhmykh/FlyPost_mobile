package com.flypost.viewModels

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.flypost.http.Delivery
import com.flypost.http.RetrofitClient
import kotlinx.coroutines.launch

class DeliveriesViewModel(application: Application) : AndroidViewModel(application) {
    var deliveries by mutableStateOf(listOf<Delivery>())
        private set

    init {
        getDeliveriesList()
    }

    private fun getDeliveriesList() {
        viewModelScope.launch {
            val id = 1
            deliveries = RetrofitClient.flyPostAPIService.getDeliveries(id)
        }
    }


}