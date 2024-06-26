package com.misfit.orc.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<W>(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    protected var mData: W? = null

    init {
        itemView.setOnClickListener(this)
    }

    abstract fun setData(data: W,position:Int)

    open fun setID(mID: Int){

    }

}