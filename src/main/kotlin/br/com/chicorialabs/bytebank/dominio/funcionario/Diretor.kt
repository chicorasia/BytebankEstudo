package br.com.chicorialabs.bytebank.dominio.funcionario

class Diretor(nome: String,
              cpf: String,
              salario: Double,
              senha: Int,
              val plr: Double = 200.0,
) : FuncionarioAdmin(
    nome = nome,
    cpf = cpf,
    salario = salario,
    senha = senha

){

    override val bonificacao: Double get() =
        salario + plr + salario * 0.1

}