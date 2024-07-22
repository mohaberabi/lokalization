package custom

import platform.Foundation.NSUserDefaults


private const val key = "AppleLanguages"
actual fun changeLocal(local: String) {
    NSUserDefaults.standardUserDefaults.setObject(arrayListOf(local), key)
}