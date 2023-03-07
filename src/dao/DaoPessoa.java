package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import bean.BeanPessoa;
import conexao.jdbc.ConexaoJdbc;

public class DaoPessoa {

	private static Connection connection = null;

	public DaoPessoa() {
		connection = ConexaoJdbc.getConnection();
	}

	public void salvar(BeanPessoa pessoa) throws Exception {
		try {
			String sql = "";

			sql = "INSERT INTO pessoa (nomepessoa, paipessoa, maepessoa, dtnascpessoa, cpfpessoa, rgpessoa) "
					+ "VALUES (?, ?, ?, ?, ?, ?);";

			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getPai());
			stmt.setString(3, pessoa.getMae());
			stmt.setDate(4, java.sql.Date.valueOf(LocalDate.parse(pessoa.getNascimentto(), dateTimeFormatter)));
			stmt.setString(5, pessoa.getCpf());
			stmt.setString(6, pessoa.getRg());

			stmt.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();

		}
	}

	public void atualizar(BeanPessoa pessoa) throws Exception {
		try {
			String sql = "";

			sql = "UPDATE pessoa SET nomepessoa=?, paipessoa=?, maepessoa=?, "
					+ "dtnascpessoa=?, cpfpessoa=?, rgpessoa=? WHERE idpessoa = ?;";

			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getPai());
			stmt.setString(3, pessoa.getMae());
			stmt.setDate(4, java.sql.Date.valueOf(LocalDate.parse(pessoa.getNascimentto(), dateTimeFormatter)));
			stmt.setString(5, pessoa.getCpf());
			stmt.setString(6, pessoa.getRg());
			stmt.setLong(7, pessoa.getId());

			stmt.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();

		}
	}

	public void deletar(long idpessoa) throws Exception {
		try {
			String sql = "";

			sql = "DELETE FROM pessoa WHERE idpessoa = ?;";

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, idpessoa);

			stmt.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();

		}
	}

	public List<BeanPessoa> listar() {

		try {
			List<BeanPessoa> pessoas = new ArrayList<BeanPessoa>();

			String sql = "SELECT p.idpessoa, p.nomepessoa, p.paipessoa, p.maepessoa, p.dtnascpessoa, "
					+ "p.cpfpessoa, p.rgpessoa FROM pessoa p;";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				BeanPessoa beanPessoa = new BeanPessoa();

				beanPessoa.setId(rs.getLong("idpessoa"));
				beanPessoa.setNome(rs.getString("nomepessoa"));
				beanPessoa.setPai(rs.getString("paipessoa"));
				beanPessoa.setMae(rs.getString("maepessoa"));
				beanPessoa.setNascimentto(rs.getString("dtnascpessoa"));
				beanPessoa.setCpf(rs.getString("cpfpessoa"));
				beanPessoa.setRg(rs.getString("rgpessoa"));
				pessoas.add(beanPessoa);
			}

			return pessoas;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
