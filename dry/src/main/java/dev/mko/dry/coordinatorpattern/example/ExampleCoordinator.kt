package dev.mko.dry.coordinatorpattern.example

import android.app.Activity
import dev.mko.dry.coordinatorpattern.BaseCoordinator

internal class ExampleCoordinator(activity: Activity, private val something: String) :
    BaseCoordinator(activity), IExampleContract.Coordinator {

    override fun doSomethingCoordinator() {
        // show a new view, alert or whatever you want
        something.plus("dependency")
        activity.fragmentManager.beginTransaction()
    }

}