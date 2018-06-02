package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;

import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "ITENSADQUIRIDOS")
public class Itensadquiridos implements Serializable {

    protected Long coditem;
    protected Integer quantidade;
    protected Double valor;
    protected String historico;
    protected Date dataaquisicao;
    protected Centrocustosetor centrocustosetor;
    protected Epi epi;
    public Funcionario funcionario;
    

    /**
     * Method 'Itensadquiridos'
     *
     */
    public Itensadquiridos() {
    }

    public Itensadquiridos(Long coditem, Integer quantidade, Double valor, String historico, Date dataaquisicao, Centrocustosetor centrocustosetor, Epi epi, Funcionario funcionario) {
        this.coditem = coditem;
        this.quantidade = quantidade;
        this.valor = valor;
        this.historico = historico;
        this.dataaquisicao = dataaquisicao;
        this.centrocustosetor = centrocustosetor;
        this.epi = epi;
        this.funcionario = funcionario;
    }

    
    

    /**
     * Method 'getCoditem'
     *
     * @return Long
     */
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

    @ManyToOne
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDataaquisicao() {
        return dataaquisicao;
    }

    public void setDataaquisicao(Date dataaquisicao) {
        this.dataaquisicao = dataaquisicao;
    }

    @Override
    public String toString() {
        return "Itensadquiridos{" + "coditem=" + coditem + ", quantidade=" + quantidade + ", valor=" + valor + ", historico=" + historico + ", dataaquisicao=" + dataaquisicao + ", centrocustosetor=" + centrocustosetor + ", epi=" + epi + ", funcionario=" + funcionario + '}';
    }

    
}
