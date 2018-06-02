package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="CENTROCUSTODEPTO")
public class Centrocustodepto implements Serializable
{
	protected Long centrocustodepto;

	protected Date validade;

	protected Double saldo;

	protected Departamento departamento;

	protected Planocentrocusto planocentrocusto;

	/**
	 * Method 'Centrocustodepto'
	 * 
	 */
	public Centrocustodepto()
	{
	}

    public Centrocustodepto(Long centrocustodepto, Date validade, Double saldo) {
        this.centrocustodepto = centrocustodepto;
        this.validade = validade;
        this.saldo = saldo;
    }

    public Centrocustodepto(Long centrocustodepto, Date validade, Double saldo, Departamento departamento, Planocentrocusto planocentrocusto) {
        this.centrocustodepto = centrocustodepto;
        this.validade = validade;
        this.saldo = saldo;
        this.departamento = departamento;
        this.planocentrocusto = planocentrocusto;
    }
        
        

	/**
	 * Method 'getCentrocustodepto'
	 * 
	 * @return Long
	 */
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="CENTROCUSTODEPTO")
	public Long getCentrocustodepto()
	{
		return centrocustodepto;
	}

	/**
	 * Method 'setCentrocustodepto'
	 * 
	 * @param centrocustodepto
	 */
	public void setCentrocustodepto(Long centrocustodepto)
	{
		this.centrocustodepto = centrocustodepto;
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
	 * Method 'getSaldo'
	 * 
	 * @return Float
	 */
	@Column(name="SALDO")
	public Double getSaldo()
	{
		return saldo;
	}

	/**
	 * Method 'setSaldo'
	 * 
	 * @param saldo
	 */
	public void setSaldo(Double saldo)
	{
		this.saldo = saldo;
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
	 * Method 'getPlanocentrocusto'
	 * 
	 * @return Planocentrocusto
	 */
	@ManyToOne
	@JoinColumn(name="CODCENTROCUSTO", insertable=true, updatable=true)
	public Planocentrocusto getPlanocentrocusto()
	{
		return planocentrocusto;
	}

	/**
	 * Method 'setPlanocentrocusto'
	 * 
	 * @param planocentrocusto
	 */
	public void setPlanocentrocusto(Planocentrocusto planocentrocusto)
	{
		this.planocentrocusto = planocentrocusto;
	}

    @Override
    public String toString() {
        return "Centrocustodepto{" + "centrocustodepto=" + centrocustodepto + ", validade=" + validade + ", saldo=" + saldo + ", departamento=" + departamento + ", planocentrocusto=" + planocentrocusto + '}';
    }
        
        

}
