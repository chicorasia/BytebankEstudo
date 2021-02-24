package br.com.chicorialabs.bytebank.estudos

import br.com.chicorialabs.bytebank.dominio.shared.Endereco

fun testeHof() {
    Endereco().let {
        println(it)
    }

    teste(
        {
            "Uma String qualquer".let {
                it
            }
        },
        " impressa usando HOF"
    )

    teste({ System.currentTimeMillis().toString() }, " impressa usando HOF")
}

fun teste(block: () -> String, mensagem: String){
    println(block() + mensagem)

}
