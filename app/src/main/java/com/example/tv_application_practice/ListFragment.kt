package com.example.tv_application_practice

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.leanback.app.RowsSupportFragment
import androidx.leanback.widget.*
import com.example.tv_application_practice.dataModel.DataModel

class ListFragment : RowsSupportFragment() {


    private var itemSelectedListener: ((DataModel.Article) -> Unit)? = null
    private var itemClickedListener: ((DataModel.Article) -> Unit)? = null


    private var rootAdapter: ArrayObjectAdapter =
        ArrayObjectAdapter(ListRowPresenter(FocusHighlight.ZOOM_FACTOR_LARGE))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = rootAdapter

        onItemViewSelectedListener = ItemViewSelectedListener()
        onItemViewClickedListener = ItemViewClickedListener()
    }

    fun bindData(dataList: List<DataModel.Article>, newsTitle:String) {
        Log.d("checkingData2",dataList.toString())
        val arrayObjectAdapter = ArrayObjectAdapter(ItemPresenter())
        dataList.forEach{
            arrayObjectAdapter.add(it)
        }
        val headerItem = HeaderItem(newsTitle)



        val listRow = ListRow(headerItem , arrayObjectAdapter)
        rootAdapter.add(listRow)
    }

    fun setOnContentSelectedListener(listener : (DataModel.Article) -> Unit){
        this.itemSelectedListener = listener
    }

    fun setOnItemClickListener(listener: (DataModel.Article) -> Unit) {
        this.itemClickedListener = listener
    }

    inner class ItemViewSelectedListener : OnItemViewSelectedListener {
        override fun onItemSelected(
            itemViewHolder: Presenter.ViewHolder?,
            item: Any?,
            rowViewHolder: RowPresenter.ViewHolder?,
            row: Row?
        ) {
            if (item is DataModel.Article){
                itemSelectedListener?.invoke(item)
            }

        }

    }

    inner class ItemViewClickedListener : OnItemViewClickedListener {
        override fun onItemClicked(
            itemViewHolder: Presenter.ViewHolder?,
            item: Any?,
            rowViewHolder: RowPresenter.ViewHolder?,
            row: Row?
        ) {
            if (item is DataModel.Article) {
                itemClickedListener?.invoke(item)
            }
        }

    }

}