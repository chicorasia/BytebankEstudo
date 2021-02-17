package test.dominio

import br.com.chicorialabs.bytebank.dominio.cliente.Cliente
import br.com.chicorialabs.bytebank.dominio.conta.Conta
import br.com.chicorialabs.bytebank.dominio.conta.ContaCorrente
import br.com.chicorialabs.bytebank.dominio.conta.ContaPoupanca
import br.com.chicorialabs.bytebank.dominio.conta.ContaSalario
import br.com.chicorialabs.bytebank.exception.FalhaAutenticacaoException
import br.com.chicorialabs.bytebank.exception.SaldoInsuficienteException
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test

class ContaTest{

    val hanSolo = Cliente(nome = "Han Solo", cpf = "111.111.111-22", senha = 1234)
    val greedo = Cliente(nome = "Greedo", cpf = "444.444.444-55", senha = 4321)
    val r2d2 = Cliente(nome = "R2D2", cpf = "000.000.000-11", senha = 1111)

    val contaCorrente = ContaCorrente(titular = hanSolo, numero = 1001)
    val contaPoupanca = ContaPoupanca(titular = greedo, numero = 1002)
    val contaSalario = ContaSalario(titular = r2d2, numero = 9009)

    @Test
    fun deve_AtualizarOTotalDeContas_AoCriarUmaContaDeQualquerTipo(){

        assertThat(Conta.Contador.totalDeContas, `is`(12))
        val novaConta = ContaCorrente(greedo, numero = 5005)
        assertThat(Conta.Contador.totalDeContas, `is`(13))

    }

    @Test
    fun deve_DescontarTaxaDeSaque_AoEfetuarUmSaqueDeContaCorrente(){

        contaCorrente.deposita(1000.0)
        contaCorrente.saca(100.0, 1234)

        assertThat(contaCorrente.saldo, `is`(equalTo(899.90)))

    }

    @Test
    fun naoDeve_DescontarTaxaDeSaque_AoEfetuarUmSaqueDeContaPoupanca(){

        contaPoupanca.deposita(1000.0)
        contaPoupanca.saca(100.0, 4321)

        assertThat(contaPoupanca.saldo, `is`(equalTo(900.0)))

    }

    @Test(expected = SaldoInsuficienteException::class)
    fun naoDeve_RealizarSaqueDeContaCorrente_SeValorDoSaqueMaisTaxaForMaiorQueOSaldo(){

        contaCorrente.deposita(100.0)
        contaCorrente.saca(100.0, 1234)

        assertThat(contaCorrente.saldo, `is`(equalTo(100.0)))

    }

    @Test
    fun deve_RealizarTransferencias_DeContaCorrenteParaContaSalario(){

        contaCorrente.deposita(1000.0)
        contaSalario.deposita(200.0)
        contaCorrente.transfere(100.0, contaSalario, 1234)

        assertThat(contaSalario.saldo, `is`(equalTo(300.0)))
    }

    @Test(expected = SaldoInsuficienteException::class)
    fun naoDeve_RealizarSaqueDeContaPoupanca_QuandoOSaldoForInsuficiente(){
        contaPoupanca.deposita(valor = 100.0)
        contaPoupanca.saca(valor = 1000.0, 4321)

    }

    @Test(expected = SaldoInsuficienteException::class)
    fun naoDeve_RealizarSaqueDeContaSalario_QuandoOSaldoForInsuficiente(){
        contaSalario.deposita(100.0)
        contaSalario.saca(1000.0, 1111)
    }

    @Test(expected = FalhaAutenticacaoException::class)
    fun naoDeve_REalizarSaque_QuandoASenhaEhIncorreta(){
        contaSalario.deposita(100.0)
        contaSalario.saca(1.0, 2222)

    }



}

