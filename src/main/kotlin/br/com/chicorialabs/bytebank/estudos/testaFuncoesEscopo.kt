package br.com.chicorialabs.bytebank.estudos

import br.com.chicorialabs.bytebank.dominio.shared.Endereco

fun testaFuncoesEscopo() {
    Crianca("Julia", 6).let {
        it.apply { idade = 10 }.let(::println)
        it.run { (idade + 10).let(::println) }
    }


    val bia = Crianca("Bia", 12).also { println(it) }

    var idadeNoAnoQueVem = with(bia) {
        this.fazAniversario()
        idade
    }

    println(idadeNoAnoQueVem)
}

fun soma(a: Int, b: Int, resultado: (Int) -> Unit): Unit{
    println("calculando a soma")
    resultado(a + b)
    println("soma executada")

}

fun somaComReceiver(a: Int, b: Int, resultado: Int.() -> Int): Unit{
    println("calculando a soma")
    val valor = a + b
    resultado(valor)
    println("soma executada")

}


fun testaLet() {
    Endereco(logradouro = "Rua do Herval",
        numero = 611,
        complemento = "Ap 203").run {
        "$logradouro, $numero, $complemento".toUpperCase()
    }.let(::println)

//    val listaEnderecos = listOf<Endereco>(
//        Endereco(cep = "80050-205"),
//        Endereco(),
//        Endereco(cep = "80040-700")
//    )
//
//    listaEnderecos.filter { it.cep.isNotEmpty() }.let(::println)
}

data class Crianca(val nome: String, var idade: Int, var birra: Boolean = false){

    fun fazAniversario() { idade++ }

    fun alternaBirra() {
        birra = !birra
        if (birra) println("$nome está fazendo birra!")
        else println("Acabou a birra!")
    }


}