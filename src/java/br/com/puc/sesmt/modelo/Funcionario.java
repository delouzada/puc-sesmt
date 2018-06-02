package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;
import javax.persistence.*;
import java.util.Date;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="FUNCIONARIO")
public class Funcionario implements Serializable
{
	protected Long matricula;

	private String cargahoraria;

	private String cargo;

        
	private String email;

	private String funcao;

        
	private String nome;

	private String ramal;

	private Departamento departamento;

	private Setor setor;

        private FuncionarioStatus funcionarioStatus;
    private Itensdevolvidos itensdevolvidos;
        
	/**
	 * Method 'Funcionario'
	 * 
	 */
	public Funcionario()
	{
	}

    public Funcionario(Long matricula, String cargahoraria, String cargo, String email, String funcao, String nome, String ramal) {
        this.matricula = matricula;
        this.cargahoraria = cargahoraria;
        this.cargo = cargo;
        this.email = email;
        this.funcao = funcao;
        this.nome = nome;
        this.ramal = ramal;
    }

    public Funcionario(Long matricula, String cargahoraria, String cargo, String email, String funcao, String nome, String ramal, Departamento departamento, Setor setor, FuncionarioStatus funcionarioStatus) {
        this.matricula = matricula;
        this.cargahoraria = cargahoraria;
        this.cargo = cargo;
        this.email = email;
        this.funcao = funcao;
        this.nome = nome;
        this.ramal = ramal;
        this.departamento = departamento;
        this.setor = setor;
        this.funcionarioStatus = funcionarioStatus;
    }

        
        

	/**
	 * Method 'getMatricula'
	 * 
	 * @return Long
	 */
	@Id
	@Column(name="MATRICULA")
	public Long getMatricula()
	{
		return matricula;
	}

	/**
	 * Method 'setMatricula'
	 * 
	 * @param matricula
	 */
	public void setMatricula(Long matricula)
	{
		this.matricula = matricula;
	}

	/**
	 * Method 'getCargahoraria'
	 * 
	 * @return Long
	 */
	@Column(name="CARGAHORARIA")
	public String getCargahoraria()
	{
		return cargahoraria;
	}

	/**
	 * Method 'setCargahoraria'
	 * 
	 * @param cargahoraria
	 */
	public void setCargahoraria(String cargahoraria)
	{
		this.cargahoraria = cargahoraria;
	}

	/**
	 * Method 'getCargo'
	 * 
	 * @return String
	 */
	@Column(name="CARGO")
	public String getCargo()
	{
		return cargo;
	}

	/**
	 * Method 'setCargo'
	 * 
	 * @param cargo
	 */
	public void setCargo(String cargo)
	{
		this.cargo = cargo;
	}

        
        
        
	/**
	 * Method 'getEmail'
	 * 
	 * @return String
	 */
	@Column(name="EMAIL")
	public String getEmail()
	{
		return email;
	}

	/**
	 * Method 'setEmail'
	 * 
	 * @param email
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Method 'getFuncao'
	 * 
	 * @return String
	 */
	@Column(name="FUNCAO")
	public String getFuncao()
	{
		return funcao;
	}

	/**
	 * Method 'setFuncao'
	 * 
	 * @param funcao
	 */
	public void setFuncao(String funcao)
	{
		this.funcao = funcao;
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
	 * Method 'getRamal'
	 * 
	 * @return Long
	 */
	@Column(name="RAMAL")
	public String getRamal()
	{
		return ramal;
	}

	/**
	 * Method 'setRamal'
	 * 
	 * @param ramal
	 */
	public void setRamal(String ramal)
	{
		this.ramal = ramal;
	}
        
        
        
        
        
        

        
        

	/**
	 * Method 'getDepartamento'
	 * 
	 * @return Departamento
	 */
	@ManyToOne
        @Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	@JoinColumn(name="CODDEPTO")
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
	 * Method 'getSetor'
	 * 
	 * @return Setor
	 */
        @ManyToOne
	@Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@JoinColumn(name="CODSETOR")
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

    
    
    
    
    
    
   
    
        @ManyToOne
	@Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	@JoinColumn(name="CODSTATUS")
        public FuncionarioStatus getFuncionarioStatus() {
        return funcionarioStatus;
    }

    public void setFuncionarioStatus(FuncionarioStatus funcionarioStatus) {
        this.funcionarioStatus = funcionarioStatus;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.matricula != other.matricula && (this.matricula == null || !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.matricula != null ? this.matricula.hashCode() : 0);
        return hash;
    }

    
    
    
    
    @Override
    public String toString() {
        return "Funcionario{" + "matricula=" + matricula + ", cargahoraria=" + cargahoraria + ", cargo=" + cargo + ", email=" + email + ", funcao=" + funcao + ", nome=" + nome + ", ramal=" + ramal + ", departamento=" + departamento + ", setor=" + setor + ", funcionarioStatus=" + funcionarioStatus + '}';
    }

    @OneToOne(mappedBy = "funcionario")
    public Itensdevolvidos getItensdevolvidos() {
        return itensdevolvidos;
    }

    public void setItensdevolvidos(Itensdevolvidos itensdevolvidos) {
        this.itensdevolvidos = itensdevolvidos;
    }

        

        
    
        
    
        
        
        

}
