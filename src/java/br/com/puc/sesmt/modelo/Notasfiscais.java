package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="NOTASFISCAIS")
public class Notasfiscais implements Serializable
{
	protected Long codnotafiscal;

	protected Long numnota;

	protected Long valornota;

	protected Date datanota;

	protected Integer quantidadeitens;

	protected String cnpj;

	protected Compras compras;

	/**
	 * Method 'Notasfiscais'
	 * 
	 */
	public Notasfiscais()
	{
	}

    public Notasfiscais(Long codnotafiscal, Long numnota, Long valornota, Date datanota, Integer quantidadeitens, String cnpj) {
        this.codnotafiscal = codnotafiscal;
        this.numnota = numnota;
        this.valornota = valornota;
        this.datanota = datanota;
        this.quantidadeitens = quantidadeitens;
        this.cnpj = cnpj;
    }

    public Notasfiscais(Long codnotafiscal, Long numnota, Long valornota, Date datanota, String cnpj, Compras compras) {
        this.codnotafiscal = codnotafiscal;
        this.numnota = numnota;
        this.valornota = valornota;
        this.datanota = datanota;
        this.cnpj = cnpj;
        this.compras = compras;
    }
        
    
    

	/**
	 * Method 'getCodnotafiscal'
	 * 
	 * @return Long
	 */
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="CODNOTAFISCAL")
	public Long getCodnotafiscal()
	{
		return codnotafiscal;
	}

	/**
	 * Method 'setCodnotafiscal'
	 * 
	 * @param codnotafiscal
	 */
	public void setCodnotafiscal(Long codnotafiscal)
	{
		this.codnotafiscal = codnotafiscal;
	}

	/**
	 * Method 'getNumnota'
	 * 
	 * @return Long
	 */
	@Column(name="NUMNOTA")
	public Long getNumnota()
	{
		return numnota;
	}

	/**
	 * Method 'setNumnota'
	 * 
	 * @param numnota
	 */
	public void setNumnota(Long numnota)
	{
		this.numnota = numnota;
	}

	/**
	 * Method 'getValornota'
	 * 
	 * @return Float
	 */
	@Column(name="VALORNOTA")
	public Long getValornota()
	{
		return valornota;
	}

	/**
	 * Method 'setValornota'
	 * 
	 * @param valornota
	 */
	public void setValornota(Long valornota)
	{
		this.valornota = valornota;
	}

	/**
	 * Method 'getDatanota'
	 * 
	 * @return Date
	 */
	@Column(name="DATANOTA")
        @Temporal(javax.persistence.TemporalType.DATE)
	public Date getDatanota()
	{
		return datanota;
	}

	/**
	 * Method 'setDatanota'
	 * 
	 * @param datanota
	 */
	public void setDatanota(Date datanota)
	{
		this.datanota = datanota;
	}

	/**
	 * Method 'getQuantidadeitens'
	 * 
	 * @return Long
	 */
	@Column(name="QUANTIDADEITENS")
	public Integer getQuantidadeitens()
	{
		return quantidadeitens;
	}

	/**
	 * Method 'setQuantidadeitens'
	 * 
	 * @param quantidadeitens
	 */
	public void setQuantidadeitens(Integer quantidadeitens)
	{
		this.quantidadeitens = quantidadeitens;
	}

	/**
	 * Method 'getCnpj'
	 * 
	 * @return Long
	 */
	@Column(name="CNPJ")
	public String getCnpj()
	{
		return cnpj;
	}

	/**
	 * Method 'setCnpj'
	 * 
	 * @param cnpj
	 */
	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}

	/**
	 * Method 'getCompras'
	 * 
	 * @return Compras
	 */
	@ManyToOne
	@JoinColumn(name="CODCOMPRA", insertable=true, updatable=true)
	public Compras getCompras()
	{
		return compras;
	}

	/**
	 * Method 'setCompras'
	 * 
	 * @param compras
	 */
	public void setCompras(Compras compras)
	{
		this.compras = compras;
	}

    @Override
    public String toString() {
        return "Notasfiscais{" + "codnotafiscal=" + codnotafiscal + ", numnota=" + numnota + ", valornota=" + valornota + ", datanota=" + datanota + ", quantidadeitens=" + quantidadeitens + ", cnpj=" + cnpj + ", compras=" + compras + '}';
    }
        
        

}
