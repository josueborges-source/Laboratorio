package model;

import java.util.ArrayList;

public class Laboratorio {
	private String nome;
	private String cnpj;
	private ArrayList<String> substancias = new ArrayList<String>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<String> getSubstancias() {
		return substancias;
	}

	public void addSubstancia(String substancia) {
		this.substancias.add(substancia);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "Laboratorio [nome=" + nome + ", cnpj=" + cnpj + ", substancias=" + substancias + "]\n";
	}
}
