package br.com.chicorialabs.bytebank.exception

import java.lang.Exception

class FalhaAutenticacaoException(
    message: String = "Falha na autenticacao"
) : Exception(message) {

}
