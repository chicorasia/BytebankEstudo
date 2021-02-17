package br.com.chicorialabs.bytebank.dominio.conta

interface PermiteTransferencia {

    fun transfere(valor: Double, contaDestino: Conta, senha: Int)
}