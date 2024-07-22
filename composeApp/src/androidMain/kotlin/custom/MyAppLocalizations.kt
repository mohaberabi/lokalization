package custom

import java.util.Locale

actual fun changeLocal(local: String) {
    val newLocal = Locale(local)
    Locale.setDefault(newLocal)
}