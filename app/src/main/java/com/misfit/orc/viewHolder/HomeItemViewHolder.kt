package com.misfit.orc.viewHolder

import android.view.View
import androidx.core.content.ContextCompat
import com.misfit.orc.databinding.ItemMainViewHolderBinding
import com.misfit.orc.delegates.HomeItemDelegates
import com.misfit.orc.dialogs.MainItemVO

class HomeItemViewHolder(val binding: ItemMainViewHolderBinding, var delegate: HomeItemDelegates) :
    BaseViewHolder<MainItemVO>(binding.root) {

    override fun setData(data: MainItemVO, position: Int) {
        mData = data
        binding.apply {

           // ivLogo.setImageResource(data.icon)
            tvName.text = data.text

            tvName.setTextColor(
                ContextCompat.getColorStateList(
                    binding.root.context,
                    data.bgColor
                )
            )

        }

    }

    override fun onClick(v: View?) {
        mData?.let { delegate.onTapItem(it) }
    }
}