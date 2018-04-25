import java.util.ArrayList;

public class Grafo {
	
	ArrayList<Vertice> listaVertices;
	ArrayList<Aresta> listaArestas;
	
	public Grafo(){
		listaVertices=new ArrayList<Vertice>();
		listaArestas=new ArrayList<Aresta>();
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
		
	}
	
	public void adicionaArestas(int matrizDissimilaridade[][]){
		for(Vertice v1: listaVertices) {
			for(Vertice v2: listaVertices.subList(listaVertices.indexOf(v1), listaVertices.size())){
				if(!v1.equals(v2)){
					Aresta a1 = new Aresta(matrizDissimilaridade[v1.getArea()-1][v2.getArea()-1],v1,v2);
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
		return false;
	}
	
	public void buscaEmProfundidade(){
		
	}
	
	public void divideGrafo(int k){
		for(int i=1;i<k;i++){
			listaArestas.remove(listaArestas.size()-1);
		}
	}
	
}
