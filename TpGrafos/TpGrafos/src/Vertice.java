
public class Vertice {
	
	private int aluno;
	private int areaEstudo;
	private Cor colorido;
	
	
	public Vertice(int aluno,int area){
		this.aluno=aluno;
		this.areaEstudo=area;
		this.colorido=Cor.BRANCO;
	}
	
	public void imprimeVertice(){
		System.out.print("Aluno:"+this.aluno);
		System.out.println(" Area de estudo:"+this.areaEstudo);
	}
	
	public int getAluno() {
		return aluno;
	}
	public void setAluno(int aluno) {
		this.aluno = aluno;
	}

	public int getAreaEstudo() {
		return areaEstudo;
	}

	public void setAreaEstudo(int areaEstudo) {
		this.areaEstudo = areaEstudo;
	}

	public Cor getColorido() {
		return colorido;
	}

	public void setColorido(Cor colorido) {
		this.colorido = colorido;
	}
}
