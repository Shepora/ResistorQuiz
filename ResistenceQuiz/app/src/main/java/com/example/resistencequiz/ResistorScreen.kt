package com.example.resistencequiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel


@Composable
fun ResistorScreen(){
    val viewModel: ResistorViewModel = viewModel()
    var band1 by remember { mutableStateOf(ColorBand.BROWN) }
    var band2 by remember { mutableStateOf(ColorBand.BLACK) }
    var multiplier by remember { mutableStateOf(ColorBand.RED) }
    var tolerance by remember { mutableStateOf(ColorBand.GOLD) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Visualización de la resistencia (bandas de colores)
        ResistorBands(band1, band2, multiplier, tolerance)

        // Selectores de bandas
        BandSelector("Banda 1 (Primer dígito)", band1) { band1 = it }
        BandSelector("Banda 2 (Segundo dígito)", band2) { band2 = it }
        BandSelector("Banda 3 (Multiplicador)", multiplier) { multiplier = it }
        BandSelector("Banda 4 (Tolerancia)", tolerance) { tolerance = it }

        // Botón de cálculo
        Button(
            onClick = {
                viewModel.calculateResistance(band1, band2, multiplier, tolerance)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular Resistencia")
        }

        // Resultado
        Text(
            text = viewModel.result.value,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun BandSelector(label: String, current: ColorBand, onSelection: (ColorBand) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val items = if (label.contains("Tolerancia")) ColorBand.getToleranceBands() else ColorBand.values()

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("$label: ${current.name}")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { color ->
                DropdownMenuItem(
                    text = { Text(color.name) },
                    onClick = {
                        onSelection(color)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun ResistorBands(band1: ColorBand, band2: ColorBand, band3: ColorBand, band4: ColorBand?) {
    Row(
        modifier = Modifier.padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        listOf(band1, band2, band3, band4).forEachIndexed { index, band ->
            if (band != null) {
                Box(
                    modifier = Modifier
                        .size(40.dp, 80.dp)
                        .background(getColorFromBand(band))
            }
            if (index < 3) Spacer(modifier = Modifier.width(4.dp))
        }
    }
}

fun getColorFromBand(band: ColorBand): Color {
    return when (band) {
        ColorBand.BLACK -> Color.Black
        ColorBand.BROWN -> Color(0xFF795548)
        ColorBand.RED -> Color.Red
        ColorBand.ORANGE -> Color(0xFFFF9800)
        ColorBand.YELLOW -> Color.Yellow
        ColorBand.GREEN -> Color.Green
        ColorBand.BLUE -> Color.Blue
        ColorBand.VIOLET -> Color(0xFF9C27B0)
        ColorBand.GRAY -> Color.Gray
        ColorBand.WHITE -> Color.White
        ColorBand.GOLD -> Color(0xFFFFD700)
        ColorBand.SILVER -> Color(0xFFC0C0C0)
        else -> Color.Transparent
    }
}