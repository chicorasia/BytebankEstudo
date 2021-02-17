import br.com.chicorialabs.bytebank.dominio.conta.Conta

fun imprimeDadosDaConta(conta: Conta) {
    println(
        "titular: ${conta.titular.nome} " +
                "\n numero da conta: ${conta.numero} " +
                "\n" +
                " saldo: ${conta.saldo} \n ***** \n"
    )
}