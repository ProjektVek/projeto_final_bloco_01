package projeto_final_bloco_01.model;

import java.text.NumberFormat;
import java.util.Locale;

import projeto_final_bloco_01.util.Cores;

public abstract class ProdutoGenerico {

	// Atributos
	
	private int id;
	private String nome;
	private String marca;
	private int categoria;
	private double preco;
	
	// Constructor
	
	public ProdutoGenerico(int id, String nome, String marca, int categoria, double preco) {
		
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.categoria = categoria;
		this.preco = preco;
		
	}

	// Getters e Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	// Métodos
	
	public void visualizar() {
		
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		
		String categoria = "";
		
		switch(this.categoria) {
		case 1 -> categoria = "Placa-mãe";
		case 2 -> categoria = "Processador";
		case 3 -> categoria = "Outros";
		default -> categoria = "Inválido";
		}
		
		System.out.print(Cores.corBackground);
		System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", Cores.corMoldura);
		System.out.printf("%s║               %sDADOS DO PRODUTO%27s║%n", Cores.corMoldura, Cores.corTextoNormal, Cores.corMoldura);
		System.out.printf("%s╠═══════════════════════════════════════════════════╣%n", Cores.corMoldura);
		System.out.printf("%s║  %sID:%s %-45d%s║%n", Cores.corMoldura, Cores.corTextoDestaque, Cores.corTextoNormal, this.getId(), Cores.corMoldura);
		System.out.printf("%s║  %sNome:%s %-43s%s║%n", Cores.corMoldura, Cores.corTextoDestaque, Cores.corTextoNormal, this.getNome(), Cores.corMoldura);
		System.out.printf("%s║  %sMarca:%s %-42s%s║%n", Cores.corMoldura, Cores.corTextoDestaque, Cores.corTextoNormal, this.getMarca(), Cores.corMoldura);
		System.out.printf("%s║  %sCategoria:%s %-38s%s║%n", Cores.corMoldura, Cores.corTextoDestaque, Cores.corTextoNormal, categoria, Cores.corMoldura);
		System.out.printf("%s║  %sPreço:%s %-42s%s║%n", Cores.corMoldura, Cores.corTextoDestaque, Cores.corTextoNormal, nfMoeda.format(this.getPreco()), Cores.corMoldura);
		System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);

        
	}
	
	
}
