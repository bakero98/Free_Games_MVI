package com.balsa.free_games_mvi.ui.base

import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.balsa.free_games_mvi.utils.extensions.EventLiveData

abstract class BaseViewModel<S : BaseState, N : BaseEvent, A : BaseAction> : ViewModel() {

    protected var lastAction: A? = null

    protected val event = EventLiveData<N>()
    val eventLiveData: LiveData<Event<N>> = event

    protected val state = MutableLiveData<S>()
    val viewStateLiveData: LiveData<S> = state

    @CallSuper
    open fun executeAction(action: A) {
        lastAction = action
    }

}