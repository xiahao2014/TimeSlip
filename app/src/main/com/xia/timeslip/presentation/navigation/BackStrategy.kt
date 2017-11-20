package com.xia.timeslip.presentation.navigation

import io.reactivex.annotations.Experimental


/**
 * Created by Chatikyan on 21.09.2017.
 */
@Experimental
sealed class BackStrategy {

    object KEEP : BackStrategy()
    object DESTROY : BackStrategy()
}