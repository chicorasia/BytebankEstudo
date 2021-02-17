package br.com.chicorialabs.bytebank.dominio.funcionario

import br.com.chicorialabs.bytebank.dominio.shared.Endereco

abstract class Funcionario(
    val nome: String,
    val cpf: String,
    val salario: Double,
) {

    abstract val bonificacao: Double

}