package org.wit.shiplogger.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.wit.shiplogger.main.MainApp
import org.wit.shiplogger.R
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_shiplogger_list.*
import kotlinx.android.synthetic.main.card_shiplogger.view.*
import org.wit.shiplogger.models.ShipLoggerModel


class ShipLoggerListActivity : AppCompatActivity() {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shiplogger_list)
        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = ShipLoggerAdapter(app.shiploggers)
    }
}


class ShipLoggerAdapter constructor(private var shiploggers: List<ShipLoggerModel>) : RecyclerView.Adapter<ShipLoggerAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(LayoutInflater.from(parent?.context).inflate(R.layout.card_shiplogger, parent, false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val shiplogger =shiploggers[holder.adapterPosition]
        holder.bind(shiplogger)
    }

    override fun getItemCount(): Int = shiploggers.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(shiplogger: ShipLoggerModel) {
            itemView.shiploggerTitle.text = shiplogger.title
            itemView.description.text = shiplogger.description
        }
    }
}