package br.com.vitor.calculadora.modelo;

@FunctionalInterface
public interface Observe {

	void atualizarDisplay(String numero);
}
