package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="CENTROCUSTOSETOR")
public class Centrocustosetor implements Serializable
{
	protected Long centrocustosetor;

	protected Date validade;

	protected Long saldo;

	protected Centrocustodepto centrocustodepto;

	protected Setor setor;
        
        private Compras compras;
        
        
        private Long efetuada;
    private List<Compras> comprass;

	/**
	 * Method 'Centrocustosetor'
	 * 
	 */
	public Centrocustosetor()
	{
	}

    public Centrocustosetor(Long centrocustosetor, Date validade, Long saldo) {
        this.centrocustosetor = centrocustosetor;
        this.validade = validade;
        this.saldo = saldo;
    }

    public Centrocustosetor(Long centrocustosetor, Date validade, Long saldo, Centrocustodepto centrocustodepto, Setor setor) {
        this.centrocustosetor = centrocustosetor;
        this.validade = validade;
        this.saldo = saldo;
        this.centrocustodepto = centrocustodepto;
        this.setor = setor;
    }

        
        
        
	/**
	 * Method 'getCentrocustosetor'
	 * 
	 * @return Long
	 */
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="CENTROCUSTOSETOR")
	public Long getCentrocustosetor()
	{
		return centrocustosetor;
	}

	/**
	 * Method 'setCentrocustosetor'
	 * 
	 * @param centrocustosetor
	 */
	public void setCentrocustosetor(Long centrocustosetor)
	{
		this.centrocustosetor = centrocustosetor;
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
	public Long getSaldo()
	{
		return saldo;
	}

	/**
	 * Method 'setSaldo'
	 * 
	 * @param saldo
	 */
	public void setSaldo(Long saldo)
	{
		this.saldo = saldo;
	}

	/**
	 * Method 'getCentrocustodepto'
	 * 
	 * @return Centrocustodepto
	 */
	@ManyToOne
	@JoinColumn(name="CENTROCUSTODEPTO", insertable=true, updatable=true)
	public Centrocustodepto getCentrocustodepto()
	{
		return centrocustodepto;
	}

	/**
	 * Method 'setCentrocustodepto'
	 * 
	 * @param centrocustodepto
	 */
	public void setCentrocustodepto(Centrocustodepto centrocustodepto)
	{
		this.centrocustodepto = centrocustodepto;
	}

	/**
	 * Method 'getSetor'
	 * 
	 * @return Setor
	 */
	@ManyToOne
	@JoinColumn(name="CODSETOR", insertable=true, updatable=true)
	public Setor getSetor()
	{
		return setor;
	}

	/**
	 * Method 'setSetor'
	 * 
	 * @param setor
	 */
	public void setSetor(Setor setor)
	{
		this.setor = setor;
	}

    
        
        
    @Override
    public String toString() {
        return "Centrocustosetor{" + "centrocustosetor=" + centrocustosetor + ", validade=" + validade + ", saldo=" + saldo + ", centrocustodepto=" + centrocustodepto + ", setor=" + setor + '}';
    }

    @OneToMany(mappedBy = "centrocustosetor")
    public List<Compras> getComprass() {
        return comprass;
    }

    public void setComprass(List<Compras> comprass) {
        this.comprass = comprass;
    }

        
}
