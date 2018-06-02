package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="SETOR")
public class Setor implements Serializable
{
	protected Integer codsetor;

	protected String nomesetor;

	protected String localsetor;

	protected Departamento departamento;

	protected Funcionario funcionario;

	/**
	 * Method 'Setor'
	 * 
	 */
	public Setor()
	{
	}

    public Setor(Integer codsetor, String nomesetor, String localsetor) {
        this.codsetor = codsetor;
        this.nomesetor = nomesetor;
        this.localsetor = localsetor;
    }

    public Setor(Integer codsetor, String nomesetor, String localsetor, Departamento departamento, Funcionario funcionario) {
        this.codsetor = codsetor;
        this.nomesetor = nomesetor;
        this.localsetor = localsetor;
        this.departamento = departamento;
        this.funcionario = funcionario;
    }

        
	/**
	 * Method 'getCodsetor'
	 * 
	 * @return Integer
	 */
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="CODSETOR")
	public Integer getCodsetor()
	{
		return codsetor;
	}

	/**
	 * Method 'setCodsetor'
	 * 
	 * @param codsetor
	 */
	public void setCodsetor(Integer codsetor)
	{
		this.codsetor = codsetor;
	}

	/**
	 * Method 'getNomesetor'
	 * 
	 * @return String
	 */
	@Column(name="NOMESETOR")
	public String getNomesetor()
	{
		return nomesetor;
	}

	/**
	 * Method 'setNomesetor'
	 * 
	 * @param nomesetor
	 */
	public void setNomesetor(String nomesetor)
	{
		this.nomesetor = nomesetor;
	}

	/**
	 * Method 'getLocalsetor'
	 * 
	 * @return String
	 */
	@Column(name="LOCALSETOR")
	public String getLocalsetor()
	{
		return localsetor;
	}

	/**
	 * Method 'setLocalsetor'
	 * 
	 * @param localsetor
	 */
	public void setLocalsetor(String localsetor)
	{
		this.localsetor = localsetor;
	}

	/**
	 * Method 'getDepartamento'
	 * 
	 * @return Departamento
	 */
	@ManyToOne
       @JoinColumn(name="CODDEPTO", insertable=true, updatable=true)
	public Departamento getDepartamento()
	{
		return departamento;
	}

	/**
	 * Method 'setDepartamento'
	 * 
	 * @param departamento
	 */
	public void setDepartamento(Departamento departamento)
	{
		this.departamento = departamento;
	}

	/**
	 * Method 'getFuncionario'
	 * 
	 * @return Funcionario
	 */
	@ManyToOne
       @JoinColumn(name="MATRICULA", insertable=true, updatable=true)
	public Funcionario getFuncionario()
	{
		return funcionario;
	}

	/**
	 * Method 'setFuncionario'
	 * 
	 * @param funcionario
	 */
	public void setFuncionario(Funcionario funcionario)
	{
		this.funcionario = funcionario;
	}

    @Override
    public String toString() {
        return "Setor{" + "codsetor=" + codsetor + ", nomesetor=" + nomesetor + ", localsetor=" + localsetor + ", departamento=" + departamento + ", funcionario=" + funcionario + '}';
    }
        
        

}
