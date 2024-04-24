package com.misfit.orc.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.misfit.orc.databinding.ItemMainViewHolderBinding


import com.misfit.orc.delegates.HomeItemDelegates
import com.misfit.orc.dialogs.MainItemVO
import com.misfit.orc.viewHolder.BaseViewHolder
import com.misfit.orc.viewHolder.HomeItemViewHolder

class HomeItemAdapter(var delegate: HomeItemDelegates) : BaseAdapter<HomeItemViewHolder, MainItemVO>() {

    private var _binding: ItemMainViewHolderBinding? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseViewHolder<MainItemVO> {
        _binding = ItemMainViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeItemViewHolder(_binding!!, delegate)
    }

}