package cobranca.service;

import cobranca.model.CartaoCredito;
import cobranca.model.Cliente;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;



public class AutorizadorCielo implements AutorizadorCartaoCredito {
	
	@Override
	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, double valor) {
		try (PrintStream writer = new PrintStream(new FileOutputStream("debitos.txt", true))) {
			writer.println(cliente + " | " + cartaoCredito + " | R$" + valor);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Impossível salvar arquivo", e);
		}
	}

}
