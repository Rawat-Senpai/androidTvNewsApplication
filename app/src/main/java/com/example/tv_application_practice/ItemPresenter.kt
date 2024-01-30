package com.example.tv_application_practice

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide
import com.example.tv_application_practice.dataModel.DataModel

class ItemPresenter : Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {

        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_view, parent, false)
        val params = view.layoutParams
        params.width = getWidthInPercent(parent!!.context, 30)
        params.height = getHeightInPercent(parent!!.context, 45)
        return ViewHolder(view)

    }

    private fun getWidthInPercent(context: Context, percent: Int): Int {
        val width = context.resources.displayMetrics.widthPixels ?: 0
        return (width * percent) / 100
    }

    private fun getHeightInPercent(context: Context, percent: Int): Int {
        val width = context.resources.displayMetrics.heightPixels ?: 0
        return (width * percent) / 100
    }


    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {

        Log.d("checkingData0",item.toString())

        val content = item as? DataModel.Article
        val imageview = viewHolder?.view?.findViewById<ImageView>(R.id.poster_image)
        Log.d("checkingData00",content.toString())
        Glide.with(viewHolder?.view?.context!!)
            .load(content?.urlToImage)
            .into(imageview!!)

    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
    }
}