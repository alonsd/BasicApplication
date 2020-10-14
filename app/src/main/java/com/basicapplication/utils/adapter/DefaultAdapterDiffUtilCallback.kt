package com.basicapplication.utils.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

/**
 * Default DiffUtil callback for lists adapters.
 * The adapter utilizes the fact that all models in the app implement the "ModelWithId" interface, so
 * it uses it in order to compare the unique ID of each model for `areItemsTheSame` function.
 * As for areContentsTheSame we utilize the fact that Kotlin Data Class implements for us the equals between
 * all fields, so use the equals() method to compare one object to another.
 */
class DefaultAdapterDiffUtilCallback<T : DefaultAdapterDiffUtilCallback.ModelWithId> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) =
        oldItem.fetchId() == newItem.fetchId()

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) =
        oldItem == newItem


    /**
     * An interface to determine for each model in the app what is the unique ID for it.
     * This is used for comparing the unique ID for each model for abstracting the DiffUtil Callback
     * and creating a default general one rather than a new class for each new adapter.
     */
    interface ModelWithId {
        fun fetchId(): String
    }
}

