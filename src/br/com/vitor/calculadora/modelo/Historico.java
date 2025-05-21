package br.com.vitor.calculadora.modelo;

import java.util.ArrayList;
import java.util.List;

public class Historico {

	private enum TipoDado {
		NUMERO, DIVISAO, MULTIPLICACAO, SOMA, SUBTRACAO, APAGAR, VIRGULA, RESULTADO
	}

	private static final Historico objetoHistorico = new Historico();

	private List<Observe> observe = new ArrayList<>();

	private TipoDado operador = null;
	private static boolean substituir = false;
	private static String numeroBuffer = "";
	private static String numeroAtual = "";

	private Historico() {

	}

	public void registrarObserve(Observe o) {
		observe.add(o);
	}

	public String getNumeroAtual() {
		return numeroAtual.isEmpty() ? "0" : numeroAtual;
	}

	public void gerarEvento(String valor) {

		TipoDado dado = verificarTipo(valor);

		if (dado == null) {
			return;
		} else if (dado == TipoDado.APAGAR) {
			numeroAtual = "";
			numeroBuffer = "";
			substituir = false;
			operador = null;
		} else if (dado == TipoDado.NUMERO || dado == TipoDado.VIRGULA) {
			numeroAtual = substituir ? valor : numeroAtual + valor;
			substituir = false;
		}
		else {
			substituir = true;
			numeroAtual = resultadoOperacao();
			numeroBuffer = numeroAtual;
			operador = dado;
		}

		observe.forEach(x -> x.atualizarDisplay(getNumeroAtual()));

	}

	private String resultadoOperacao() {
		if (operador == null || operador == TipoDado.RESULTADO) {
			return numeroAtual;
		}
		
		double num = Double.parseDouble(numeroBuffer.replace(",", "."));
		double num2 = Double.parseDouble(numeroAtual.replace(",", "."));
		double resultado = 0;
		
		if(operador == TipoDado.SOMA) {
			resultado =  num + num2;
		}
		else if(operador == TipoDado.SUBTRACAO) {
			resultado =  num - num2;
		}
		else if(operador == TipoDado.MULTIPLICACAO) {
			resultado =  num * num2;
		}
		else if(operador == TipoDado.DIVISAO) {
			resultado = num / num2;
		}
		
		String resultadoString = Double.toString(resultado).replace(".", ",");
		boolean isInteiro = resultadoString.endsWith(",0");
		return isInteiro ? resultadoString.replace(",0", "") : resultadoString;
		
	}

	private TipoDado verificarTipo(String valor) {

		if (numeroAtual.isEmpty() && valor == "0") {
			return null;
		}

		try {
			Integer.parseInt(valor);
			return TipoDado.NUMERO;
		} catch (Exception e) {
			if (valor.equals("AC")) {
				return TipoDado.APAGAR;
			} else if (valor.equals("/")) {
				return TipoDado.DIVISAO;
			} else if (valor.equals("*")) {
				return TipoDado.MULTIPLICACAO;
			} else if (valor.equals("-")) {
				return TipoDado.SUBTRACAO;
			} else if (valor.equals("+")) {
				return TipoDado.SOMA;
			} else if (valor.equals("=")) {
				return TipoDado.RESULTADO;
			} else if (valor.equals(",") && !numeroAtual.contains(",")) {
				return TipoDado.VIRGULA;
			} else {
				return null;
			}
		}

	}

	public static Historico getObjetohistorico() {
		return objetoHistorico;
	}

}
