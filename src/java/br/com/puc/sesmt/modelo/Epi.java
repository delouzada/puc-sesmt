package br.com.puc.sesmt.modelo;

import java.util.*;
import java.io.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EPI")
public class Epi implements Serializable {

    protected Long codepi;
    protected Long ca;
    protected String origemepi;
    protected String descricaoepi;
    protected Integer quantidade;
    protected String tamanho;
    protected Double valorunitario;
    protected Date validadeca;
    protected Integer quantminima;
    protected String nomeepi;
    protected String epiprotege;
    private List<Riscos> riscos;

    /**
     * Method 'Epi'
     *
     */
    public Epi() {
    }

    public Epi(Long codepi, Long ca, String origemepi, String descricaoepi, Integer quantidade, String tamanho, Double valorunitario, Date validadeca, Integer quantminima, String nomeepi, String epiprotege) {
        this.codepi = codepi;
        this.ca = ca;
        this.origemepi = origemepi;
        this.descricaoepi = descricaoepi;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
        this.valorunitario = valorunitario;
        this.validadeca = validadeca;
        this.quantminima = quantminima;
        this.nomeepi = nomeepi;
        this.epiprotege = epiprotege;
    }

    /**
     * Method 'getCodepi'
     *
     * @return Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODEPI")
    public Long getCodepi() {
        return codepi;
    }

    /**
     * Method 'setCodepi'
     *
     * @param codepi
     */
    public void setCodepi(Long codepi) {
        this.codepi = codepi;
    }

    /**
     * Method 'getCa'
     *
     * @return Long
     */
    @Column(name = "CA")
    public Long getCa() {
        return ca;
    }

    /**
     * Method 'setCa'
     *
     * @param ca
     */
    public void setCa(Long ca) {
        this.ca = ca;
    }

    /**
     * Method 'getOrigemepi'
     *
     * @return String
     */
    @Column(name = "ORIGEMEPI")
    public String getOrigemepi() {
        return origemepi;
    }

    /**
     * Method 'setOrigemepi'
     *
     * @param origemepi
     */
    public void setOrigemepi(String origemepi) {
        this.origemepi = origemepi;
    }

    /**
     * Method 'getDescricaoepi'
     *
     * @return String
     */
    @Column(name = "DESCRICAOEPI")
    public String getDescricaoepi() {
        return descricaoepi;
    }

    /**
     * Method 'setDescricaoepi'
     *
     * @param descricaoepi
     */
    public void setDescricaoepi(String descricaoepi) {
        this.descricaoepi = descricaoepi;
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
     * Method 'getTamanho'
     *
     * @return String
     */
    @Column(name = "TAMANHO")
    public String getTamanho() {
        return tamanho;
    }

    /**
     * Method 'setTamanho'
     *
     * @param tamanho
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Method 'getValorunitario'
     *
     * @return Float
     */
    @Column(name = "VALORUNITARIO")
    public Double getValorunitario() {
        return valorunitario;
    }

    /**
     * Method 'setValorunitario'
     *
     * @param valorunitario
     */
    public void setValorunitario(Double valorunitario) {
        this.valorunitario = valorunitario;
    }

    /**
     * Method 'getValidadeca'
     *
     * @return Date
     */
    @Column(name = "VALIDADECA")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getValidadeca() {
        return validadeca;
    }

    /**
     * Method 'setValidadeca'
     *
     * @param validadeca
     */
    public void setValidadeca(Date validadeca) {
        this.validadeca = validadeca;
    }

    /**
     * Method 'getQuantminima'
     *
     * @return Long
     */
    @Column(name = "QUANTMINIMA")
    public Integer getQuantminima() {
        return quantminima;
    }

    /**
     * Method 'setQuantminima'
     *
     * @param quantminima
     */
    public void setQuantminima(Integer quantminima) {
        this.quantminima = quantminima;
    }

    /**
     * Method 'getNomeepi'
     *
     * @return String
     */
    @Column(name = "NOMEEPI")
    public String getNomeepi() {
        return nomeepi;
    }

    /**
     * Method 'setNomeepi'
     *
     * @param nomeepi
     */
    public void setNomeepi(String nomeepi) {
        this.nomeepi = nomeepi;
    }

    /**
     * Method 'getEpiprotege'
     *
     * @return String
     */
    @Column(name = "EPIPROTEGE")
    public String getEpiprotege() {
        return epiprotege;
    }

    /**
     * Method 'setEpiprotege'
     *
     * @param epiprotege
     */
    public void setEpiprotege(String epiprotege) {
        this.epiprotege = epiprotege;
    }

    @OneToMany(mappedBy = "epi", cascade= CascadeType.REMOVE)
    public List<Riscos> getRiscos() {
        return riscos;
    }

    public void setRiscos(List<Riscos> riscos) {
        this.riscos = riscos;
    }

    @Override
    public String toString() {
        return "Epi{" + "codepi=" + codepi + ", ca=" + ca + ", origemepi=" + origemepi + ", descricaoepi=" + descricaoepi + ", quantidade=" + quantidade + ", tamanho=" + tamanho + ", valorunitario=" + valorunitario + ", validadeca=" + validadeca + ", quantminima=" + quantminima + ", nomeepi=" + nomeepi + ", epiprotege=" + epiprotege + '}';
    }
}
