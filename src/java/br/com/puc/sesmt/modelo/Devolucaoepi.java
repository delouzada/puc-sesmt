package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="DEVOLUCAOEPI")
public class Devolucaoepi implements Serializable
{
	protected Long coddevepi;

	protected String categoria;

	protected Long coddepto;

	protected Long codsetor;

	protected String nome;

	protected Date datadev;

	protected Funcionario funcionario;

	/**
	 * Method 'Devolucaoepi'
	 * 
	 */
	public Devolucaoepi()
	{
	}

    public Devolucaoepi(Long coddevepi, String categoria, String nome, Date datadev) {
        this.coddevepi = coddevepi;
        this.categoria = categoria;
        this.nome = nome;
        this.datadev = datadev;
    }

    public Devolucaoepi(Long coddevepi, String categoria, Long coddepto, Long codsetor, String nome, Date datadev, Funcionario funcionario) {
        this.coddevepi = coddevepi;
        this.categoria = categoria;
        this.coddepto = coddepto;
        this.codsetor = codsetor;
        this.nome = nome;
        this.datadev = datadev;
        this.funcionario = funcionario;
    }
        
        
        

	/**
	 * Method 'getCoddevepi'
	 * 
	 * @return Long
	 */
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="CODDEVEPI")
	public Long getCoddevepi()
	{
		return coddevepi;
	}

	/**
	 * Method 'setCoddevepi'
	 * 
	 * @param coddevepi
	 */
	public void setCoddevepi(Long coddevepi)
	{
		this.coddevepi = coddevepi;
	}

	/**
	 * Method 'getCategoria'
	 * 
	 * @return String
	 */
	@Column(name="CATEGORIA")
	public String getCategoria()
	{
		return categoria;
	}

	/**
	 * Method 'setCategoria'
	 * 
	 * @param categoria
	 */
	public void setCategoria(String categoria)
	{
		this.categoria = categoria;
	}

	/**
	 * Method 'getCoddepto'
	 * 
	 * @return Long
	 */
	@Column(name="CODDEPTO")
	public Long getCoddepto()
	{
		return coddepto;
	}

	/**
	 * Method 'setCoddepto'
	 * 
	 * @param coddepto
	 */
	public void setCoddepto(Long coddepto)
	{
		this.coddepto = coddepto;
	}

	/**
	 * Method 'getCodsetor'
	 * 
	 * @return Long
	 */
	@Column(name="CODSETOR")
	public Long getCodsetor()
	{
		return codsetor;
	}

	/**
	 * Method 'setCodsetor'
	 * 
	 * @param codsetor
	 */
	public void setCodsetor(Long codsetor)
	{
		this.codsetor = codsetor;
	}

	/**
	 * Method 'getNome'
	 * 
	 * @return String
	 */
	@Column(name="NOME")
	public String getNome()
	{
		return nome;
	}

	/**
	 * Method 'setNome'
	 * 
	 * @param nome
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	/**
	 * Method 'getDatadev'
	 * 
	 * @return Date
	 */
	@Column(name="DATADEV")
    @Temporal(javax.persistence.TemporalType.DATE)
	public Date getDatadev()
	{
		return datadev;
	}

	/**
	 * Method 'setDatadev'
	 * 
	 * @param datadev
	 */
	public void setDatadev(Date datadev)
	{
		this.datadev = datadev;
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
        return "Devolucaoepi{" + "coddevepi=" + coddevepi + ", categoria=" + categoria + ", coddepto=" + coddepto + ", codsetor=" + codsetor + ", nome=" + nome + ", datadev=" + datadev + ", funcionario=" + funcionario + '}';
    }
        
        

}
