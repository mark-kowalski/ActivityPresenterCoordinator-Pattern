package dev.mko.dry.coordinatorpattern.example

import dev.mko.dry.coordinatorpattern.BasePresenter

internal class ExamplePresenter(view: IExampleContract.View,
                                coordinator: IExampleContract.Coordinator,
                                private val something: String) :
    BasePresenter<IExampleContract.View, IExampleContract.Coordinator>(view, coordinator),
    IExampleContract.Presenter {

    override fun doSomethingPresenter() {
        coordinator?.doSomethingCoordinator()
        triggerSomethingOnView()
    }

    private fun triggerSomethingOnView() {
        view?.doSomething()
    }

}