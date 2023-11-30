package br.edu.fateczl.SpringUDFs.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.SpringUDFs.model.Funcionario;


@Repository
public class FunDao implements IFunDAO {
	
@Autowired	
private GenericDao GDao;

	@Override
	public List<Funcionario> lista() throws SQLException, ClassNotFoundException {
		Connection c = GDao.getConnection();
		 List<Funcionario> F = new ArrayList<>();
		 String sql = "SELECT * FROM fn_tableFUN()";
		 PreparedStatement ps = c.prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		 while (rs.next()) {
			Funcionario fun = new Funcionario();
			fun.setNomeFuncionario(rs.getString("nomeF"));
			fun.setNomeDependente(rs.getString("nomeD"));
			fun.setSalarioFun(rs.getFloat("salarioF"));
			fun.setSalarioDepen(rs.getFloat("salarioD"));
			F.add(fun);
		}
		 
		return F;
	}

	@Override
	public float SomarSalario(int cod) throws SQLException, ClassNotFoundException {
		Connection c = GDao.getConnection();
		float ValorTotal = 0;
		String sql = "SELECT dbo.fn_tableSoma(?)\r\n"
				+ "	AS ValorTotal";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, cod);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
				ValorTotal = rs.getFloat("ValorTotal");
		}
		
		return ValorTotal;
	}

}
