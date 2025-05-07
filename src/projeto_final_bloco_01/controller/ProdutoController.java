package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Optional;

import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.model.ProdutoGenerico;
import projeto_final_bloco_01.repository.ProdutoRepository;
import projeto_final_bloco_01.util.Cores;

public class ProdutoController implements ProdutoRepository {
	
	private ArrayList<ProdutoGenerico> produtos = new ArrayList<ProdutoGenerico>();
	private int contagemID = 0;

	@Override
	public boolean cadastrarProduto(ProdutoGenerico produto) {
		try {
			produtos.add(produto);
			return true;
		} catch(Exception e) {
			System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
			System.out.printf("%s║              %sErro ao Cadastrar Produto    %s       ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
			System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
		}
		return false;
	}

	@Override
	public void listarTodosProdutos() {
		System.out.println(produtos);
		if(produtos.isEmpty()) {
			System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
			System.out.printf("%s║              %sNenhum produto encontrado!       %s    ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
			System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
		} else {
			for(var produto : produtos) {
				produto.visualizar();
			}
		}
	}

	@Override
	public void buscarPorID(int id) {
		Optional<ProdutoGenerico> produto = buscarNaCollection(id);
		
		if(produto.isPresent())
			produto.get().visualizar();
		else {
			System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
			System.out.printf("%s║        %sO Produto não foi encontrado!%s             ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
			System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
		}
		
	}

	@Override
	public void atualizarProduto(ProdutoGenerico produto) {
		
		Optional<ProdutoGenerico> buscaProduto = buscarNaCollection(produto.getId());
		
		if(buscaProduto.isPresent()) {
			produtos.set(produtos.indexOf(buscaProduto.get()), produto);
			
			System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
			System.out.printf("%s║        %sO produto foi atualizado com sucesso!   %s   ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
			System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
		} else {
			System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
			System.out.printf("%s║        %sO produto não foi encontado!          %s     ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
			System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
		}
		
	}

	@Override
	public void deletarProduto(int id) {
		Optional<ProdutoGenerico> produto = buscarNaCollection(id);
		
		if(produto.isPresent()) {
			if(produtos.remove(produto.get()) == true) {
				System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
				System.out.printf("%s║        %sO produto foi deletado com sucesso!   %s     ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
				System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
			}
		} else {
				System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
				System.out.printf("%s║        %sO produto não foi encontado!          %s     ║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
				System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);
		}
	}
	
	public int gerarID() {
		return ++contagemID;
	}
	
	public Optional<ProdutoGenerico> buscarNaCollection(int Id) {
		for(var produto: produtos) {
			if(produto.getId() == Id)
				return Optional.of(produto);
		}
		
		return Optional.empty();
	}

}
