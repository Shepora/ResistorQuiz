## Visualización de Colores con Indicadores Circulares

Se añadió una representación visual de los colores seleccionados mediante círculos de color, facilitando la identificación rápida de las bandas de resistencia por parte del usuario.

### Ejemplo de código:

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
```
## Personalización de Temas con Material 3

Para la aplicacion se personalizó el esquema de colores y la tipografía utilizando Material 3, adaptando la apariencia de la aplicación a un tema oscuro y definiendo estilos de texto personalizados.​

### Ejemplo de código:

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
```
## Uso de clases enum

Una clase enum (enumeración) nos sirve para declarar un conjunto fijo y limitado de constantes. Cada constante puede tener propiedades y comportamientos. Son útiles cuando se maneja un grupo de valores que no cambian, como en este caso los colores de bandas de una resistencia.

