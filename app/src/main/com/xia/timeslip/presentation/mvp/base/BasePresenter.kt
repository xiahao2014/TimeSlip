package com.xia.timeslip.presentation.mvp.base

import io.armcha.arch.BaseMVPPresenter


/**
 * Created by Chatikyan on 31.07.2017.
 */
abstract class BasePresenter<V : BaseContract.View> : BaseMVPPresenter<V>(), BaseContract.Presenter<V>