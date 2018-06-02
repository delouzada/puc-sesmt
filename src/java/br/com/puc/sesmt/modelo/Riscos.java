package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name="RISCOS")
public class Riscos implements Serializable
{
	protected Long codrisco;

	protected String complemento;

	protected String efeitosaude;

	protected   Epi epi;

	protected Tiporisco tiporisco;

	/**
	 * Method 'Riscos'
	 * 
	 */
	public Riscos()
	{
	}

    public Riscos(Long codrisco, String complemento, String efeitosaude) {
        this.codrisco = codrisco;
        this.complemento = complemento;
        this.efeitosaude = efeitosaude;
    }
        
        

	/**
	 * Method 'getCodrisco'
	 * 
	 * @return Long
	 */
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="CODRISCO")
	public Long getCodrisco()
	{
		return codrisco;
	}

	/**
	 * Method 'setCodrisco'
	 * 
	 * @param codrisco
	 */
	public void setCodrisco(Long codrisco)
	{
		this.codrisco = codrisco;
	}

	/**
	 * Method 'getComplemento'
	 * 
	 * @return String
	 */
	@Column(name="COMPLEMENTO")
	public String getComplemento()
	{
		return complemento;
	}

	/**
	 * Method 'setComplemento'
	 * 
	 * @param complemento
	 */
	public void setComplemento(String complemento)
	{
		this.complemento = complemento;
	}

	/**
	 * Method 'getEfeitosaude'
	 * 
	 * @return String
	 */
	@Column(name="EFEITOSAUDE")
	public String getEfeitosaude()
	{
		return efeitosaude;
	}

	/**
	 * Method 'setEfeitosaude'
	 * 
	 * @param efeitosaude
	 */
	public void setEfeitosaude(String efeitosaude)
	{
		this.efeitosaude = efeitosaude;
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

	/**
	 * Method 'getTiporisco'
	 * 
	 * @return Tiporisco
	 */
	@ManyToOne
	@JoinColumn(name="CODTIPORISCO", insertable=true, updatable=true)
	public Tiporisco getTiporisco()
	{
		return tiporisco;
	}

	/**
	 * Method 'setTiporisco'
	 * 
	 * @param tiporisco
	 */
	public void setTiporisco(Tiporisco tiporisco)
	{
		this.tiporisco = tiporisco;
	}

        
        
        
        
        
    @Override
    public String toString() {
        return "Riscos{" + "codrisco=" + codrisco + ", complemento=" + complemento + ", efeitosaude=" + efeitosaude + ", epi=" + epi + ", tiporisco=" + tiporisco + '}';
    }
        
        

}
