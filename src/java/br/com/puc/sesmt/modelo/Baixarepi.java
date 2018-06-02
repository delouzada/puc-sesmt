package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="BAIXAREPI")
public class Baixarepi implements Serializable
{
	protected Long codbaixa;

	protected String destino;

	protected Long valorunitatio;

	protected String motivo;

	protected Integer quantidade;

	protected Long codsetor;

	protected Long valortotal;

	protected Date databaixa;

	protected String nome;

	protected String observacoes;

	protected Epi epi;

	protected Funcionario funcionario;

	/**
	 * Method 'Baixarepi'
	 * 
	 */
	public Baixarepi()
	{
	}

    public Baixarepi(Long codbaixa, String destino, Long valorunitatio, String motivo, Integer quantidade, Long codsetor, Long valortotal, Date databaixa, String nome, String observacoes) {
        this.codbaixa = codbaixa;
        this.destino = destino;
        this.valorunitatio = valorunitatio;
        this.motivo = motivo;
        this.quantidade = quantidade;
        this.codsetor = codsetor;
        this.valortotal = valortotal;
        this.databaixa = databaixa;
        this.nome = nome;
        this.observacoes = observacoes;
    }

    public Baixarepi(Long codbaixa, String destino, Long valorunitatio, String motivo, Integer quantidade, Long codsetor, Long valortotal, Date databaixa, String nome, String observacoes, Epi epi, Funcionario funcionario) {
        this.codbaixa = codbaixa;
        this.destino = destino;
        this.valorunitatio = valorunitatio;
        this.motivo = motivo;
        this.quantidade = quantidade;
        this.codsetor = codsetor;
        this.valortotal = valortotal;
        this.databaixa = databaixa;
        this.nome = nome;
        this.observacoes = observacoes;
        this.epi = epi;
        this.funcionario = funcionario;
    }
        
        
        
        

	/**
	 * Method 'getCodbaixa'
	 * 
	 * @return Long
	 */
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="CODBAIXA")
	public Long getCodbaixa()
	{
		return codbaixa;
	}

	/**
	 * Method 'setCodbaixa'
	 * 
	 * @param codbaixa
	 */
	public void setCodbaixa(Long codbaixa)
	{
		this.codbaixa = codbaixa;
	}

	/**
	 * Method 'getDestino'
	 * 
	 * @return String
	 */
	@Column(name="DESTINO")
	public String getDestino()
	{
		return destino;
	}

	/**
	 * Method 'setDestino'
	 * 
	 * @param destino
	 */
	public void setDestino(String destino)
	{
		this.destino = destino;
	}

	/**
	 * Method 'getValorunitatio'
	 * 
	 * @return Long
	 */
	@Column(name="VALORUNITATIO")
	public Long getValorunitatio()
	{
		return valorunitatio;
	}

	/**
	 * Method 'setValorunitatio'
	 * 
	 * @param valorunitatio
	 */
	public void setValorunitatio(Long valorunitatio)
	{
		this.valorunitatio = valorunitatio;
	}

	/**
	 * Method 'getMotivo'
	 * 
	 * @return String
	 */
	@Column(name="MOTIVO")
	public String getMotivo()
	{
		return motivo;
	}

	/**
	 * Method 'setMotivo'
	 * 
	 * @param motivo
	 */
	public void setMotivo(String motivo)
	{
		this.motivo = motivo;
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
	 * Method 'getValortotal'
	 * 
	 * @return Long
	 */
	@Column(name="VALORTOTAL")
	public Long getValortotal()
	{
		return valortotal;
	}

	/**
	 * Method 'setValortotal'
	 * 
	 * @param valortotal
	 */
	public void setValortotal(Long valortotal)
	{
		this.valortotal = valortotal;
	}

	/**
	 * Method 'getDatabaixa'
	 * 
	 * @return Date
	 */
	@Column(name="DATABAIXA")
    @Temporal(javax.persistence.TemporalType.DATE)
	public Date getDatabaixa()
	{
		return databaixa;
	}

	/**
	 * Method 'setDatabaixa'
	 * 
	 * @param databaixa
	 */
	public void setDatabaixa(Date databaixa)
	{
		this.databaixa = databaixa;
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
	 * Method 'getObservacoes'
	 * 
	 * @return String
	 */
	@Column(name="OBSERVACOES")
	public String getObservacoes()
	{
		return observacoes;
	}

	/**
	 * Method 'setObservacoes'
	 * 
	 * @param observacoes
	 */
	public void setObservacoes(String observacoes)
	{
		this.observacoes = observacoes;
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
        return "Baixarepi{" + "codbaixa=" + codbaixa + ", destino=" + destino + ", valorunitatio=" + valorunitatio + ", motivo=" + motivo + ", quantidade=" + quantidade + ", codsetor=" + codsetor + ", valortotal=" + valortotal + ", databaixa=" + databaixa + ", nome=" + nome + ", observacoes=" + observacoes + ", epi=" + epi + ", funcionario=" + funcionario + '}';
    }
        
        

}
