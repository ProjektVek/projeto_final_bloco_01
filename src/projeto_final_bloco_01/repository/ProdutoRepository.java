package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.ProdutoGenerico;

public interface ProdutoRepository {

	public void cadastrarProduto(ProdutoGenerico produto);
	public void listarTodosProdutos();
	public void buscarPorID();
	public void atualizarProduto();
	public void deletarProduto();
	
}
