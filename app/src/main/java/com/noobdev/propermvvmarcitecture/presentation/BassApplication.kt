package com.noobdev.propermvvmarcitecture.presentation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * This [BaseApplication] is the app component.
 * we need to it in application section of Menifest as name
 *
 * Hilt will create all the required components.
 * */
@HiltAndroidApp
class BassApplication: Application() {
var sendRandom = "randomm"
}