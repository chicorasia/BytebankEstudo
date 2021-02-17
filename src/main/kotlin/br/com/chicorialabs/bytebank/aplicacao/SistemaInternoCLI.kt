package br.com.chicorialabs.bytebank.aplicacao

import br.com.chicorialabs.bytebank.dominio.funcionario.FuncionarioAdmin
import br.com.chicorialabs.bytebank.dominio.shared.Autenticavel

class SistemaInternoCLI {

    fun entra(usuario: Autenticavel, senha: Int): Boolean {
        if(usuario.autentica(senha)){
            println("Bem vindo ao ByteBank!")
        } else {
            println("Falha na autenticação")
            return false
        }

        when(usuario){
            is FuncionarioAdmin -> println("Privilégios elevados")
            else -> println("Acesso normal")
        }

        return true


    }

}