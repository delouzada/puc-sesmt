package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name="FORNECEDOR")
public class Fornecedor implements Serializable
{
	protected Long codfornecedor;

	protected String contato;

	protected String cnpj;

	protected String endereco;

	protected String fabricante;

	protected String nomefornecedor;

	protected Epi epi;

	/**
	 * Method 'Fornecedor'
	 * 
	 */
	public Fornecedor()
	{
	}

    public Fornecedor(Long codfornecedor, String contato, String cnpj, String endereco, String fabricante, String nomefornecedor) {
        this.codfornecedor = codfornecedor;
        this.contato = contato;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.fabricante = fabricante;
        this.nomefornecedor = nomefornecedor;
    }

    public Fornecedor(Long codfornecedor, String contato, String cnpj, String endereco, String fabricante, String nomefornecedor, Epi epi) {
        this.codfornecedor = codfornecedor;
        this.contato = contato;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.fabricante = fabricante;
        this.nomefornecedor = nomefornecedor;
        this.epi = epi;
    }

    

        
        
        
        
	/**
	 * Method 'getCodfornecedor'
	 * 
	 * @return Long
	 */
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="CODFORNECEDOR")
	public Long getCodfornecedor()
	{
		return codfornecedor;
	}

	/**
	 * Method 'setCodfornecedor'
	 * 
	 * @param codfornecedor
	 */
	public void setCodfornecedor(Long codfornecedor)
	{
		this.codfornecedor = codfornecedor;
	}

	/**
	 * Method 'getContato'
	 * 
	 * @return byte[]
	 */
	@Column(name="CONTATO")
	public String getContato()
	{
		return contato;
	}

	/**
	 * Method 'setContato'
	 * 
	 * @param contato
	 */
	public void setContato(String contato)
	{
		this.contato = contato;
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
	 * Method 'getEndereco'
	 * 
	 * @return byte[]
	 */
	@Column(name="ENDERECO")
	public String getEndereco()
	{
		return endereco;
	}

	/**
	 * Method 'setEndereco'
	 * 
	 * @param endereco
	 */
	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}

	/**
	 * Method 'getFabricante'
	 * 
	 * @return String
	 */
	@Column(name="FABRICANTE")
	public String getFabricante()
	{
		return fabricante;
	}

	/**
	 * Method 'setFabricante'
	 * 
	 * @param fabricante
	 */
	public void setFabricante(String fabricante)
	{
		this.fabricante = fabricante;
	}

	/**
	 * Method 'getNomefornecedor'
	 * 
	 * @return String
	 */
	@Column(name="NOMEFORNECEDOR")
	public String getNomefornecedor()
	{
		return nomefornecedor;
	}

	/**
	 * Method 'setNomefornecedor'
	 * 
	 * @param nomefornecedor
	 */
	public void setNomefornecedor(String nomefornecedor)
	{
		this.nomefornecedor = nomefornecedor;
	}

	/**
	 * Method 'getEpi'
	 * 
	 * @return Epi
	 */
	@ManyToOne
	@JoinColumn(name="CODEPI")
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

    @Override
    public String toString() {
        return "Fornecedor{" + "codfornecedor=" + codfornecedor + ", contato=" + contato + ", cnpj=" + cnpj + ", endereco=" + endereco + ", fabricante=" + fabricante + ", nomefornecedor=" + nomefornecedor + ", epi=" + epi + '}';
    }
        
        

}
