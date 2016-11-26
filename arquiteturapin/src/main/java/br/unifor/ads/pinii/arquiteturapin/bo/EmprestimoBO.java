package br.unifor.ads.pinii.arquiteturapin.bo;

import org.apache.log4j.Logger;

import br.unifor.ads.pinii.arquiteturapin.dao.EmprestimoDAO;
import br.unifor.ads.pinii.arquiteturapin.entity.Emprestimo;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;

public class EmprestimoBO {
	
	private Logger logger = Logger.getLogger(EmprestimoBO.class);
	private EmprestimoDAO emprestimoDAO;

	public void salvar(Emprestimo emprestimo) throws DAOException {
		try {
			emprestimoDAO.salvar(emprestimo);
		} catch (DAOException e) {
			new DAOException("Não foi possível realizar o emprestimo.");
		}
	}
	
	
	
	
}
