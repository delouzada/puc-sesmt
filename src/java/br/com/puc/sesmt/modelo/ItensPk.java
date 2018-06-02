package br.com.puc.sesmt.modelo;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.*;

/** 
 * This class represents the primary key of the ITENS table.
 */
@Embeddable
public class ItensPk implements Serializable
{
	protected Long codnotafiscal;

	protected Long iditem;

	/** 
	 * Sets the value of codnotafiscal
	 */
	public void setCodnotafiscal(Long codnotafiscal)
	{
		this.codnotafiscal = codnotafiscal;
	}

	/** 
	 * Gets the value of codnotafiscal
	 */
	public Long getCodnotafiscal()
	{
		return codnotafiscal;
	}

	/** 
	 * Sets the value of iditem
	 */
	public void setIditem(Long iditem)
	{
		this.iditem = iditem;
	}

	/** 
	 * Gets the value of iditem
	 */
	public Long getIditem()
	{
		return iditem;
	}

	/**
	 * Method 'ItensPk'
	 * 
	 */
	public ItensPk()
	{
	}

	/**
	 * Method 'ItensPk'
	 * 
	 * @param codnotafiscal
	 * @param iditem
	 */
	public ItensPk(final Long codnotafiscal, final Long iditem)
	{
		this.codnotafiscal = codnotafiscal;
		this.iditem = iditem;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof ItensPk)) {
			return false;
		}
		
		final ItensPk _cast = (ItensPk) _other;
		if (codnotafiscal == null ? _cast.codnotafiscal != codnotafiscal : !codnotafiscal.equals( _cast.codnotafiscal )) {
			return false;
		}
		
		if (iditem == null ? _cast.iditem != iditem : !iditem.equals( _cast.iditem )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		if (codnotafiscal != null) {
			_hashCode = 29 * _hashCode + codnotafiscal.hashCode();
		}
		
		if (iditem != null) {
			_hashCode = 29 * _hashCode + iditem.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "be.com.puc.sesmt.modelo.ItensPk: " );
		ret.append( "codnotafiscal=" + codnotafiscal );
		ret.append( ", iditem=" + iditem );
		return ret.toString();
	}

}
