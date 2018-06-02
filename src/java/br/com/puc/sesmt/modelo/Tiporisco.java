package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name="TIPORISCO")
public class Tiporisco implements Serializable
{
	protected Long codtiporisco;

	protected String nometiporisco;

	protected String descricao;

	/**
	 * Method 'Tiporisco'
	 * 
	 */
	public Tiporisco()
	{
	}

    public Tiporisco(Long codtiporisco, String nometiporisco, String descricao) {
        this.codtiporisco = codtiporisco;
        this.nometiporisco = nometiporisco;
        this.descricao = descricao;
    }
        
        

	/**
	 * Method 'getCodtiporisco'
	 * 
	 * @return Long
	 */
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="CODTIPORISCO")
	public Long getCodtiporisco()
	{
		return codtiporisco;
	}

	/**
	 * Method 'setCodtiporisco'
	 * 
	 * @param codtiporisco
	 */
	public void setCodtiporisco(Long codtiporisco)
	{
		this.codtiporisco = codtiporisco;
	}

	/**
	 * Method 'getNometiporisco'
	 * 
	 * @return String
	 */
	@Column(name="NOMETIPORISCO")
	public String getNometiporisco()
	{
		return nometiporisco;
	}

	/**
	 * Method 'setNometiporisco'
	 * 
	 * @param nometiporisco
	 */
	public void setNometiporisco(String nometiporisco)
	{
		this.nometiporisco = nometiporisco;
	}

	/**
	 * Method 'getDescricao'
	 * 
	 * @return String
	 */
	@Column(name="DESCRICAO")
	public String getDescricao()
	{
		return descricao;
	}

	/**
	 * Method 'setDescricao'
	 * 
	 * @param descricao
	 */
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

    @Override
    public String toString() {
        return "Tiporisco{" + "codtiporisco=" + codtiporisco + ", nometiporisco=" + nometiporisco + ", descricao=" + descricao + '}';
    }
        
        

}
