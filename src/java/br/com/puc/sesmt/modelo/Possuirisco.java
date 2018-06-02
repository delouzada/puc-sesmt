package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name="POSSUIRISCO")
public class Possuirisco implements Serializable
{
	protected Long codpossuirisco;

	protected Departamento departamento;

	protected Riscos riscos;

	protected Setor setor;

	/**
	 * Method 'Possuirisco'
	 * 
	 */
	public Possuirisco()
	{
	}

    public Possuirisco(Long codpossuirisco) {
        this.codpossuirisco = codpossuirisco;
    }

    public Possuirisco(Long codpossuirisco, Departamento departamento, Riscos riscos, Setor setor) {
        this.codpossuirisco = codpossuirisco;
        this.departamento = departamento;
        this.riscos = riscos;
        this.setor = setor;
    }
        
    

	/**
	 * Method 'getCodpossuirisco'
	 * 
	 * @return Long
	 */
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="CODPOSSUIRISCO")
	public Long getCodpossuirisco()
	{
		return codpossuirisco;
	}

	/**
	 * Method 'setCodpossuirisco'
	 * 
	 * @param codpossuirisco
	 */
	public void setCodpossuirisco(Long codpossuirisco)
	{
		this.codpossuirisco = codpossuirisco;
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
	 * Method 'getRiscos'
	 * 
	 * @return Riscos
	 */
	@ManyToOne
	@JoinColumn(name="CODRISCO", insertable=true, updatable=true)
	public Riscos getRiscos()
	{
		return riscos;
	}

	/**
	 * Method 'setRiscos'
	 * 
	 * @param riscos
	 */
	public void setRiscos(Riscos riscos)
	{
		this.riscos = riscos;
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
        return "Possuirisco{" + "codpossuirisco=" + codpossuirisco + ", departamento=" + departamento + ", riscos=" + riscos + ", setor=" + setor + '}';
    }
        
        

}
