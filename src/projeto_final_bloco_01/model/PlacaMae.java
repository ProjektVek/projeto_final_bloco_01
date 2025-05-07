package projeto_final_bloco_01.model;

import java.text.NumberFormat;
import java.util.Locale;

import projeto_final_bloco_01.util.Cores;

public class PlacaMae extends ProdutoGenerico{
	
	// Atributos
	
	private String chipset;
	private String socket;
	
	// Constructor
	
	public PlacaMae(int id, String nome, String marca, int categoria, double preco, String socket, String chipset) {
		super(id, nome, marca, categoria, preco);
		this.socket = socket;
		this.chipset = chipset;
	}

	// Getters e Setters
	
	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}
	
	// Métodos
	@Override
	public void visualizar() {
		
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		
		String categoria = "";
		
		switch(super.getCategoria()) {
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
		System.out.printf("%s║  %sSocket:%s %-41s%s║%n", Cores.corMoldura, Cores.corTextoDestaque, Cores.corTextoNormal, this.getSocket(), Cores.corMoldura);
		System.out.printf("%s║  %sChipset:%s %-40s%s║%n", Cores.corMoldura, Cores.corTextoDestaque, Cores.corTextoNormal, this.getChipset(), Cores.corMoldura);
		System.out.printf("%s║  %sPreço:%s %-42s%s║%n", Cores.corMoldura, Cores.corTextoDestaque, Cores.corTextoNormal, nfMoeda.format(this.getPreco()), Cores.corMoldura);
		System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", Cores.corMoldura);

        
	}
	
	
}
