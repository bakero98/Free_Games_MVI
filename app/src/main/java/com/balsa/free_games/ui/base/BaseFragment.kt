package com.balsa.free_games.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.balsa.free_games.utils.extensions.FragmentViewBindingDelegate
import com.balsa.free_games.utils.extensions.observeEvent

abstract class BaseFragment<BaseBinding : ViewBinding, S : BaseState, E : BaseEvent, A : BaseAction>(
    contentLayoutId: Int
) : Fragment(contentLayoutId) {

    protected val binding by this.doBinding()

    @Deprecated(
        "Do not override this function cause binding will not work", ReplaceWith(
            "super.onCreateView(inflater, container, savedInstanceState)",
            "dagger.android.support.DaggerFragment"
        )
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        provideViewModel().eventLiveData.observeEvent(this) { action ->
            onEvent(action)
        }

        provideViewModel().viewStateLiveData.observe(this.viewLifecycleOwner) { state ->
            render(state)
        }
    }

    abstract fun provideViewModel(): BaseViewModel<S, E, A>
    abstract fun doBinding(): FragmentViewBindingDelegate<BaseBinding>
    abstract fun render(state: S)
    abstract fun onEvent(event: E)
}