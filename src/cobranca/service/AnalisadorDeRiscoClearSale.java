package cobranca.service;

import cobranca.exception.RiscoCreditoException;
import cobranca.model.CartaoCredito;
import cobranca.model.Cliente;
import java.time.YearMonth;



public class AnalisadorDeRiscoClearSale implements AutorizadorCartaoCredito {

	private AutorizadorCartaoCredito autorizador;
	
	public AnalisadorDeRiscoClearSale(AutorizadorCartaoCredito autorizador) {
		this.autorizador = autorizador;
	}

	@Override
	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, double valor) {
		if (cliente.getCpf().startsWith("111") || cartaoCredito.getVencimento().isBefore(YearMonth.now())
				|| valor > 500) {
			throw new RiscoCreditoException("Possível fraude, negando pagamento!");
		}
		
		autorizador.autorizar(cliente, cartaoCredito, valor);
	}

}
