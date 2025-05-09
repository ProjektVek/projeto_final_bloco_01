package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.PlacaMae;
import projeto_final_bloco_01.model.Processador;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.model.ProdutoGenerico;
import projeto_final_bloco_01.util.Cores;

public class Menu {
	
	
	
	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		ProdutoController produtos = new ProdutoController();
		
		while(true) {
			
			System.out.print(Cores.corBackground);
			System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
			System.out.printf("%s║                                                   ║%n", Cores.corMoldura);
			System.out.printf("%s║%s              Loja de Informática                  %s║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
			System.out.printf("%s║                                                   ║%n", Cores.corMoldura);
			System.out.printf("%s╠═══════════════════════════════════════════════════╣%n", Cores.corMoldura);
			System.out.printf("%s║                                                   ║%n", Cores.corMoldura);
			System.out.printf("%s║%s           %s1%s - Cadastrar Produto                   %s║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque, Cores.corTextoNormal, Cores.corMoldura);
			System.out.printf("%s║%s           %s2%s - Listar Produtos                     %s║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque, Cores.corTextoNormal, Cores.corMoldura);
			System.out.printf("%s║%s           %s3%s - Buscar Produto por Número           %s║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque, Cores.corTextoNormal, Cores.corMoldura);
			System.out.printf("%s║%s           %s4%s - Atualizar Dados do Produto          %s║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque, Cores.corTextoNormal, Cores.corMoldura);
			System.out.printf("%s║%s           %s5%s - Deletar Produto                     %s║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque, Cores.corTextoNormal, Cores.corMoldura);
			System.out.printf("%s║%s           %s0%s - Sair                                %s║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque, Cores.corTextoNormal, Cores.corMoldura);
			System.out.printf("%s║                                                   ║%n", Cores.corMoldura);
			System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);

			
			int opcao = 0, id = 0, categoria = 0;
			String nome = "", marca = "", socket = "", chipset = "";
			double preco;
			
			do {
				
				System.out.printf("%s╔══════════════════════════════╗                     %n", Cores.corMoldura);
				System.out.printf("%s║   %sDigite a opção desejada: %s", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
				opcao = leia.nextInt();
				System.out.printf("%s╚══════════════════════════════╝                     %n", Cores.corMoldura);
				
				if(opcao==0) {
					leia.close();
					finalizar();
				}
					
				
				switch(opcao) {
				case 1:
					System.out.printf("%s╔══════════════════════════════════════╗             %n", Cores.corMoldura);
					System.out.printf("%s║           %sCriar Produto              %s║             %n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
					System.out.printf("%s╠══════════════════════════════════════╣             %n", Cores.corMoldura);
					
					System.out.printf("%s║ %sDigite o nome do produto:%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
					leia.skip("\\R");
					nome = leia.nextLine();
					System.out.printf("%s║ %sDigite a marca do produto:%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
					marca = leia.nextLine();
					System.out.printf("%s║ %sDigite a categoria do produto%s \n", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
					System.out.printf("%s║ %s(1 - Placa-Mãe | 2 - Processador | 3 - Outros):%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
					categoria = leia.nextInt();
					System.out.printf("%s║ %sDigite o preço do produto:%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
					preco = leia.nextDouble();
					
					if(categoria == 1) {
						System.out.printf("%s║ %sDigite o socket:%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
						leia.skip("\\R");
						socket = leia.nextLine();
						
						System.out.printf("%s║ %sDigite o chipset:%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
						chipset = leia.nextLine();
						System.out.printf("%s╚══════════════════════════════════════╝             %n", Cores.corMoldura);
						
						if(produtos.cadastrarProduto(new PlacaMae(produtos.gerarID(), nome, marca, categoria, preco, socket, chipset))) {
							System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
							System.out.printf("%s║        %sProduto Cadastrado com Sucesso!%s            ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
							System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
						}
					} else if(categoria == 2) {
						System.out.printf("%s║ %sDigite o socket:%s \n", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
						leia.skip("\\R");
						socket = leia.nextLine();
						
						System.out.printf("%s╚══════════════════════════════════════╝             %n", Cores.corMoldura);
						if(produtos.cadastrarProduto(new Processador(produtos.gerarID(), nome, marca, categoria, preco, socket))) {
							System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
							System.out.printf("%s║        %sProduto Cadastrado com Sucesso!%s            ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
							System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
						}
					} else if(categoria == 3){
						System.out.printf("%s╚══════════════════════════════════════╝             %n", Cores.corMoldura);
						if(produtos.cadastrarProduto(new Produto(produtos.gerarID(), nome, marca, categoria, preco))) {
							System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
							System.out.printf("%s║        %sProduto Cadastrado com Sucesso!%s            ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
							System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
						}
					} else {
						System.out.printf("%s╚══════════════════════════════════════╝             %n", Cores.corMoldura);
						System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
						System.out.printf("%s║        %sCategoria inválida!%s             ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
						System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
					}
					
					keyPress();
					break;

				case 2:
					System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
					System.out.printf("%s║               %sListar todos os Produtos            %s║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
					System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
					
					produtos.listarTodosProdutos();
					
					keyPress();
					break;

				case 3:
					System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
					System.out.printf("%s║              %sConsultar Produto por id%s             ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
					System.out.printf("%s╠═══════════════════════════════════════════════════╣%n", Cores.corMoldura);
					System.out.printf("%s║ %sDigite o id do Produto:%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
					id = leia.nextInt();
					System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
					
					produtos.buscarPorID(id);
					
					keyPress();
					break;

				case 4:
					System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
					System.out.printf("%s║                   %sAtualizar Produto%s               ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
					System.out.printf("%s╠═══════════════════════════════════════════════════╣%n", Cores.corMoldura);
					System.out.printf("%s║ %sDigite o id do Produto:%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
					id = leia.nextInt();
					
					System.out.printf("%s║ %sDigite o nome do produto:%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
					leia.skip("\\R");
					nome = leia.nextLine();
					System.out.printf("%s║ %sDigite a marca do produto:%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
					marca = leia.nextLine();
					System.out.printf("%s║ %sDigite a categoria do produto%s \n", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
					System.out.printf("%s║ %s(1 - Placa-Mãe | 2 - Processador | 3 - Outros):%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
					categoria = leia.nextInt();
					System.out.printf("%s║ %sDigite o preço do produto:%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
					preco = leia.nextDouble();
					
					if(categoria == 1) {
						System.out.printf("%s║ %sDigite o socket:%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
						leia.skip("\\R");
						socket = leia.nextLine();
						
						System.out.printf("%s║ %sDigite o chipset:%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
						chipset = leia.nextLine();
						System.out.printf("%s╚══════════════════════════════════════╝             %n", Cores.corMoldura);
						
						produtos.atualizarProduto(new PlacaMae(id, nome, marca, categoria, preco, socket, chipset));
					} else if(categoria == 2) {
						System.out.printf("%s║ %sDigite o socket:%s \n", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
						leia.skip("\\R");
						socket = leia.nextLine();
						
						System.out.printf("%s╚══════════════════════════════════════╝             %n", Cores.corMoldura);
						produtos.atualizarProduto(new Processador(id, nome, marca, categoria, preco, socket));
					} else if(categoria == 3){
						System.out.printf("%s╚══════════════════════════════════════╝             %n", Cores.corMoldura);
						produtos.atualizarProduto(new Produto(id, nome, marca, categoria, preco));
					} else {
						System.out.printf("%s╚══════════════════════════════════════╝             %n", Cores.corMoldura);
						System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
						System.out.printf("%s║        %sCategoria inválida!%s             ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
						System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
					}
					System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
					
					keyPress();
					break;

				case 5:
					System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
					System.out.printf("%s║                 %sDeletar o Produto%s                  ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
					System.out.printf("%s╠═══════════════════════════════════════════════════╣%n", Cores.corMoldura);
					System.out.printf("%s║ %sDigite o id do Produto:%s ", Cores.corMoldura, Cores.corTextoNormal, Cores.corTextoDestaque);
					id = leia.nextInt();
					System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
					
					produtos.deletarProduto(id);
					
					keyPress();
					break;

				default:
					System.out.printf("%s╔══════════════════════════════════════╗             %n", Cores.corMoldura);
					System.out.printf("%s║  %sOpção inválida! Digite novamente!   %s║             %n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
					System.out.printf("%s╚══════════════════════════════════════╝             %n", Cores.corMoldura);
					keyPress();
					break;

				}
				
			} while(opcao<1||opcao>9);	
		}
		
	}
	
	
	
	public static void sobre() {
		
		System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
		System.out.printf("%s║                                                   ║%n", Cores.corMoldura);
		System.out.printf("%s║  %sProjeto Desenvolvido Por:%s                        ║%n", Cores.corMoldura, Cores.corTextoDestaque, Cores.corMoldura);
		System.out.printf("%s║                                                   ║%n", Cores.corMoldura);
		System.out.printf("%s║  Victor Hugo Souza Ferreira                       ║%n", Cores.corMoldura);
		System.out.printf("%s║  %sEmail:%s victor.sz.ferreira@gmail.com%s              ║%n", Cores.corMoldura, Cores.corTextoDestaque, Cores.corTextoNormal, Cores.corMoldura);
		System.out.printf("%s║  %sGitHub:%s https://github.com/ProjektVek%s            ║%n", Cores.corMoldura, Cores.corTextoDestaque, Cores.corTextoNormal, Cores.corMoldura);
		System.out.printf("%s║                                                   ║%n", Cores.corMoldura);
		System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);

		
	}
	
	public static void keyPress() {
		
		try {
			System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
			System.out.printf("%s║        %sPressione Enter para Continuar...%s          ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
			System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
			System.in.read();
		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao ler o teclado!");
		}
	}
	
	public static void finalizar() {
		
		System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
		System.out.printf("%s║                                                   ║%n", Cores.corMoldura);
		System.out.printf("%s║             %sObrigado pela Preferência!            %s║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
		System.out.printf("%s║                                                   ║%n", Cores.corMoldura);
		System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);

		
		sobre();
		
		System.exit(0);
	}

}
