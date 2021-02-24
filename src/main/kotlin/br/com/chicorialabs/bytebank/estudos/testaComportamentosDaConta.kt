import br.com.chicorialabs.bytebank.dominio.cliente.Cliente
import br.com.chicorialabs.bytebank.dominio.conta.ContaCorrente
import br.com.chicorialabs.bytebank.exception.FalhaAutenticacaoException
import br.com.chicorialabs.bytebank.exception.SaldoInsuficienteException
import java.lang.RuntimeException

fun testaComportamentosDaConta() {

    val contaHan = ContaCorrente(numero = 2001, titular = Cliente(
        nome = "Han Solo",
        cpf = "111.111.111-22",
        senha = 123
    ))
    contaHan.deposita(2000.0)


    val contaKylo = ContaCorrente(titular = Cliente(
        nome = "Kylo Ren",
        cpf = "222.222.222-33",
        senha = 123
    ), 1002)

    contaHan.deposita(1000.0)


    try{

        contaHan.transfere(5000.0, contaKylo, 123)
    } catch (e: FalhaAutenticacaoException){
        println(e.message)
    } catch (e: SaldoInsuficienteException){
        println(e.message)
    } catch (e: Exception){
        println("Ocorreu um erro inesperado")
        e.printStackTrace()
    }



    imprimeDadosDaConta(contaHan)
    imprimeDadosDaConta(contaKylo)

//    contaKylo.saca(600.0, 321)
}