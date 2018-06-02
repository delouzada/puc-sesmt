package br.com.puc.sesmt.Interface;

import java.util.List;


public interface  IDaoGeneric<E> {
	

	
	public void save(E obj)throws Exception;
	public void delete(E obj)throws Exception;
	public void update(E obj)throws Exception;

	public E findByCod(Long id)throws Exception;
	public List<E> findAll()throws Exception;
	
	
	
	

}
