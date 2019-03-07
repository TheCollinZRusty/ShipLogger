package org.wit.shiplogger.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.shiplogger.models.ShipLoggerModel

class MainApp : Application(), AnkoLogger {

    val shiploggers = ArrayList<ShipLoggerModel>()
    override fun onCreate() {
        super.onCreate()
        info("Placemark started")
        shiploggers.add(ShipLoggerModel("One", "About one..."))
        shiploggers.add(ShipLoggerModel("Two", "About two..."))
        shiploggers.add(ShipLoggerModel("Three", "About three..."))
    }
}