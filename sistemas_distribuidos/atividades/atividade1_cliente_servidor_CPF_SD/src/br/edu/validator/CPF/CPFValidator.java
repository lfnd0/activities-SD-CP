package br.edu.validator.CPF;

public class CPFValidator {

	private static final int[] pesosCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

	private static int calcularDigito(String str, int[] pesos) {
		int sum = 0;
		for (int i = str.length() - 1, digito; i >= 0; i--) {
			digito = Integer.parseInt(str.substring(i, i + 1));
			sum += digito * pesos[pesos.length - str.length() + i];
		}
		sum = 11 - sum % 11;
		return sum > 9 ? 0 : sum;
	}

	public static boolean isValidCPF(String CPF) {
		if ((CPF == null) || CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return false;

		Integer digitoUm = calcularDigito(CPF.substring(0, 9), pesosCPF);
		Integer digitoDois = calcularDigito(CPF.substring(0, 9) + digitoUm, pesosCPF);
		return CPF.equals(CPF.substring(0, 9) + digitoUm.toString() + digitoDois.toString());
	}
}
