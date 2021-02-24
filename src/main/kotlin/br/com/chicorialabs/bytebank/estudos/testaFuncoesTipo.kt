package br.com.chicorialabs.bytebank.estudos

import br.com.chicorialabs.bytebank.dominio.cliente.Cliente


fun testaFuncoesTipoReferenciaEClasse() {
    testaTipoFuncaoReferencia()
//    println("Invocando a função: ${minhaFuncao()}")
//
    testaTipoFuncaoClasse()

    val somaInt: (Int, Int) -> Double = Soma()
    val somaDouble: (Double, Double) -> Double = Soma()
    val somaQualquerNumber: (Number, Number) -> Double = Soma()
    println(somaInt(10, 20))
    println(somaDouble(10.0, 30.0))
    println(somaQualquerNumber(35.0, 0b1111))


    val autenticacao: (Int, Cliente) -> Boolean = ::autentica

    val clienteQualquer = Cliente(nome = "Jack", senha = 1000, cpf = "")
    println(autenticacao(1000, clienteQualquer))
}



fun autentica(senha: Int, cliente: Cliente) : Boolean {
    return cliente.autentica(senha)
}

class Teste : () -> Unit {
    override fun invoke() {
        println("executa invoke do teste")
    }

}

fun teste() {
    println("rodando a função teste")
}

class Soma : (Number, Number) -> Double {
//    override fun invoke(p1: Int, p2: Int): Double {
//        return (p1 + p2).toDouble()
//    }

    override fun invoke(p1: Number, p2: Number): Double {
        return (p1.toDouble() + p2.toDouble())
    }



}

