package test.dominio

import br.com.chicorialabs.bytebank.dominio.funcionario.*
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test

class FuncionarioTest{

    @Test
    fun deve_CriarUmFuncionario_QuandoRecebeOsDadosViaConstrutor(){

        val hanSolo = Analista(nome = "Han Solo", cpf = "111.222.333-44", salario = 1000.0)

        assertTrue(hanSolo.nome.equals("Han Solo"))
        assertTrue(hanSolo.cpf.equals("111.222.333-44"))
        assertTrue(hanSolo.salario.equals(1000.0))

    }

    @Test
    fun deve_CalcularOValorDaBonificacao_EmFuncaoDoSalario(){

        val hanSolo = Analista(nome = "Han Solo", cpf = "111.222.333-44", salario = 1000.0)
        val bonificacao = hanSolo.bonificacao
        assertTrue(bonificacao == 100.0 + 100.0)
    }

    @Test
    fun deve_CriarUmFuncionarioTipoGerente_QuandoInvocaOConstrutor(){

        val gerente = Gerente("Jabba", "222.333.444-55", salario = 2000.0, 1234)

        assertThat(gerente.bonificacao, `is`(equalTo(200 + gerente.salario)))
    }

    @Test
    fun deve_Autenticar_QuandoRecebeASenhaCorreta(){

        val jabba = Gerente("Jabba", "222.333.444-55", salario = 2000.0, 1234)
        val senha = 1234

        assertTrue(jabba.autentica(senha))

    }

    @Test
    fun deve_RetornarMensagemDeErro_QuandoRecebeSenhaIncorreta(){

        val jabba = Gerente("Jabba", "222.333.444-55", salario = 2000.0, 1234)
        val senha = 4321

        assertFalse(jabba.autentica(senha))

    }

    @Test
    fun deve_CriarUmDiretor_QuandoOConstrutorEhInvocado(){

        val leia = Diretor("Leia", "444.444.444-44",
            salario = 4000.0, senha = 4321, plr = 200.0)

        assertThat(leia.nome, `is`(equalTo("Leia")))
        assertThat(leia.bonificacao, `is`(equalTo(400 + leia.salario + leia.plr)))
        assertThat(leia.plr, `is`(equalTo(200.0)))

    }

    @Test
    fun deve_CalcularOTotalDeBonificacao_AoReceberUmFuncionario(){

        val hanSolo = Analista(nome = "Han Solo", cpf = "111.222.333-44", salario = 1000.0)
        val jabba = Gerente("Jabba", "222.333.444-55", salario = 2000.0, 1234)
        val leia = Diretor("Leia", "444.444.444-44",
            salario = 4000.0, senha = 4321, plr = 200.0)
        val luke = Analista(nome = "Luke", cpf = "666.777.888-99", salario = 1500.0)
        val chewie = Auxiliar(nome = "Chewie", cpf = "999.888.777-66", salario = 1000.0)

        val calculadoraBonificacao = CalculadoraBonificacao()
        calculadoraBonificacao.registra(hanSolo)
        calculadoraBonificacao.registra(jabba)
        calculadoraBonificacao.registra(leia)
        calculadoraBonificacao.registra(luke)
        calculadoraBonificacao.registra(chewie)

        println("Valor total da bonificação: ${calculadoraBonificacao.total}")
        assertThat(calculadoraBonificacao.total, `is`(equalTo(7350.0)))

    }
}