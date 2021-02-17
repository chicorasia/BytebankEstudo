package br.com.chicorialabs.bytebank.dominio.conta

import br.com.chicorialabs.bytebank.dominio.cliente.Cliente
import br.com.chicorialabs.bytebank.exception.FalhaAutenticacaoException
import br.com.chicorialabs.bytebank.exception.SaldoInsuficienteException

class ContaCorrente(
    titular: Cliente,
    numero: Int
): Conta(
    titular = titular,
    numero = numero),

    PermiteTransferencia {

    override fun saca(valor: Double, senha: Int) {
        val valorComTaxa = valor + 0.10

        if (!podeSacar(valorComTaxa)){
            throw SaldoInsuficienteException(message = "Saldo insuficiente; valor disponível: $saldo")
        }

        if (!autentica(senha)){
            throw FalhaAutenticacaoException()
        }
        this.saldo -= valorComTaxa
    }

    override fun transfere(valor: Double, contaDestino: Conta, senha: Int) {

        if (!podeSacar(valor)) {
            throw SaldoInsuficienteException(message = "Saldo insuficiente; valor disponível: $saldo")
        }
        saca(valor, senha)
        contaDestino.deposita(valor)
    }
}
