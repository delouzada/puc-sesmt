package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ADQUIRIREPI")
public class Adquirirepi implements Serializable
{
	protected Long codadepi;

	protected Date dataaqui;
	protected Funcionario matricula;

        private Centrocustosetor centrocustosetor;

	/**
	 * Method 'Adquirirepi'
	 * 
	 */
	public Adquirirepi()
	{
	}

    public Adquirirepi(Long codadepi, Date dataaqui) {
        this.codadepi = codadepi;
        this.dataaqui = dataaqui;
    }

    public Adquirirepi(Long codadepi, Date dataaqui, Funcionario matricula) {
        this.codadepi = codadepi;
        this.dataaqui = dataaqui;
        this.matricula = matricula;
    }

   
        

	@Id
        @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="CODADEPI")
	public Long getCodadepi()
	{
		return codadepi;
	}

	
	public void setCodadepi(Long codadepi)
	{
		this.codadepi = codadepi;
	}

	
	@Column(name="DATAAQUI")
    @Temporal(javax.persistence.TemporalType.DATE)
	public Date getDataaqui()
	{
		return dataaqui;
	}

	
	public void setDataaqui(Date dataaqui)
	{
		this.dataaqui = dataaqui;
	}

	@ManyToOne
	@JoinColumn(name="MATRICULA", insertable=true, updatable=true)
	public Funcionario getMatricula()
	{
		return matricula;
	}

	
	public void setMatricula(Funcionario matricula)
	{
		this.matricula = matricula;
	}

    public Centrocustosetor getCentrocustosetor() {
        return centrocustosetor;
    }

    public void setCentrocustosetor(Centrocustosetor centrocustosetor) {
        this.centrocustosetor = centrocustosetor;
    }

        
        
        
        
        
    @Override
    public String toString() {
        return "Adquirirepi{" + "codadepi=" + codadepi + ", dataaqui=" + dataaqui + ", matricula=" + matricula + '}';
    }

	
        
        

}
