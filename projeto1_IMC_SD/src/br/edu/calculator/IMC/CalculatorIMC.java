package br.edu.calculator.IMC;

public class CalculatorIMC {

	public static double calcularIMC(double altura, double peso) {
		return peso / (Math.pow(altura, 2));
	}

	public static String interpretarResultadoIMC(double altura, double peso) {
		double IMC = calcularIMC(altura, peso);

		if (IMC <= 18.5) {
			return "Valor do IMC: " + String.format("%.2f", IMC) + " | Status do IMC: magreza";

		} else if ((IMC > 18.5) && (IMC <= 24.9)) {
			return "Valor do IMC: " + String.format("%.2f", IMC) + " | Status do IMC: normal";

		} else if ((IMC > 25.0) && (IMC <= 29.9)) {
			return "Valor do IMC: " + String.format("%.2f", IMC) + " | Status do IMC: sobrepeso";

		} else if ((IMC > 30.0) && (IMC <= 39.9)) {
			return "Valor do IMC: " + String.format("%.2f", IMC) + " | Status do IMC: obesidade";

		} else if (IMC > 40.0) {
			return "Valor do IMC: " + String.format("%.2f", IMC) + " | Status do IMC: obesidade grave";
		}

		return "";
	}

	public static void main(String[] args) {
		System.out.println(interpretarResultadoIMC(1.60, 42));
	}
}