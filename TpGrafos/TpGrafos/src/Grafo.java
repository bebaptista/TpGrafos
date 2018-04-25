import java.util.ArrayList;

public class Grafo {
	
	ArrayList<Vertice> listaVertices;
	ArrayList<Aresta> listaArestas;
	ArrayList<Grupo> listaGrupos;
	
	public Grafo(){
		listaVertices=new ArrayList<Vertice>();
		listaArestas=new ArrayList<Aresta>();
		listaGrupos=new ArrayList<Grupo>();
	}
	
	public void imprimeGrafo(){
		for(Vertice v : listaVertices){
			v.imprimeVertice();
		}
		for(Aresta a : listaArestas){
			a.imprimeAresta();
		}
	}
	
	public void imprimeGrupos(){
		System.out.println(listaGrupos.size());
		for(Grupo g:listaGrupos){
			g.imprimeGrupo();
		}
	}
	
	public void adicionaArestas(int matrizDissimilaridade[][]){
		for(Vertice v1: listaVertices) {
			for(Vertice v2: listaVertices.subList(listaVertices.indexOf(v1), listaVertices.size())){
				if(!v1.equals(v2)){
					Aresta a1 = new Aresta(matrizDissimilaridade[v1.getAreaEstudo()-1][v2.getAreaEstudo()-1],v1,v2);
					listaArestas.add(a1);
				}
			}
			
		}
	}
	
	public void ordenaArestas(){
		listaArestas.sort(null);
	}
	
	public void kruskal(){
		ArrayList<Aresta> aux = new ArrayList<Aresta>();
		for(Aresta a : listaArestas){
			aux.add(a);
			if(existeCiclo(aux)){
				aux.remove(aux.size()-1);
			}
			if(aux.size()==listaVertices.size()-1) break;
		}
		listaArestas=aux;
	}
	
	public boolean existeCiclo(ArrayList<Aresta> la){
		classificaAresta(la);
		if(la.get(la.size()-1).getClassificacao()==Classificacao.RETORNO) return true;
		else return false;
	}
	
	public void classificaAresta(ArrayList<Aresta> la){
		if(la.get(la.size()-1).getAdjacente1().getColorido()==Cor.BRANCO||la.get(la.size()-1).getAdjacente2().getColorido()==Cor.BRANCO){
			la.get(la.size()-1).getAdjacente1().setColorido(Cor.CINZA);
			la.get(la.size()-1).getAdjacente2().setColorido(Cor.CINZA);
			la.get(la.size()-1).setClassificacao(Classificacao.ARVORE);
		}
		else if(la.get(la.size()-1).getAdjacente1().getColorido()==Cor.CINZA&&la.get(la.size()-1).getAdjacente2().getColorido()==Cor.CINZA){
			la.get(la.size()-1).setClassificacao(Classificacao.RETORNO);
		}
	}
	
	public void separaGrupos(){
		ArrayList<Vertice> aux = new ArrayList<Vertice>();
		Vertice temp;
		Grupo g = null;
		for(Vertice v: listaVertices){
			v.setColorido(Cor.BRANCO);
		}
		for(Vertice v: listaVertices){
			if(v.getColorido()==Cor.BRANCO){
				g = new Grupo();
				g.getGrupoPesquisa().add(v);
				v.setColorido(Cor.PRETO);
				for(Aresta a: listaArestas){
					if(v==a.getAdjacente1()){
						a.getAdjacente2().setColorido(Cor.CINZA);
						aux.add(a.getAdjacente2());
					}
					else if(v==a.getAdjacente2()){
						a.getAdjacente1().setColorido(Cor.CINZA);
						aux.add(a.getAdjacente1());
					}
				}
				while(!aux.isEmpty()){
					temp=aux.remove(0);
					temp.setColorido(Cor.PRETO);
					g.getGrupoPesquisa().add(temp);
					for(Aresta a: listaArestas){
						if(temp==a.getAdjacente1()){
							if(a.getAdjacente2().getColorido()==Cor.BRANCO){
								a.getAdjacente2().setColorido(Cor.CINZA);
								aux.add(a.getAdjacente2());
							}
						}
						else if(temp==a.getAdjacente2()){
							if(a.getAdjacente1().getColorido()==Cor.BRANCO){
								a.getAdjacente1().setColorido(Cor.CINZA);
								aux.add(a.getAdjacente1());
							}
						}
					}
				}
				listaGrupos.add(g);
			}
		}
	}
	
	public void divideGrafo(int k){
		for(int i=1;i<k;i++){
			listaArestas.remove(listaArestas.size()-1);
		}
	}
	
}
