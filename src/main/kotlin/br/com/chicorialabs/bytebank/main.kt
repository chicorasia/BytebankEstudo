import br.com.chicorialabs.bytebank.dominio.cliente.Cliente
import br.com.chicorialabs.bytebank.dominio.conta.ContaPoupanca
import br.com.chicorialabs.bytebank.dominio.shared.Endereco
import br.com.chicorialabs.bytebank.estudos.testaObjectExpressionComInterface
import kotlin.math.pow
import java.lang.Math.pow as pow

fun main() {

    testaObjectExpressionComInterface()

}

fun testaRun() {
    val taxaAnual = 0.05
    val taxaMensal = converteTaxaAnualEmMensal(taxaAnual)

    val contaPoupanca = Cliente(nome = "Jack Sparrow", cpf = "000.000.000-00", senha = 1234)
        .let { clienteNovo ->
            ContaPoupanca(clienteNovo, 1000)
        }

    contaPoupanca.run {
        run {
            deposita(1000.0)
            repeat(12) {
                deposita(saldo * taxaMensal)
            }
        }.also {
            println("Saldo ao final de 12 meses: $saldo")
        }
    }
}

fun converteTaxaAnualEmMensal(taxaAnual: Double): Double {
    return (1.0 + taxaAnual).pow((1.0 / 12.0)) -1
}

fun testaWith() {
    val enderecoCompleto = with(Endereco()) {
        logradouro = "Rua dos Bobos"
        numero = 0
        complemento = "casa"
        cep = "80000-000"
        bairro = "Arca de Noé"
        cidade = "Rio de Janeiro"
        estado = "RJ"
        completo()
    }.let(::println)
}






















