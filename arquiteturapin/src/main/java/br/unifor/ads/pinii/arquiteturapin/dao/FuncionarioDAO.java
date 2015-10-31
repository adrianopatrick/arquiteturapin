package br.unifor.ads.pinii.arquiteturapin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unifor.ads.pinii.arquiteturapin.entity.Funcionarios;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;

public class FuncionarioDAO {
	
	private EntityManager em;
	
	public FuncionarioDAO() {
		this.em = new EntityManager() {
			
			@Override
			public Object trataResultSet(ResultSet rs) throws SQLException {
				Funcionarios funcionario = new Funcionarios();
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setSalario(rs.getDouble("salario"));
				return null;
			}
		};
	}
	
	public void salvar(Funcionarios funcionario) throws DAOException{
		em.execute("insert into funcionarios (nome, cpf, salario) values (?, ?, ?)",
				funcionario.getNome(), funcionario.getCpf(), funcionario.getSalario());
	}

}
