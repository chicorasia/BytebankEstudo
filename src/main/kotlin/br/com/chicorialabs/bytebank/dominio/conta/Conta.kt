package br.com.chicorialabs.bytebank.dominio.conta

import br.com.chicorialabs.bytebank.dominio.cliente.Cliente
import br.com.chicorialabs.bytebank.dominio.shared.Autenticavel

abstract class Conta(
    var titular: Cliente,
    val numero: Int

) : Autenticavel by titular{

    companion object Contador{

        var totalDeContas: Int = 0
            private set

        private fun incrementa(){
            totalDeContas++
        }

    }

    var saldo = 0.0
        protected set

    init {
        if(numero < 1000){
            println("Numero de conta inválido")
        }
        Contador.incrementa()
    }


    fun deposita(valor: Double) {
        if (valor > 0.0) {
            saldo += valor
        } else {
            println("O valor a depositar deve ser maior que zero!")
        }

    }

    abstract fun saca(valor: Double, senha:Int)

    fun podeSacar(valor: Double): Boolean {
        return valor <= this.saldo
    }

}