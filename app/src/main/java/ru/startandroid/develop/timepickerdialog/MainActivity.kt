package ru.startandroid.develop.timepickerdialog

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    var currentDateTime: TextView? = null
    var dateAndTime: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        currentDateTime = findViewById(R.id.currentDateTime)
        setInitialDateTime()
    }

    fun setTime(v:View) {
        TimePickerDialog(this, t,
            dateAndTime.get(Calendar.HOUR_OF_DAY),
            dateAndTime.get(Calendar.MINUTE), true)
            .show()
    }

    fun setInitialDateTime() {
        currentDateTime!!.text = DateUtils.formatDateTime(this,
        dateAndTime.timeInMillis,
        DateUtils.FORMAT_SHOW_TIME)
    }

    var t = TimePickerDialog.OnTimeSetListener {
        view, hourOfDay, minute ->
        dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
        dateAndTime.set(Calendar.MINUTE, minute)
        setInitialDateTime()
    }
}