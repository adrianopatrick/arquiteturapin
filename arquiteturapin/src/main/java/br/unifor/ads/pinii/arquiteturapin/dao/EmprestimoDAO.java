package br.unifor.ads.pinii.arquiteturapin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unifor.ads.pinii.arquiteturapin.entity.Emprestimo;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;

public class EmprestimoDAO {

	private EntityManager em;

	public EmprestimoDAO() {
		em = new EntityManager() {
			@Override
			public Emprestimo trataResultSet(ResultSet rs) throws SQLException {
				Emprestimo emprestimo = new Emprestimo();
				emprestimo.setId(rs.getInt("id"));
				emprestimo.setColega(rs.getString("colega"));
				emprestimo.setCoisa(rs.getString("coisa"));
				emprestimo.setDataEmprestimo(rs.getDate("data_emprestimo"));
				emprestimo.setDataPrevisao(rs.getDate("data_previsao"));
				emprestimo.setDataDevolucao(rs.getDate("data_devolucao"));

				return emprestimo;
			}
		};
	}

	public void salvar(Emprestimo emprestimo) throws DAOException {
		String sql = "insert into emprestimo(colega, coisa, data_emprestimo, data_previsao) values (?, ?, ?, ?)";
		em.execute(sql, emprestimo.getColega(), emprestimo.getCoisa(), emprestimo.getDataEmprestimo(),
				emprestimo.getDataPrevisao());
	}
}
