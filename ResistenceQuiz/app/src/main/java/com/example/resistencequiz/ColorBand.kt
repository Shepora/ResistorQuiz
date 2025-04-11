package com.example.resistencequiz

enum class ColorBand(
    val value: Int?,       // Valor para bandas 1 y 2
    val multiplier: Double, // Multiplicador (banda 3)
    val tolerance: Double?  // Tolerancia (banda 4, opcional)
    ) {
        BLACK(0, 1.0, 1.0),
        BROWN(1, 10.0, 2.0),
        RED(2, 100.0, null),
        ORANGE(3, 1000.0, null),
        YELLOW(4, 10_000.0, null),
        GREEN(5, 100_000.0, 0.5),
        BLUE(6, 1_000_000.0, 0.25),
        VIOLET(7, 10_000_000.0, 0.10),
        GRAY(8, 100_000_000.0, 0.05),
        WHITE(9, 1_000_000_000.0, null),
        GOLD(null, 0.1, 5.0),
        SILVER(null, 0.01, 10.0),
        NONE(null, 1.0, 20.0);

    companion object {
        fun getToleranceBands(): List<ColorBand> {
            return listOf(BROWN, RED, GREEN, BLUE, VIOLET, GRAY, GOLD, SILVER, NONE)
        }
    }
}

