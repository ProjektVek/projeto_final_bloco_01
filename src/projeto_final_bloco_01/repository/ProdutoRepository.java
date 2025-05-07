package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.ProdutoGenerico;

public interface ProdutoRepository {

	public boolean cadastrarProduto(ProdutoGenerico produto);
	public void listarTodosProdutos();
	public void buscarPorID(int id);
	public boolean atualizarProduto(ProdutoGenerico produto);
	public void deletarProduto(int id);
	
}
