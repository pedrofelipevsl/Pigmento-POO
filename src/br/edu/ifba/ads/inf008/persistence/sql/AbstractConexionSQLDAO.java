package br.edu.ifba.ads.inf008.persistence.sql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractConexionSQLDAO {
	
	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	private static final String URI = "jdbc:postgresql://localhost:5432/Pigmento";
	private static final String USER = "postgres";
	private static final String PWD = ""; // setar a senha conforme esteja no POSTGRE DO SEU computador
	
	
	@SuppressWarnings("deprecation")
	public Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		DriverManager.registerDriver((Driver)(Class.forName(AbstractConexionSQLDAO.JDBC_DRIVER).newInstance()));
		return DriverManager.getConnection(AbstractConexionSQLDAO.URI, AbstractConexionSQLDAO.USER , AbstractConexionSQLDAO.PWD);
	}
	
}