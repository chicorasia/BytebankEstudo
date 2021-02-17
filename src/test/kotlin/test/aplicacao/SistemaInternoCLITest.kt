package test.aplicacao

import br.com.chicorialabs.bytebank.aplicacao.SistemaInternoCLI
import br.com.chicorialabs.bytebank.dominio.cliente.Cliente
import br.com.chicorialabs.bytebank.dominio.funcionario.Diretor
import br.com.chicorialabs.bytebank.dominio.funcionario.Gerente
import org.junit.Assert.*
import org.junit.Test

class SistemaInternoCLITest{

    val sistemaInternoCLI = SistemaInternoCLI()
    val diretor = Diretor(
        nome = "Leia",
        cpf = "222.333.444-55",
        salario = 4000.0,
        senha = 4004,
        plr = 200.0
    )
    val gerente = Gerente(
        "Jabba",
        "222.333.444-55",
        salario = 2000.0,
        1234
    )
    val cliente = Cliente("Kylo Ren", "777.777.777-77", senha = 6666)


    @Test
    fun deve_retornarMensagemDeSucesso_QuandoFazAutenticacaoDeDiretor(){

        var autenticou = sistemaInternoCLI.entra(diretor, 4004)
        assertTrue(autenticou)

    }

    @Test
    fun naoDeve_AutenticarUsuario_QuandoRecebeSenhaIncorreta(){

        var autenticou = sistemaInternoCLI.entra(diretor, 1234)
        assertFalse(autenticou)

    }

    @Test
    fun deve_retornarMensagemDeSucesso_QuandoFazAutenticacaoDeGerente(){

        var autenticou = sistemaInternoCLI.entra(gerente, 1234)
        assertTrue(autenticou)
    }

    @Test
    fun deve_retornarMensagemDeSucesso_QuandoFazAutenticacaoDeCliente(){

        var autenticou = sistemaInternoCLI.entra(cliente, 6666)
        assertTrue(autenticou)
    }



}