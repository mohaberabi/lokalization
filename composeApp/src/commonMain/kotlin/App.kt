import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import custom.changeLocal
import lokalization.composeapp.generated.resources.Res
import lokalization.composeapp.generated.resources.hello
import org.jetbrains.compose.resources.stringResource

val LocalAppLocalization = staticCompositionLocalOf { AppLocales.ENG }


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App() {
    var appLocal by remember { mutableStateOf(AppLocales.ENG) }
    var appDirection by remember { mutableStateOf(AppLocales.ENG.direction.toLayoutDirection()) }
    CompositionLocalProvider(
        LocalAppLocalization provides appLocal,
        LocalLayoutDirection provides appDirection,
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
                        Res.string.hello,
                    ),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )

                AppLocales.entries.forEach {


                    ListItem(

                        modifier = Modifier.fillMaxWidth()
                            .clickable {
                                appLocal = it
                                appDirection = it.direction.toLayoutDirection()
                                changeLocal(it.code)
                            },

                        text = {
                            Text(
                                it.label,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal,
                                )
                            )
                        },

                        trailing = {
                            Icon(
                                Icons.AutoMirrored.Default.ArrowForward,
                                contentDescription = ""
                            )
                        }
                    )


                }
            }


        }
    }

}

