package com.example.saper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import com.example.saper.field.Generator

class MyAdapter(private val context: Context, private val cells: List<Generator.Cell>) : BaseAdapter() {

    override fun getCount(): Int {
        return cells.size
    }

    override fun getItem(position: Int): Any {
        return cells[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.grid_item, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val cell = cells[position]
        if (cell.isBomb) {
            viewHolder.buttonCell.setBackgroundResource(R.drawable.bomb_button_bg)
        } else {
            viewHolder.buttonCell.setBackgroundResource(R.drawable.empty_button_bg)
        }

        if (cell.bombCount > 0) {
            viewHolder.buttonCell.text = cell.bombCount.toString()
        } else {
            viewHolder.buttonCell.text = ""
        }

        return view
    }

    private class ViewHolder(view: View) {
        val buttonCell: Button = view.findViewById(R.id.buttonCell)
    }
}