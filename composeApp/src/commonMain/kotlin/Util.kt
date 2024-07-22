import androidx.compose.ui.unit.LayoutDirection

enum class LangDirection {
    RTL,
    LTR,
}

enum class AppLocales(
    val code: String,
    val label: String,
    val direction: LangDirection,

    ) {

    ENG(
        "en", "English", LangDirection.LTR,
    ),
    ARA(
        "ar", "عربي", LangDirection.RTL,
    )
}


fun LangDirection.toLayoutDirection(): LayoutDirection = when (this) {
    LangDirection.RTL -> LayoutDirection.Rtl
    LangDirection.LTR -> LayoutDirection.Ltr
}