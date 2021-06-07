package com.balsa.free_games.utils.extensions

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.balsa.free_games.ui.base.Event
import com.balsa.free_games.ui.base.EventObserver

@MainThread
inline fun <T> LiveData<Event<T>>.observeEvent(
    owner: LifecycleOwner,
    crossinline onChanged: (T) -> Unit
): Observer<Event<T>> {
    val wrappedObserver = EventObserver<T> { value ->
        onChanged.invoke(value)
    }
    observe(owner, wrappedObserver)
    return wrappedObserver
}