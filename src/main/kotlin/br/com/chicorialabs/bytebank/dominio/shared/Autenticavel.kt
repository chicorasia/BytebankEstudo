package br.com.chicorialabs.bytebank.dominio.shared

interface Autenticavel {

    fun autentica(senha: Int) : Boolean
}