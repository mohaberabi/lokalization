import lokalization.composeapp.generated.resources.Res
import lokalization.composeapp.generated.resources.ar
import lokalization.composeapp.generated.resources.en
import org.jetbrains.compose.resources.StringResource

enum class AppLang(
    val code: String,
    val stringRes: StringResource
) {
    English("en", Res.string.en),
    Arabic("ar", Res.string.ar)
}


