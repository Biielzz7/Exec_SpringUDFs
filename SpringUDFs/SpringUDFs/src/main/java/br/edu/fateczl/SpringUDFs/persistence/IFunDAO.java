package br.edu.fateczl.SpringUDFs.persistence;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.SpringUDFs.model.Funcionario;

public interface IFunDAO {

	public List<Funcionario> lista () throws SQLException, ClassNotFoundException;
	
	public float SomarSalario (int cod) throws SQLException, ClassNotFoundException;
}


