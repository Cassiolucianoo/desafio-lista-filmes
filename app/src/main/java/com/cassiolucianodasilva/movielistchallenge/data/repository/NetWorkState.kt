package com.cassiolucianodasilva.movielistchallenge.data.repository

/**
 * ESTADO DA REDE
 * TODO
 *
 */
enum class Status{
    RUNNING,
    SUCCESS,
    FAILED

}

class NetWorkState (val  status: Status, val msg : String){

    companion object{

        val LOADED: NetWorkState
        val LOADING: NetWorkState
        val ERRO: NetWorkState

        init {
            LOADED = NetWorkState(Status.SUCCESS, "SUCESSO")
            LOADING = NetWorkState(Status.RUNNING, "CARREGANDO")
            ERRO = NetWorkState(Status.FAILED, "Algo deu errado, verifique sua internet")
        }

    }

}