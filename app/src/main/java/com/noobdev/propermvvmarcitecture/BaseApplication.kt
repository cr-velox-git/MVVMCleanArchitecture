package com.noobdev.propermvvmarcitecture

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * This [BaseApplication] is the app component.
 * we need to put it in application section of Menifest as name
 *
 * Hilt will create all the required components.
 * */
@HiltAndroidApp
class BaseApplication: Application()