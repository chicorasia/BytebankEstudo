package br.com.chicorialabs.bytebank.estudos

import br.com.chicorialabs.bytebank.dominio.shared.Endereco

fun testeException() {
    println("inicio main")
//    funcao1()
//    testaComportamentosDaConta()

    val endereco: Endereco? = Endereco(logradouro = "Rua do Herval")
    var logradouroNovo: String = "Rua Gervais"
    endereco?.logradouro = logradouroNovo
    endereco.let { endereco: Endereco? ->
        println(endereco?.logradouro)
        val tamanhoComplemento: Int? = endereco?.complemento?.length ?: 100
        println(tamanhoComplemento)
    }



    println("fim main")
}


fun funcao2() {
    println("início função 2")
    try{
        val endereco = Any()
        throw ClassCastException("Não pode converter Any em Endereco!!!")

    } catch (e: ClassCastException){
        println(e.message)
        println("A ClassCastException foi pega!")
    }
    println("fim função 2")
}

fun funcao1(){
    println("início função 1")
    funcao2()
    println("fim função 1")
}