package com.example.resistencequiz

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ResistorViewModel : ViewModel() {
    private val _result = MutableStateFlow("Seleccion")
    val result: StateFlow<String> = _result

    fun calculateResistance(
        band1: ColorBand,
        band2: ColorBand,
        multiplier: ColorBand,
        tolerance: ColorBand? = null
    ) {
        val value = ((band1.value!! * 10) + band2.value!!) * multiplier.multiplier
        val tolText = tolerance?.let { " ±${it.tolerance}%" } ?: ""
        _result.value = "${value.toInt()} Ω$tolText"
    }
}