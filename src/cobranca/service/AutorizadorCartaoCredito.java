package cobranca.service;

import cobranca.model.CartaoCredito;
import cobranca.model.Cliente;



public interface AutorizadorCartaoCredito {

	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, double valor);

}