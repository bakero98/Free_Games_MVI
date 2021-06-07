package com.balsa.free_games.ui.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.balsa.free_games.utils.extensions.observeEvent

abstract class BaseActivity<BaseBinding : ViewBinding, S : BaseState, E : BaseEvent, A : BaseAction> :
    AppCompatActivity() {

    val binding by this.doBinding()

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        provideViewModel().eventLiveData.observeEvent(this) { action ->
            onEvent(action)
        }

        provideViewModel().viewStateLiveData.observe(this) { state ->
            render(state)
        }
    }


    abstract fun doBinding(): Lazy<BaseBinding>
    abstract fun provideViewModel(): BaseViewModel<S, E, A>
    abstract fun render(state: S)
    abstract fun onEvent(event: E)

}