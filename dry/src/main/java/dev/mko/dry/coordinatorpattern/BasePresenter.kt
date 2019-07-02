package dev.mko.dry.coordinatorpattern

open class BasePresenter<T, S>(protected var view: T?, protected var coordinator: S?)
    : IBasePresenter {

    override fun unbind() {
        view = null
        coordinator = null
    }

}