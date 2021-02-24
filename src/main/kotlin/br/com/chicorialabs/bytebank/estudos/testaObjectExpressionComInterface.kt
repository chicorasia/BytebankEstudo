package br.com.chicorialabs.bytebank.estudos

import br.com.chicorialabs.bytebank.aplicacao.SistemaInternoCLI
import br.com.chicorialabs.bytebank.dominio.shared.Autenticavel

fun testaObjectExpressionComInterface() {
    print("Bem-vindo ao Bytebank\n")

    val sistemaInternoCLI = SistemaInternoCLI()

    val yoda = object : Autenticavel {
        val nome: String = "Yoda"
        val cpf: String = ""
        val senha: Int = 123

        override fun autentica(senha: Int) = this.senha == senha

    }

    sistemaInternoCLI.entra(yoda, 123)
}