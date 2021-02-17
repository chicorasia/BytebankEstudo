package br.com.chicorialabs.bytebank.dominio.cliente

import br.com.chicorialabs.bytebank.dominio.shared.Autenticavel
import br.com.chicorialabs.bytebank.dominio.shared.Endereco

class Cliente(
    var nome: String,
    val cpf: String,
    var endereco: Endereco = Endereco(),
    private val senha: Int,
): Autenticavel {

    override fun autentica(senha: Int): Boolean{
        if(this.senha == senha){
            println("Autenticado com sucesso!")
            return true
        }
        println("Falha na autenticação")
        return false
    }
}