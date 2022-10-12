package com.basicapplication.utils.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil


class DefaultAdapterDiffUtilCallback<T : DefaultAdapterDiffUtilCallback.ModelWithId> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) =
        oldItem.fetchId() == newItem.fetchId()


    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) =
        oldItem == newItem


    interface ModelWithId {
        fun fetchId(): String
    }
}

