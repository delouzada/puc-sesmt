package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="COMPRAS")
public class Compras implements Serializable
{
	protected Long codcompra;

	protected Date datacompra;

	protected String statuscompra;

	protected Double valorcompra;

	protected String motivocompra;

	protected Epi epi;

	protected Fornecedor fornecedor;

	protected Funcionario funcionario;
       
        private Centrocustosetor centrocustosetor;
    
    

	/**
	 * Method 'Compras'
	 * 
	 */
	public Compras()
	{
	}

    public Compras(Long codcompra, Date datacompra, String statuscompra, Double valorcompra, String motivocompra) {
        this.codcompra = codcompra;
        this.datacompra = datacompra;
        this.statuscompra = statuscompra;
        this.valorcompra = valorcompra;
        this.motivocompra = motivocompra;
    }

    public Compras(Long codcompra, Date datacompra, String statuscompra, Double valorcompra, String motivocompra, Epi epi, Fornecedor fornecedor, Funcionario funcionario) {
        this.codcompra = codcompra;
        this.datacompra = datacompra;
        this.statuscompra = statuscompra;
        this.valorcompra = valorcompra;
        this.motivocompra = motivocompra;
        this.epi = epi;
        this.fornecedor = fornecedor;
        this.funcionario = funcionario;
    }
        
        

	/**
	 * Method 'getCodcompra'
	 * 
	 * @return Long
	 */
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="CODCOMPRA")
	public Long getCodcompra()
	{
		return codcompra;
	}

	/**
	 * Method 'setCodcompra'
	 * 
	 * @param codcompra
	 */
	public void setCodcompra(Long codcompra)
	{
		this.codcompra = codcompra;
	}

	/**
	 * Method 'getDatacompra'
	 * 
	 * @return Date
	 */
	@Column(name="DATACOMPRA")
    @Temporal(javax.persistence.TemporalType.DATE)
	public Date getDatacompra()
	{
		return datacompra;
	}

	/**
	 * Method 'setDatacompra'
	 * 
	 * @param datacompra
	 */
	public void setDatacompra(Date datacompra)
	{
		this.datacompra = datacompra;
	}

	/**
	 * Method 'getStatuscompra'
	 * 
	 * @return String
	 */
	@Column(name="STATUSCOMPRA")
	public String getStatuscompra()
	{
		return statuscompra;
	}

	/**
	 * Method 'setStatuscompra'
	 * 
	 * @param statuscompra
	 */
	public void setStatuscompra(String statuscompra)
	{
		this.statuscompra = statuscompra;
	}

	/**
	 * Method 'getValorcompra'
	 * 
	 * @return Float
	 */
	@Column(name="VALORCOMPRA")
	public Double getValorcompra()
	{
		return valorcompra;
	}

	/**
	 * Method 'setValorcompra'
	 * 
	 * @param valorcompra
	 */
	public void setValorcompra(Double valorcompra)
	{
		this.valorcompra = valorcompra;
	}

	/**
	 * Method 'getMotivocompra'
	 * 
	 * @return String
	 */
	@Column(name="MOTIVOCOMPRA")
	public String getMotivocompra()
	{
		return motivocompra;
	}

	/**
	 * Method 'setMotivocompra'
	 * 
	 * @param motivocompra
	 */
	public void setMotivocompra(String motivocompra)
	{
		this.motivocompra = motivocompra;
	}

	/**
	 * Method 'getEpi'
	 * 
	 * @return Epi
	 */
	@ManyToOne
	@JoinColumn(name="CODEPI", insertable=true, updatable=true)
	public Epi getEpi()
	{
		return epi;
	}

	/**
	 * Method 'setEpi'
	 * 
	 * @param epi
	 */
	public void setEpi(Epi epi)
	{
		this.epi = epi;
	}

	/**
	 * Method 'getFornecedor'
	 * 
	 * @return Fornecedor
	 */
	@ManyToOne
	@JoinColumn(name="CODFORNECEDOR", insertable=true, updatable=true)
	public Fornecedor getFornecedor()
	{
		return fornecedor;
	}

	/**
	 * Method 'setFornecedor'
	 * 
	 * @param fornecedor
	 */
	public void setFornecedor(Fornecedor fornecedor)
	{
		this.fornecedor = fornecedor;
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

    @ManyToOne
    public Centrocustosetor getCentrocustosetor() {
        return centrocustosetor;
    }

    public void setCentrocustosetor(Centrocustosetor centrocustosetor) {
        this.centrocustosetor = centrocustosetor;
    }
        
    
        
        
        
        
        
     
        
        

    @Override
    public String toString() {
        return "Compras{" + "codcompra=" + codcompra + ", datacompra=" + datacompra + ", statuscompra=" + statuscompra + ", valorcompra=" + valorcompra + ", motivocompra=" + motivocompra + ", epi=" + epi + ", fornecedor=" + fornecedor + ", funcionario=" + funcionario + '}';
    }

    

}
