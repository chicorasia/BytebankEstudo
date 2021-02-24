package br.com.chicorialabs.bytebank.estudos

fun testaFuncaoLambda() {
    val umaFuncaoLambda: (Int, Int) -> Int = { a, b ->
        a + b
    }

    val calculaBonificacao: (salario: Double) -> Double = lambda@{ salario ->
        if (salario > 1000.0) {
            return@lambda salario + 50.0
        }
        return@lambda salario + 100.0

    }

    println(umaFuncaoLambda(10, 10))
    println(umaFuncaoLambda(0, 0))
    println(calculaBonificacao(1000.0))
}

fun testaFuncaoAnonima() {
    val umaFuncaoAnonima: (Int, Int, Int) -> Int = fun(a, b, _): Int {
        println("executando soma de $a e $b")
        return a + b
    }

    val umaFuncaoAnonimaComTipoImplicito = fun(a: Int, b: Int): Int {
        return a * b
    }
    val calculaBonificacaoAnonima: (salario: Double) -> Double =
        lambda@ fun(salario): Double {
            if (salario > 1000.0) {
                return@lambda salario + 50.0
            }
            return@lambda salario + 100.0

        }

    println(umaFuncaoAnonima(15, 20, 10))
    println(umaFuncaoAnonimaComTipoImplicito(8, 3))
    println(calculaBonificacaoAnonima(1001.0))
}

fun testaTipoFuncaoClasse() {
    val minhaFuncaoClasse: () -> Unit = Teste()
    println(minhaFuncaoClasse())
}

fun testaTipoFuncaoReferencia() {
    val minhaFuncao: () -> Unit = ::teste
    println(minhaFuncao())
}