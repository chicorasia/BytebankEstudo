package br.com.chicorialabs.bytebank.legado

import java.lang.NumberFormatException

fun testaExpressoes() {
    val valorRecebido: String = "100.0"

    val valorConvertido: Double? = try {
        valorRecebido.toDouble()
    } catch (e: NumberFormatException) {
        null
    }

    val valorComTaxa: Double? = if (valorConvertido != null) {
        valorConvertido + 0.1
    } else {
        null
    }

    println("Valor convertido: $valorConvertido")
    println("Valor com taxa: $valorComTaxa")
}