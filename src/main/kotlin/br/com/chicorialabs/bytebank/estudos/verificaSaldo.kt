fun verificaSaldo(saldo: Double) {
    when {
        saldo > 0.0 -> println("O saldo é positivo")
        saldo == 0.0 -> println("Saldo zerado")
        else -> println("O saldo é negativo!")
    }
}