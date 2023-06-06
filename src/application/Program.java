package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuintes;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Contribuintes> list = new ArrayList<>();

		System.out.print("Digite o número de contribuintes: ");
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			System.out.println("Dados do contribuinte nº" + i + ": ");
			System.out.print("Pessoa física ou jurídica (f/j)? ");
			char resp = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Renda anual: ");
			double renda = sc.nextDouble();
			if (resp == 'f') {
				System.out.print("Despesas com saude: ");
				double despesa = sc.nextDouble();
				list.add(new PessoaFisica(nome, renda, despesa));
			} else {
				System.out.print("Numero de funcionarios: ");
				int funcionario = sc.nextInt();
				list.add(new PessoaJuridica(nome, renda, funcionario));
			}
		}

		double sum = 0.0;

		System.out.println();
		System.out.println("IMPOSTOS PAGOS: ");
		for (Contribuintes cont : list) {
			System.out.println(cont.getNome() + " R$ " + String.format("%.2f", cont.imposto()));
			sum += cont.imposto();
		}
		System.out.println();
		System.out.println("IMPOSTO TOTAL: R$ " + String.format("%.2f", sum));

		sc.close();

	}

}
