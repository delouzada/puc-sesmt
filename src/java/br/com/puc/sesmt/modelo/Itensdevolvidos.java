package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;

import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "ITENSDEVOLVIDOS")
public class Itensdevolvidos implements Serializable {

    protected Long coditem;
    protected Integer quantidade;
    protected Double valor;
    protected String historico;
    private String devolucao;
    private String estado;
    protected Date dataaquisicao;
    private Date dataDevolucao;
    protected Centrocustodepto centrocustodepto;
    protected Centrocustosetor centrocustosetor;
    protected Epi epi;
    private Funcionario funcionario;

    
    
    
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODITEM")
    public Long getCoditem() {
        return coditem;
    }

    /**
     * Method 'setCoditem'
     *
     * @param coditem
     */
    public void setCoditem(Long coditem) {
        this.coditem = coditem;
    }

    /**
     * Method 'getQuantidade'
     *
     * @return Long
     */
    @Column(name = "QUANTIDADE")
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     * Method 'setQuantidade'
     *
     * @param quantidade
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Method 'getValor'
     *
     * @return Float
     */
    @Column(name = "VALOR")
    public Double getValor() {
        return valor;
    }

    /**
     * Method 'setValor'
     *
     * @param valor
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Method 'getHistorico'
     *
     * @return String
     */
    @Column(name = "HISTORICO")
    public String getHistorico() {
        return historico;
    }

    /**
     * Method 'setHistorico'
     *
     * @param historico
     */
    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(String devolucao) {
        this.devolucao = devolucao;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDataaquisicao() {
        return dataaquisicao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setDataaquisicao(Date dataaquisicao) {
        this.dataaquisicao = dataaquisicao;
    }

    
    
    
    
    /**
     * Method 'getCentrocustodepto'
     *
     * @return Centrocustodepto
     */
    @ManyToOne
    @JoinColumn(name = "CENTROCUSTODEPTO", insertable = true, updatable = true)
    public Centrocustodepto getCentrocustodepto() {
        return centrocustodepto;
    }

    /**
     * Method 'setCentrocustodepto'
     *
     * @param centrocustodepto
     */
    public void setCentrocustodepto(Centrocustodepto centrocustodepto) {
        this.centrocustodepto = centrocustodepto;
    }

    
    
    
    /**
     * Method 'getCentrocustosetor'
     *
     * @return Centrocustosetor
     */
    @ManyToOne
    @JoinColumn(name = "CENTROCUSTOSETOR", insertable = true, updatable = true)
    public Centrocustosetor getCentrocustosetor() {
        return centrocustosetor;
    }

    /**
     * Method 'setCentrocustosetor'
     *
     * @param centrocustosetor
     */
    public void setCentrocustosetor(Centrocustosetor centrocustosetor) {
        this.centrocustosetor = centrocustosetor;
    }

    /**
     * Method 'getEpi'
     *
     * @return Epi
     */
    @ManyToOne
    @JoinColumn(name = "CODEPI", insertable = true, updatable = true)
    public Epi getEpi() {
        return epi;
    }

    /**
     * Method 'setEpi'
     *
     * @param epi
     */
    public void setEpi(Epi epi) {
        this.epi = epi;
    }

  
    @OneToOne
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Column(name="ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    @Override
    public String toString() {
        return "Itensdevolvidos{" + "coditem=" + coditem + ", quantidade=" + quantidade + ", valor=" + valor + ", historico=" + historico + ", devolucao=" + devolucao + ", estado=" + estado + ", dataaquisicao=" + dataaquisicao + ", dataDevolucao=" + dataDevolucao + ", centrocustodepto=" + centrocustodepto + ", centrocustosetor=" + centrocustosetor + ", epi=" + epi + ", funcionario=" + funcionario + '}';
    }


    
    
    
    
    
    
}
