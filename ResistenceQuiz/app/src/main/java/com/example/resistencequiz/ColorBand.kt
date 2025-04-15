package com.example.resistencequiz

enum class ColorBand(val nameColor: String, val value: Int?, val multiplier: Double?, val tolerance: String?) {
    NEGRO("Negro", 0, 1.0, null),
    MARRON("Marrón", 1, 10.0, "±1%"),
    ROJO("Rojo", 2, 100.0, "±2%"),
    NARANJA("Naranja", 3, 1000.0, null),
    AMARILLO("Amarillo", 4, 10000.0, null),
    VERDE("Verde", 5, 100000.0, "±0.5%"),
    AZUL("Azul", 6, 1000000.0, "±0.25%"),
    VIOLETA("Violeta", 7, 10000000.0, "±0.1%"),
    GRIS("Gris", 8, 100000000.0, "±0.05%"),
    BLANCO("Blanco", 9, 1000000000.0, null),
    DORADO("Dorado", null, 0.1, "±5%"),
    PLATEADO("Plateado", null, 0.01, "±10%")
}

fun calculateResistance(
    band1: ColorBand,
    band2: ColorBand,
    multiplier: ColorBand,
    tolerance: ColorBand
): String {
    val digit1 = band1.value ?: return "Color inválido en banda 1"
    val digit2 = band2.value ?: return "Color inválido en banda 2"
    val multiplierValue = multiplier.multiplier ?: return "Color inválido en multiplicador"

    val baseValue = (digit1 * 10 + digit2) * multiplierValue
    val toleranceText = tolerance.tolerance ?: "±20%"

    return "$baseValue Ω $toleranceText"
}