package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="PLANOCENTROCUSTO")
public class Planocentrocusto implements Serializable
{
	protected Long codcentrocusto;

	protected Date validade;

	protected String nomeplanocentrocusto;

	/**
	 * Method 'Planocentrocusto'
	 * 
	 */
	public Planocentrocusto()
	{
	}

    public Planocentrocusto(Long codcentrocusto, Date validade, String nomeplanocentrocusto) {
        this.codcentrocusto = codcentrocusto;
        this.validade = validade;
        this.nomeplanocentrocusto = nomeplanocentrocusto;
    }
        
        
    

	/**
	 * Method 'getCodcentrocusto'
	 * 
	 * @return Long
	 */
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="CODCENTROCUSTO")
	public Long getCodcentrocusto()
	{
		return codcentrocusto;
	}

	/**
	 * Method 'setCodcentrocusto'
	 * 
	 * @param codcentrocusto
	 */
	public void setCodcentrocusto(Long codcentrocusto)
	{
		this.codcentrocusto = codcentrocusto;
	}

	/**
	 * Method 'getValidade'
	 * 
	 * @return Date
	 */
	@Column(name="VALIDADE")
    @Temporal(javax.persistence.TemporalType.DATE)
	public Date getValidade()
	{
		return validade;
	}

	/**
	 * Method 'setValidade'
	 * 
	 * @param validade
	 */
	public void setValidade(Date validade)
	{
		this.validade = validade;
	}

	/**
	 * Method 'getNomeplanocentrocusto'
	 * 
	 * @return String
	 */
	@Column(name="NOMEPLANOCENTROCUSTO")
	public String getNomeplanocentrocusto()
	{
		return nomeplanocentrocusto;
	}

	/**
	 * Method 'setNomeplanocentrocusto'
	 * 
	 * @param nomeplanocentrocusto
	 */
	public void setNomeplanocentrocusto(String nomeplanocentrocusto)
	{
		this.nomeplanocentrocusto = nomeplanocentrocusto;
	}

    @Override
    public String toString() {
        return "Planocentrocusto{" + "codcentrocusto=" + codcentrocusto + ", validade=" + validade + ", nomeplanocentrocusto=" + nomeplanocentrocusto + '}';
    }
        
        

}
