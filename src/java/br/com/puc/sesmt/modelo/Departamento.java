package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento implements Serializable {
	protected Integer coddepto;

	protected String nomedepto;

	protected String localdepto;

	protected Funcionario funcionario;

	/**
	 * Method 'Departamento'
	 * 
	 */
	public Departamento() {
	}

    public Departamento(Integer coddepto, String nomedepto, String localdepto) {
        this.coddepto = coddepto;
        this.nomedepto = nomedepto;
        this.localdepto = localdepto;
    }

    public Departamento(Integer coddepto, String nomedepto, String localdepto, Funcionario funcionario) {
        this.coddepto = coddepto;
        this.nomedepto = nomedepto;
        this.localdepto = localdepto;
        this.funcionario = funcionario;
    }
        
        

	/**
	 * Method 'getCoddepto'
	 * 
	 * @return Integer
	 */
	@Id @GeneratedValue (strategy=GenerationType.AUTO)   
	@Column(name = "CODDEPTO")
	public Integer getCoddepto() {
		return coddepto;
	}

	/**
	 * Method 'setCoddepto'
	 * 
	 * @param coddepto
	 */
	public void setCoddepto(Integer coddepto) {
		this.coddepto = coddepto;
	}

	/**
	 * Method 'getNomedepto'
	 * 
	 * @return String
	 */
	@Column(name = "NOMEDEPTO")
	public String getNomedepto() {
		return nomedepto;
	}

	/**
	 * Method 'setNomedepto'
	 * 
	 * @param nomedepto
	 */
	public void setNomedepto(String nomedepto) {
		this.nomedepto = nomedepto;
	}

	/**
	 * Method 'getLocaldepto'
	 * 
	 * @return String
	 */
	@Column(name = "LOCALDEPTO")
	public String getLocaldepto() {
		return localdepto;
	}

	/**
	 * Method 'setLocaldepto'
	 * 
	 * @param localdepto
	 */
	public void setLocaldepto(String localdepto) {
		this.localdepto = localdepto;
	}

	/**
	 * Method 'getFuncionario'
	 * 
	 * @return Funcionario
	 */
	@JoinColumn(name = "MATRICULA", insertable = true, updatable = true)
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * Method 'setFuncionario'
	 * 
	 * @param funcionario
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Departamento [coddepto=" + coddepto + ", nomedepto="
				+ nomedepto + ", localdepto=" + localdepto + ", funcionario="
				+ funcionario + "]";
	}
	
	

}
