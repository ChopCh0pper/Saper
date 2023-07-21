package com.example.saper

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.saper.game.Game

class MyAdapter(private val context: Context, private val cells: Array<Array<Game.Cell>>,
                private val numColumns: Int
                ) : BaseAdapter() {
    var clickListener:  ((Int, Int) -> Unit)? = null
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

        val screenWidth = getScreenWidth(context)
        val cellSize = screenWidth / numColumns
        val layoutParams = viewHolder.cell.layoutParams
        layoutParams.width = cellSize
        layoutParams.height = cellSize
        viewHolder.cell.layoutParams = layoutParams

        viewHolder.cell.setBackgroundResource(R.drawable.closed_cell_bg)

        view.setOnClickListener { clickListener?.invoke(positionX, positionY) }

        return view
    }

    private class ViewHolder(view: View) {
        val cell: TextView = view.findViewById(R.id.cell)
    }

    private fun getScreenWidth(context: Context): Int {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }
}