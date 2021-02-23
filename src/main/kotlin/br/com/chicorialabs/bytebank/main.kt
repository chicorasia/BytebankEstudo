import br.com.chicorialabs.bytebank.legado.Teste
import br.com.chicorialabs.bytebank.legado.teste

fun main() {

    testaTipoFuncaoReferencia()
    testaTipoFuncaoClasse()

    val umaFuncaoLambda: (Int, Int) -> Int = { a, b ->
        a + b
    }

    println(umaFuncaoLambda(10,10))

    val umaFuncaoAnonima: (Int, Int, Int) -> Int  = fun (a, b, _): Int{
        println("executando soma de $a e $b")
        return a + b
    }

    val umaFuncaoAnonimaComTipoImplicito = fun (a: Int, b: Int) : Int {
        return a * b
    }

    println(umaFuncaoLambda(0,0))
    println(umaFuncaoAnonima(15, 20, 10))
    println(umaFuncaoAnonimaComTipoImplicito(8, 3))

}

fun testaTipoFuncaoClasse() {
    val minhaFuncaoClasse: () -> Unit = Teste()
    println(minhaFuncaoClasse())
}

fun testaTipoFuncaoReferencia() {
    val minhaFuncao: () -> Unit = ::teste
    println(minhaFuncao())
}


















