package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;

import javax.persistence.*;

@Entity
@Table(name="ITENS")
public class Itens implements Serializable
{
	protected ItensPk id;

	protected Integer quantidade;

	protected Double valorunitario;

	protected Epi epi;

	protected Notasfiscais notasfiscais;

	/**
	 * Method 'Itens'
	 * 
	 */
	public Itens()
	{
	}

    public Itens(ItensPk id, Integer quantidade, Double valorunitario) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorunitario = valorunitario;
    }

    public Itens(ItensPk id, Integer quantidade, Double valorunitario, Epi epi, Notasfiscais notasfiscais) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorunitario = valorunitario;
        this.epi = epi;
        this.notasfiscais = notasfiscais;
    }
        
        
    

	/**
	 * Method 'getId'
	 * 
	 * @return ItensPk
	 */
	@EmbeddedId
	@AttributeOverrides( {
	@AttributeOverride(name="codnotafiscal", column=@Column(name="CODNOTAFISCAL")),
	@AttributeOverride(name="iditem", column=@Column(name="IDITEM"))
	} )
	public ItensPk getId()
	{
		return id;
	}

	/**
	 * Method 'setId'
	 * 
	 * @param id
	 */
	public void setId(ItensPk id)
	{
		this.id = id;
	}

	/**
	 * Method 'getQuantidade'
	 * 
	 * @return Long
	 */
	@Column(name="QUANTIDADE")
	public Integer getQuantidade()
	{
		return quantidade;
	}

	/**
	 * Method 'setQuantidade'
	 * 
	 * @param quantidade
	 */
	public void setQuantidade(Integer quantidade)
	{
		this.quantidade = quantidade;
	}

	/**
	 * Method 'getValorunitario'
	 * 
	 * @return Float
	 */
	@Column(name="VALORUNITARIO")
	public Double getValorunitario()
	{
		return valorunitario;
	}

	/**
	 * Method 'setValorunitario'
	 * 
	 * @param valorunitario
	 */
	public void setValorunitario(Double valorunitario)
	{
		this.valorunitario = valorunitario;
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
	 * Method 'getNotasfiscais'
	 * 
	 * @return Notasfiscais
	 */
	@ManyToOne
	@JoinColumn(name="CODNOTAFISCAL", insertable=false, updatable=false)
	public Notasfiscais getNotasfiscais()
	{
		return notasfiscais;
	}

	/**
	 * Method 'setNotasfiscais'
	 * 
	 * @param notasfiscais
	 */
	public void setNotasfiscais(Notasfiscais notasfiscais)
	{
		this.notasfiscais = notasfiscais;
	}

    @Override
    public String toString() {
        return "Itens{" + "id=" + id + ", quantidade=" + quantidade + ", valorunitario=" + valorunitario + ", epi=" + epi + ", notasfiscais=" + notasfiscais + '}';
    }
        
        

}
