import java.util.ArrayList;

public class Grupo {
	
	static int contador=1;
	
	private ArrayList<Vertice> grupoPesquisa;
	private int numero;
	
	public Grupo(){
		this.numero=contador++;
		grupoPesquisa = new ArrayList<Vertice>();
	}
	
	public void imprimeGrupo(){
		System.out.println("Grupo "+getNumero());
		for(Vertice v: grupoPesquisa){
			v.imprimeVertice();
		}
	}
	
	public void ordenaGrupo(){
		this.getGrupoPesquisa().sort(null);
	}
	
	public ArrayList<Vertice> getGrupoPesquisa() {
		return grupoPesquisa;
	}

	public void setGrupoPesquisa(ArrayList<Vertice> grupoPesquisa) {
		this.grupoPesquisa = grupoPesquisa;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
