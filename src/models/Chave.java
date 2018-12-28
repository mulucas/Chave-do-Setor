package models;

public class Chave {

	private Long id;
	private String nome, matricula, dataSaida, nomeEntregue, matriculaEntregue, dataEntregue;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	public String getNomeEntregue() {
		return nomeEntregue;
	}
	public void setNomeEntregue(String nomeEntregue) {
		this.nomeEntregue = nomeEntregue;
	}
	public String getMatriculaEntregue() {
		return matriculaEntregue;
	}
	public void setMatriculaEntregue(String matriculaEntregue) {
		this.matriculaEntregue = matriculaEntregue;
	}
	public String getDataEntregue() {
		return dataEntregue;
	}
	public void setDataEntregue(String dataEntregue) {
		this.dataEntregue = dataEntregue;
	}
	
}