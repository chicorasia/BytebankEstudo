package br.com.chicorialabs.bytebank.dominio.conta

import br.com.chicorialabs.bytebank.dominio.cliente.Cliente
import br.com.chicorialabs.bytebank.exception.FalhaAutenticacaoException
import br.com.chicorialabs.bytebank.exception.SaldoInsuficienteException

class ContaSalario(
    titular: Cliente,
    numero: Int
): Conta(
    titular = titular,
    numero = numero)
{

    override fun saca(valor: Double, senha: Int) {
        val valorComTaxa = valor + 0.10

        if (!podeSacar(valorComTaxa)) {
            throw SaldoInsuficienteException()
        }

        if (!autentica(senha)){
            throw FalhaAutenticacaoException()
        }
        this.saldo -= valorComTaxa
    }

}
