
public class Aresta implements Comparable<Aresta>{
	
	private int peso;
	private Classificacao classificacao;
	private Vertice adjacente1;
	private Vertice adjacente2;

	public Aresta(int peso,Vertice v1,Vertice v2){
		this.peso=peso;
		this.setAdjacente1(v1);
		this.setAdjacente2(v2);
		this.setClassificacao(Classificacao.SEM_CLASSIFICACAO);
	}
	
	public void imprimeAresta(){
		System.out.print(peso+" ");
		System.out.print(adjacente1.getAluno()+"-");
		System.out.print(adjacente2.getAluno()+" ");
		System.out.println(getClassificacao());
	}
	
	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Vertice getAdjacente1() {
		return adjacente1;
	}

	public void setAdjacente1(Vertice ligado) {
		this.adjacente1 = ligado;
	}

	public Vertice getAdjacente2() {
		return adjacente2;
	}

	public void setAdjacente2(Vertice adjacente) {
		this.adjacente2 = adjacente;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	@Override
	public int compareTo(Aresta a) {
		if(this.getPeso()<a.getPeso()) return -1;
		else if(this.getPeso()>a.getPeso()) return 1;
		else return 0;
	}
}
