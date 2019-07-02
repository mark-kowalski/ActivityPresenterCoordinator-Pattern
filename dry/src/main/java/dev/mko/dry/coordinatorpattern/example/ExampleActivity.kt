package dev.mko.dry.coordinatorpattern.example

import android.app.Activity
import android.os.Bundle

internal class ExampleActivity : Activity(), IExampleContract.View {

    private lateinit var presenter: IExampleContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = PresenterFactory().getExamplePresenter(this, this, "dependencies")
    }

    override fun onDestroy() {
        presenter.unbind()
        super.onDestroy()
    }

    override fun doSomething() {
        presenter.doSomethingPresenter()
    }

}