package loja;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Sistema {
	
	private ArrayList<Produto> produtos;

	public Sistema() {
		this.produtos = new ArrayList<Produto>();
	}

	public void cadastrarProduto(Scanner scanner) {
		System.out.println("Cadastrando produto!");
		System.out.println("Digite o nome do produto:");
		String nome = scanner.nextLine();

		int codigo = -1;
		try {
			codigo = ExceptionHandler.readCode(scanner);
		} catch (InputMismatchException e) {
			scanner.nextLine();
			System.out.println("O código do produto deve ser um número inteiro.");
			return;
		}

		System.out.println("Digite o preço do produto:");
		double preco = scanner.nextDouble();

		System.out.println("Digite a opção que você quer cadastrar");
		System.out.println("1- Móvel");
		System.out.println("2- Eletrodoméstico");
		int opcao = scanner.nextInt();
		scanner.nextLine();

		switch (opcao) {
			case 1:
				cadastrarMovel(scanner, nome, codigo, preco);
				break;
			case 2:
				cadastrarEletro(scanner, nome, codigo, preco);
				break;
			default:
				break;
		}
	}

	private void cadastrarMovel(Scanner scanner, String nome, int codigo, double preco) {
		System.out.println("Digite o material do móvel:");
		String material = scanner.nextLine();

		try {
			Movel movel = new Movel(nome, codigo, preco, material);
			produtos.add(movel);
		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao cadastrar móvel: " + e.getMessage());
		}
	}

	private void cadastrarEletro(Scanner scanner, String nome, int codigo, double preco) {
		System.out.println("Digite a voltagem:");
		int voltagem = scanner.nextInt();

		try {
			Eletro eletro = new Eletro(nome, codigo, preco, voltagem);
			produtos.add(eletro);
		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao cadastrar eletrodoméstico: " + e.getMessage());
		}
	}

	public void listar() {
		if(produtos.size() == 0) {
			System.out.println("Nenhum produto cadastrado!");
		}else {
			for (Produto produto : produtos) {
				System.out.println(produto);
			}
		}	
	}
	
	public Produto buscar(Scanner scanner) {
		System.out.println("Digite um código");
		int codigoProcurado = scanner.nextInt();
		for (Produto produto : produtos) {
			if(produto.getCod() == codigoProcurado) {
				System.out.println("Produto cadastrado");
				System.out.println(produto);
				return produto;
			}
		}
		System.out.println("Produto não cadastrado!");
		return null;	
	}
	
	public void remover(Scanner scanner) {
		System.out.println("Digite um código");
		int codigoProcurado = scanner.nextInt();
		
		for(int i =0; i <= produtos.size()-1; i++) {
			if(produtos.get(i).getCod() == codigoProcurado) {
				produtos.remove(i);
				return;
			}
		}
		System.out.println("Produto nao cadastrado!");	
	}
}
