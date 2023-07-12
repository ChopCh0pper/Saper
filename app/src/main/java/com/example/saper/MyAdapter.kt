package com.example.saper

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.saper.field.Generator

class MyAdapter(private val context: Context, private val cells: List<Generator.Cell>, private val numColumns: Int) : BaseAdapter() {
    private var isGameOver = false
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

        if (!isGameOver) {
            viewHolder.cell.setBackgroundResource(R.drawable.closed_cell_bg)

            viewHolder.cell.setOnClickListener {
                val cell = cells[position]

                if (cell.isClosed) {
                    if (cell.isBomb) gameOver(viewHolder)
                    else gameContinue(cell, viewHolder)
                }
            }
        } else {
            val cell = cells[position]
            if (cell.isBomb) {
                viewHolder.cell.setBackgroundResource(R.drawable.bomb_cell_bg)
            }
            viewHolder.cell.setOnClickListener(null)
        }

        val screenWidth = getScreenWidth(context)
        val cellSize = screenWidth / numColumns
        val layoutParams = viewHolder.cell.layoutParams
        layoutParams.width = cellSize
        layoutParams.height = cellSize
        viewHolder.cell.layoutParams = layoutParams

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

    private fun gameOver(viewHolder: ViewHolder) {
        isGameOver = true
        /*
            -выключение таймера
            -удаление сохранений
            -блокировка кнопки перезапуска игры
         */
        notifyDataSetChanged()
    }

    private fun gameContinue(cell: Generator.Cell, viewHolder: ViewHolder) {

        viewHolder.cell.setBackgroundResource(R.drawable.empty_cell_bg)
        if (cell.bombCount > 0) {
            viewHolder.cell.text = cell.bombCount.toString()
        } else {
            viewHolder.cell.text = ""
        }
    }
}