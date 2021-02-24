package br.com.chicorialabs.bytebank.aplicacao

import br.com.chicorialabs.bytebank.dominio.funcionario.FuncionarioAdmin
import br.com.chicorialabs.bytebank.dominio.shared.Autenticavel

class SistemaInternoCLI {

    fun entra(usuario: Autenticavel, senha: Int,
              autenticado: () -> Unit = { infomaNivelDeAcesso(usuario)}): Boolean {
        if(usuario.autentica(senha)){
            println("Bem vindo ao ByteBank!")
            autenticado()
        } else {
            println("Falha na autenticação")
            return false
        }
        return true
    }

    fun infomaNivelDeAcesso(usuario: Autenticavel): Unit{
        when(usuario){
            is FuncionarioAdmin -> println("Privilégios elevados")
            else -> println("Acesso normal")
        }
    }


}



