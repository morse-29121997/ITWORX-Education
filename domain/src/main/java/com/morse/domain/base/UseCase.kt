package com.morse.domain.base

abstract class UseCase <in Input , out Output> () {
    operator fun invoke(input : Input) : Output {
        return execute(input)
    }
    abstract fun execute(input : Input) : Output
}