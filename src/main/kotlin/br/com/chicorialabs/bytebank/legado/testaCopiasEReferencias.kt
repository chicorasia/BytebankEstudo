import br.com.chicorialabs.bytebank.dominio.cliente.Cliente
import br.com.chicorialabs.bytebank.dominio.conta.Conta
import br.com.chicorialabs.bytebank.dominio.conta.ContaCorrente
import br.com.chicorialabs.bytebank.dominio.shared.Endereco

fun testaCopiasEReferencias(contaHan: Conta) {
    val greedo = Cliente(
        "Greedo",
        "444.444.444-55",
        endereco = Endereco(),
        senha = 1234
    )
    var contaGreedo = ContaCorrente(greedo, 1003)
    contaGreedo.titular.nome = "Greedo"

    println("Titular da contaGreedo: ${contaGreedo.titular}")
    println("Titular da contaHan: ${contaHan.titular}")
}