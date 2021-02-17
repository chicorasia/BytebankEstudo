package br.com.chicorialabs.bytebank.dominio.shared

class Endereco(
    var logradouro: String = "",
    var numero: Int = 0,
    var bairro: String = "",
    var cidade: String = "",
    var estado: String = "",
    var cep: String = "",
    var complemento: String = ""
) {

    private constructor(builder: Builder) : this(builder.logradouro, builder.numero,
        builder.bairro, builder.cidade, builder.estado, builder.cep, builder.complemento )

    class Builder {

        var logradouro: String = ""
        var numero: Int = 0
        var bairro: String =""
        var cidade: String = ""
        var estado: String = ""
        var cep: String = ""
        var complemento: String = ""

        fun comLogradouro(logradouro: String) = apply { this.logradouro = logradouro }
        fun comNumero(numero: Int) = apply { this.numero = numero }
        fun comBairro(bairro: String) = apply { this.bairro = bairro }
        fun comCidade(cidade: String) = apply { this.cidade = cidade }
        fun comEstado(estado: String) = apply { this.estado = estado }
        fun comCep(cep: String) = apply { this.cep = cep }
        fun comComplemento(complemento: String) = apply { this.complemento = complemento }

        fun constroi() = Endereco(this)

    }

    override fun toString(): String {
        return """Logradouro='$logradouro', 
numero=$numero, 
bairro='$bairro', 
cidade='$cidade', 
estado='$estado', 
cep='$cep', 
complemento='$complemento'
***""".trimIndent()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Endereco

        if (logradouro != other.logradouro) return false
        if (numero != other.numero) return false
        if (bairro != other.bairro) return false
        if (cidade != other.cidade) return false
        if (estado != other.estado) return false
        if (cep != other.cep) return false
        if (complemento != other.complemento) return false

        return true
    }

    override fun hashCode(): Int {
        var result = logradouro.hashCode()
        result = 31 * result + numero
        result = 31 * result + bairro.hashCode()
        result = 31 * result + cidade.hashCode()
        result = 31 * result + estado.hashCode()
        result = 31 * result + cep.hashCode()
        result = 31 * result + complemento.hashCode()
        return result
    }


}
