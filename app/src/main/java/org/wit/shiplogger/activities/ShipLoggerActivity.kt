package org.wit.shiplogger.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shiplogger.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.shiplogger.main.MainApp
import org.wit.shiplogger.models.ShipLoggerModel
import org.wit.shiplogger.R



class ShipLoggerActivity : AppCompatActivity(), AnkoLogger {


    var shiplogger = ShipLoggerModel()
    var app : MainApp? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shiplogger)
        app = application as MainApp


        btnAdd.setOnClickListener() {
                shiplogger.title = shipTitle.text.toString()
                shiplogger.description = description.text.toString()
                if (shiplogger.title.isNotEmpty()) {
                app!!.shiploggers.add(shiplogger.copy())
                info("add Button Pressed: $shipTitle")
                app!!.shiploggers.forEach{info("add Button Pressed: ${it}")}

            }
            else {
                toast ("Please Enter a title")
            }
        }
    }
}
