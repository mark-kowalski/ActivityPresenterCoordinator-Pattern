package dev.mko.dry.coordinatorpattern.example

import android.app.Activity

internal class PresenterFactory {

    fun getExamplePresenter(view: IExampleContract.View, activity: Activity, anyOtherParams: String):
            IExampleContract.Presenter {
        return ExamplePresenter(view, ExampleCoordinator(activity, anyOtherParams), anyOtherParams)
    }

}