package com.xia.timeslip.domain.fetcher.result_listener

import com.xia.timeslip.domain.result_listener.RequestType

/**
 * Created by Chatikyan on 04.08.2017.
 */
interface ResultListener {

    fun onRequestStart(){}

    fun onRequestStart(requestType: RequestType){}

    fun onRequestError(errorMessage: String?){}

    fun onRequestError(requestType: RequestType, errorMessage: String?){}
}