package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Chave;

public class ChaveDAO {

	private Connection connection;

	public ChaveDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserirSaida(Chave chave) {

		String sql = "insert into chave (nome, matricula, dataSaida) " + "values (?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, chave.getNome());
			stmt.setString(2, chave.getMatricula());
			stmt.setString(3, chave.getDataSaida());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean inserirEntrega(Chave chave) {
		String sql = "update chave set nomeEntregue=?, matriculaEntregue=?, dataEntregue=? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, chave.getNomeEntregue());
			stmt.setString(2, chave.getMatriculaEntregue());
			stmt.setString(3, chave.getDataEntregue());
			stmt.setLong(4, chave.getId());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Chave> getLista() {
		List<Chave> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from chave");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Chave chave = new Chave();
				chave.setId(rs.getLong("id"));
				chave.setNome(rs.getString("nome"));
				chave.setMatricula(rs.getString("matricula"));
				chave.setDataSaida(rs.getString("DataSaida"));
				chave.setNomeEntregue(rs.getString("NomeEntregue"));
				chave.setMatriculaEntregue(rs.getString("matriculaEntregue"));
				chave.setDataEntregue(rs.getString("dataEntregue"));

				// adicionando o objeto � lista
				result.add(chave);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Chave contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			/*stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());*/
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Chave chave) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from chave where id=?");
			stmt.setLong(1, chave.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Chave getById(Long id) {
		Chave result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from chave where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Contato
				result = new Chave();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nomeEntregue"));
				result.setNome(rs.getString("matriculaEntregue"));
				result.setNome(rs.getString("dataEntregue"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
