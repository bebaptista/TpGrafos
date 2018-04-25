
public class Vertice {
	
	private int aluno;
	private int areaEstudo;
	
	
	public Vertice(int aluno,int area){
		this.aluno=aluno;
		this.areaEstudo=area;
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
	public int getArea() {
		return areaEstudo;
	}
	public void setArea(int area) {
		this.areaEstudo = area;
	}
}
