package com.example.navigationdrawer.ui.spinner

import android.content.Context
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.navigationdrawer.R
import java.util.Locale

class CountryAdapter(
    context: Context,
    operatedCountry: List<OperatedCountry>
) : ArrayAdapter<OperatedCountry>(context, 0, operatedCountry) {
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: layoutInflater.inflate(R.layout.item_country, parent, false)
        getItem(position)?.let { country ->
            setItemForCountry(view, country)
        }
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (position == 0) {
            view = layoutInflater.inflate(R.layout.item_country, parent, false)
            view.findViewById<ImageView>(R.id.imageViewCountry).visibility = View.GONE
            view.findViewById<TextView>(R.id.textViewCountry).text = context.resources.getString(R.string.selectOption)
            view.findViewById<ImageView>(R.id.imageViewArrow).animate()
                .rotation(180f)
                .setDuration(300)
                .start()
            view.setOnClickListener {
                view.findViewById<ImageView>(R.id.imageViewArrow).animate()
                    .rotation(0f)
                    .setDuration(200)
                    .start()
                val root = parent.rootView
                root.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK))
                root.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK))
            }
        } else {
            view = layoutInflater.inflate(R.layout.item_country, parent, false)
            view.findViewById<ImageView>(R.id.imageViewArrow).visibility = View.GONE
            getItem(position)?.let { country ->
                setItemForCountry(view, country)
            }
        }
        return view
    }

    override fun getItem(position: Int): OperatedCountry? {
        if (position == 0) {
            return null
        }
        return super.getItem(position - 1)
    }

    override fun getCount() = super.getCount() + 1
    override fun isEnabled(position: Int) = position != 0
    private fun setItemForCountry(view: View, country: OperatedCountry) {
        val tvCountry = view.findViewById<TextView>(R.id.textViewCountry)
        val ivCountry = view.findViewById<ImageView>(R.id.imageViewCountry)
        val countryName = Locale("", country.countryCode).displayCountry
        tvCountry.text = countryName
        ivCountry.setBackgroundResource(country.icon)
        view.findViewById<ImageView>(R.id.imageViewArrow).animate()
            .rotation(0f)
            .setDuration(800)
            .start()
    }
}