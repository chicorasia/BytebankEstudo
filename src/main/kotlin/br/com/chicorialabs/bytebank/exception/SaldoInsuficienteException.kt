package br.com.chicorialabs.bytebank.exception

import java.lang.Exception

class SaldoInsuficienteException(
    message: String = "Saldo insuficiente"
) : Exception(message) {

}