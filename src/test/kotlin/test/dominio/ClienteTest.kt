package test.dominio

import br.com.chicorialabs.bytebank.dominio.cliente.Cliente
import br.com.chicorialabs.bytebank.dominio.shared.Endereco
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class ClienteTest{

    @Test
    fun deve_CriarUmCliente_AoReceberUmEnderecoVazio(){

        val hanSolo = Cliente(nome = "Han Solo", cpf = "111.111.111-11", Endereco(), senha = 1234)

        assertThat(hanSolo.nome, `is`("Han Solo"))

    }

    @Test
    fun deve_CriarUmEndereco_AoReceberParametrosViaBuilder() {

        var endereco = Endereco.Builder()
            .comLogradouro("Beco dos Contrabandistas")
            .comNumero(765)
            .comCidade("Mos Eisley")
            .comBairro("Spaceport")
            .constroi()

        val hanSolo = Cliente(
            nome = "Han Solo",
            cpf = "111.111.111-11",
            endereco = endereco,
            senha = 1234
        )

        assertThat(hanSolo.endereco.logradouro, `is`("Beco dos Contrabandistas"))
        assertThat(hanSolo.endereco.numero, `is`(765))
    }


}