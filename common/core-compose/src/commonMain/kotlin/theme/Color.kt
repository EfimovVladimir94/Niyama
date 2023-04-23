package theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class NiyamaColors(
    val primaryBackground: Color,
    val primaryAction: Color,
    val primaryTextColor: Color,
    val highlightTextColor: Color,
    val secondaryTextColor: Color
)

val palette = NiyamaColors(
    primaryBackground = Color(red = 0, green = 0, blue = 0),
    primaryAction = Color(red = 242, green = 146, blue = 0),
    primaryTextColor = Color(red = 255, green = 255, blue = 255),
    highlightTextColor = Color(red = 242, green = 146, blue = 0),
    secondaryTextColor = Color(red = 154, green = 154, blue = 161)
)

val LocalColorProvider = staticCompositionLocalOf<NiyamaColors> { error("not find default impl") }