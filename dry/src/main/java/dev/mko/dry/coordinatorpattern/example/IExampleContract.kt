package dev.mko.dry.coordinatorpattern.example

import dev.mko.dry.coordinatorpattern.IBasePresenter

interface IExampleContract {

    interface View {
        fun doSomething()
    }

    interface Presenter : IBasePresenter {
        fun doSomethingPresenter()
    }

    interface Coordinator {
        fun doSomethingCoordinator()
    }

}