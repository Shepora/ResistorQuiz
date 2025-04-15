## 🎨 Visualización de Colores con Indicadores Circulares

Se añadió una representación visual de los colores seleccionados mediante círculos de color, facilitando la identificación rápida de las bandas de resistencia por parte del usuario.

### 📌 Ejemplo de código:

```kotlin
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

---

### 🌙 2. Personalización de Temas con Material 3

```markdown
Se utilizó la nueva librería **Material 3** para personalizar colores, tipografía y aplicar un tema oscuro en toda la aplicación.

### 📌 Ejemplo de código:

```kotlin
private val DarkColorScheme = darkColorScheme(
    primary = Color.White,
    background = Color(0xFF1E1E1E),
    onPrimary = Color.Black,
    // Otros colores personalizados
)

val AppTypography = Typography(
    headlineSmall = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
)


---

### 🧱 3. Uso de Clases `enum`

```markdown
## 🧱 Uso de Clases `enum`

Se utilizó una clase `enum` para definir los diferentes colores de banda. Esta técnica permite estructurar mejor los datos constantes, como los valores y tolerancias asociados a cada color.

### 📌 Ejemplo de código:

```kotlin
enum class ColorBand(
    val nameColor: String,
    val value: Int?,
    val multiplier: Double?,
    val tolerance: String?
) {
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

