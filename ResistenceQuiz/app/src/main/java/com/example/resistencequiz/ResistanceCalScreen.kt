package com.example.resistencequiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ResistanceCalScreen() {
    var band1 by remember { mutableStateOf(ColorBand.MARRON) }
    var band2 by remember { mutableStateOf(ColorBand.ROJO) }
    var multiplier by remember { mutableStateOf(ColorBand.NARANJA) }
    var tolerance by remember { mutableStateOf(ColorBand.DORADO) }

    val result = calculateResistance(band1, band2, multiplier, tolerance)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Text("Calculadora de Resistencias", style = MaterialTheme.typography.headlineSmall)

        DropdownBandSelector("Banda 1", band1) { band1 = it }
        DropdownBandSelector("Banda 2", band2) { band2 = it }
        DropdownBandSelector("Multiplicador", multiplier) { multiplier = it }
        DropdownBandSelector("Tolerancia", tolerance) { tolerance = it }

        HorizontalDivider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)

        Text("Resultado:", style = MaterialTheme.typography.headlineSmall)
        Text(result, style = MaterialTheme.typography.bodyLarge)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownBandSelector(
    label: String,
    selectedBand: ColorBand,
    onBandSelected: (ColorBand) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(label, style = MaterialTheme.typography.labelLarge)

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            // Selector visible
            TextField(
                readOnly = true,
                value = selectedBand.nameColor,
                onValueChange = {},
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(0.8f), // Puedes ajustar esto
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )

            // Menú desplegable
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                ColorBand.entries.forEach { color ->
                    DropdownMenuItem(
                        text = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(getColorFromBand(color))
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(color.nameColor)
                            }
                        },
                        onClick = {
                            onBandSelected(color)
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Visualización del color actual seleccionado
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(getColorFromBand(selectedBand))
        )
    }
}
fun getColorFromBand(band: ColorBand): Color {
    return when (band) {
        ColorBand.NEGRO -> Color.Black
        ColorBand.MARRON -> Color(0xFF8B4513)
        ColorBand.ROJO -> Color.Red
        ColorBand.NARANJA -> Color(0xFFFFA500)
        ColorBand.AMARILLO -> Color.Yellow
        ColorBand.VERDE -> Color.Green
        ColorBand.AZUL -> Color.Blue
        ColorBand.VIOLETA -> Color(0xFF8A2BE2)
        ColorBand.GRIS -> Color.Gray
        ColorBand.BLANCO -> Color.White
        ColorBand.DORADO -> Color(0xFFFFD700)
        ColorBand.PLATEADO -> Color(0xFFC0C0C0)
    }
}
