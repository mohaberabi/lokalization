import androidx.compose.runtime.Composable

expect class UrlLauncher {
    fun openAppSettings()
}


@Composable
expect fun rememberUrlLauncher(): UrlLauncher