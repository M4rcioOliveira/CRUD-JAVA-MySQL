package br.com.estoque.application;

import java.util.Scanner;

import br.com.estoque.dao.ProdutoDAO;
import br.com.estoque.model.Produto;

public class Program {

	public static void main(String[] args) {

		Produto produto = new Produto();

		Scanner sc = new Scanner(System.in);

		int opcao = 0;

		while (opcao != 5) {

			System.out.println("============CADASTRO DE PRODUTOS============");
			System.out.println("|                                          |");
			System.out.println("|          [1] CADASTRAR PRODUTO           |");
			System.out.println("|          [2] LISTAR PRODUTOS             |");
			System.out.println("|          [3] ATUALIZAR PRODUTO           |");
			System.out.println("|          [4] DELETAR PRODUTO             |");
			System.out.println("|                                          |");
			System.out.println("|                [5] SAIR                  |");
			System.out.println("============================================");

			System.out.println("Digite o número da opção: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:

				sc.nextLine();

				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Preço: ");
				double preco = sc.nextDouble();
				System.out.print("Quantidade: ");
				int quantidade = sc.nextInt();

				produto = new Produto(nome, preco, quantidade);

				ProdutoDAO.insert(produto);

				System.out.println("PRESS ENTER TO CONTINUE...");
				sc.nextLine();
				sc.nextLine();

				break;

			case 2:

				for (Produto p : ProdutoDAO.listarProdutos()) {
					System.out.println("Nome: " + p.getNome() + "," + "Preço: " + p.getPreco() + "," + "Quantidade: "
							+ p.getQuantidade());
				}

				System.out.println("PRESS ENTER TO CONTINUE...");
				sc.nextLine();
				sc.nextLine();

				break;

			case 3:

				System.out.println("Informe o id do Produto que deseja Atualizar");

				System.out.print("ID: ");
				int idUpdate = sc.nextInt();

				sc.nextLine();

				System.out.print("Nome: ");
				String nomeUpdate = sc.nextLine();
				System.out.print("Preço: ");
				double precoUpdate = sc.nextDouble();
				System.out.print("Quantidade: ");
				int quantidadeUpdate = sc.nextInt();

				produto = new Produto(nomeUpdate, precoUpdate, quantidadeUpdate);
				ProdutoDAO.update(produto, idUpdate);

				System.out.println("PRESS ENTER TO CONTINUE...");
				sc.nextLine();
				sc.nextLine();

				break;

			case 4:

				System.out.println("Informe o id do Produto que deseja Deletar");

				System.out.print("ID: ");
				int idDelete = sc.nextInt();

				ProdutoDAO.delete(idDelete);

				System.out.println("PRESS ENTER TO CONTINUE...");
				sc.nextLine();
				sc.nextLine();

				break;

			case 5:

				System.out.println("Sistema Finalzado!");

				break;

			default:
				System.out.println("Opção Inválida, tente novamente!");
				System.out.println("PRESS ENTER TO CONTINUE...");
				sc.nextLine();
				sc.nextLine();
				break;
			}

		}

		sc.close();
	}

}
