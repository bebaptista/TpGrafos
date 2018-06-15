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
		System.out.println("Numero de vertices = "+listaVertices.size());
		for(Vertice v : listaVertices){
			v.imprimeVertice();
		}
		System.out.println("Numero de arestas = "+listaArestas.size());
		for(Aresta a : listaArestas){
			a.imprimeAresta();
		}
	}
	
	public void imprimeGrupos(){
		System.out.println("Numero de grupos: "+listaGrupos.size());
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
		if(existeCaminho(la)){
			la.get(la.size()-1).setClassificacao(Classificacao.RETORNO);
		}
		else{
			la.get(la.size()-1).setClassificacao(Classificacao.ARVORE);
		}
	}
	
	public boolean existeCaminho(ArrayList<Aresta> la){
		for(Vertice v: listaVertices){
			v.setColorido(Cor.BRANCO);
		}
		boolean flag = false;
		Vertice inicio,fim,temp;
		ArrayList<Vertice> stack = new ArrayList<Vertice>();
		inicio=la.get(la.size()-1).getAdjacente1();
		fim=la.get(la.size()-1).getAdjacente2();
		for(Aresta a: la.subList(0, la.size()-1)){
			if(a.getAdjacente1().equals(inicio)){
				stack.add(a.getAdjacente2());
			}
			else if(a.getAdjacente2().equals(inicio)){
				stack.add(a.getAdjacente1());
			}
		}
		inicio.setColorido(Cor.PRETO);
		while(!stack.isEmpty()){
			temp=stack.remove(stack.size()-1);
			temp.setColorido(Cor.PRETO);
			for(Aresta a: la.subList(0, la.size()-1)){
				if(flag==true) break;
				if(a.getAdjacente1().equals(temp)){
					if(a.getAdjacente2().equals(fim)){
						flag=true;
					}
					else{
						if(a.getAdjacente2().getColorido()==Cor.BRANCO){
							stack.add(a.getAdjacente2());
							a.getAdjacente2().setColorido(Cor.CINZA);
						}
					}
				}
				else if(a.getAdjacente2().equals(temp)){
					if(a.getAdjacente1().equals(fim)){
						flag=true;
					}
					else{
						if(a.getAdjacente1().getColorido()==Cor.BRANCO){
							stack.add(a.getAdjacente1());
							a.getAdjacente1().setColorido(Cor.CINZA);
						}
					}
				}
			}
		}
		return flag;
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
	
	public void ordenaGrupos(){
		for(Grupo g:listaGrupos){
			g.ordenaGrupo();
		}
	}
	
	public void divideGrafo(int k){
		for(int i=1;i<k;i++){
			listaArestas.remove(listaArestas.size()-1);
		}
	}
	
}
