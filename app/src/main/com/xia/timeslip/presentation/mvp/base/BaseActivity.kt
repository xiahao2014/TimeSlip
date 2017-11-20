package com.xia.timeslip.presentation.mvp.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import com.xia.timeslip.App
import com.xia.timeslip.di.componet.ActivityComponent
import com.xia.timeslip.di.module.ActivityModule
import com.xia.timeslip.presentation.utils.S
import com.xia.timeslip.presentation.utils.extension.emptyString
import com.xia.timeslip.presentation.utils.extension.unSafeLazy
import com.xia.timeslip.presentation.widget.MaterialDialog
import io.armcha.arch.BaseMVPActivity
import com.xia.timeslip.presentation.navigation.Navigator

import javax.inject.Inject

abstract class BaseActivity<V : BaseContract.View, P : BaseContract.Presenter<V>>
    : BaseMVPActivity<V, P>(), Navigator.FragmentChangeListener {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var inflater: LayoutInflater

    private var dialog: MaterialDialog? = null

    val activityComponent: ActivityComponent by unSafeLazy {
        getAppComponent().plus(ActivityModule(this))
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        navigator.fragmentChangeListener = this
        super.onCreate(savedInstanceState)
    }

    @CallSuper
    override fun onDestroy() {
        dialog?.dismiss()
        super.onDestroy()
    }

    @CallSuper
    override fun onBackPressed() {
        if (navigator.hasBackStack())
            navigator.goBack()
        else
            super.onBackPressed()
    }

    protected abstract fun injectDependencies()

    private fun getAppComponent() = App.instance.applicationComponent

    inline protected fun <reified T : Fragment> goTo(keepState: Boolean = true,
                                                     withCustomAnimation: Boolean = false,
                                                     arg: Bundle = Bundle.EMPTY) {
        navigator.goTo<T>(keepState = keepState,
                withCustomAnimation = withCustomAnimation,
                arg = arg)
    }

    fun showDialog(title: String, message: String, buttonText: String = "Close") {
        dialog = MaterialDialog(this).apply {
            message(message)
                    .title(title)
                    .addPositiveButton(buttonText) {
                        hide()
                    }
                    .show()
        }
    }

    fun showErrorDialog(message: String?, buttonText: String = "Close") {
        showDialog(getString(S.error_title), message ?: emptyString, buttonText)
    }
}
