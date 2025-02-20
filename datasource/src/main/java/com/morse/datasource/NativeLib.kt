package com.morse.datasource

class NativeLib {

    /**
     * A native method that is implemented by the 'datasource' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'datasource' library on application startup.
        init {
            System.loadLibrary("datasource")
        }
    }
}