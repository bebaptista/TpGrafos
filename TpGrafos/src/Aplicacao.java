import java.io.BufferedReader;
import java.io.FileReader;

public class Aplicacao {
	
	static Grafo grafo = new Grafo();
	static int matrizDissimilaridade[][];
	
	
	public static void entradaAlunos(String caminho){
		try(BufferedReader br= new BufferedReader(new FileReader(caminho))){
			String leitura,dividido[];
			int aluno,area;
			
			leitura=br.readLine();
			while(leitura!=null){
				dividido=leitura.split(" ");
				aluno=Integer.parseInt(dividido[0]);
				area=Integer.parseInt(dividido[1]);
				Vertice v = new Vertice(aluno,area);
				grafo.listaVertices.add(v);
				leitura=br.readLine();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void entradaDissimilaridade(String caminho){
		try(BufferedReader br= new BufferedReader(new FileReader(caminho))){
			String leitura,dividido[];
			int linha=0;
			
			leitura=br.readLine();
			dividido=leitura.split(" ");
			matrizDissimilaridade=new int[dividido.length][dividido.length];
			while(leitura!=null){
				dividido=leitura.split(" ");
				for(int j=0;j<dividido.length;j++){
					matrizDissimilaridade[linha][j]=Integer.parseInt(dividido[j]);
				}
				leitura=br.readLine();
				linha++;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		entradaDissimilaridade(args[1]);
		entradaAlunos(args[0]);
		grafo.adicionaArestas(matrizDissimilaridade);
		//grafo.imprimeGrafo();
		grafo.ordenaArestas();
		//grafo.imprimeGrafo();
		grafo.kruskal();
		//grafo.imprimeGrafo();
		grafo.divideGrafo(2);
		grafo.imprimeGrafo();
		grafo.separaGrupos();
		grafo.ordenaGrupos();
		grafo.imprimeGrupos();
	}

}
