package com.cassiolucianodasilva.movielistchallenge.data.repository

/**
 * ESTADO DA REDE
 * TODO
 *
 */
enum class Status {
    RUNNING,
    SUCCESS,
    FAILED

}

class NetworkState(val status: Status, val msg: String) {

    companion object {

        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState
        val ENDOFLIST: NetworkState

        init {
            LOADED = NetworkState(Status.SUCCESS, "Sucesso!")

            LOADING = NetworkState(Status.RUNNING, "Carregando...")

            ERROR = NetworkState(Status.FAILED, "Que triste ! Algo deu errado")

            ENDOFLIST = NetworkState(Status.FAILED, "Chegou ao fim")
        }
    }
}