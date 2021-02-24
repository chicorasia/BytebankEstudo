fun testaLacos() {
    var i = 0;

    while (i < 5) {

        val titular = "Han Solo $i"
        val numeroConta = 1000 + i

        var saldo = 0.0 + i

        println("titular: $titular \n numero da conta: $numeroConta \n saldo: $saldo \n ***** \n")

        verificaSaldo(saldo)
        i++
    }
}