import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lokalization.composeapp.generated.resources.Res
import lokalization.composeapp.generated.resources.app_language
import lokalization.composeapp.generated.resources.ar
import lokalization.composeapp.generated.resources.change_lang
import lokalization.composeapp.generated.resources.hello
import org.jetbrains.compose.resources.stringResource

val LocalAppLocalization = compositionLocalOf {
    AppLang.English
}

@Composable
fun App() {
    val currentLanguage = rememberAppLocale()

    val urlLauncher = rememberUrlLauncher()
    CompositionLocalProvider(
        LocalAppLocalization provides currentLanguage
    ) {
        MaterialTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {

                Text(
                    stringResource(
                        Res.string.app_language,
                        stringResource(LocalAppLocalization.current.stringRes)
                    )
                )
                Text(
                    stringResource(
                        Res.string.hello,
                    ),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Button(
                    onClick = {
                        urlLauncher.openAppSettings()

                    },
                ) {
                    Text(stringResource(Res.string.change_lang))
                }
            }
        }
    }

}

