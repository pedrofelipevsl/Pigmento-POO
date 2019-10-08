package br.edu.ifba.ads.inf008.persistence.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.ads.inf008.exceptions.PigmentoException;
import br.edu.ifba.ads.inf008.model.entidades.CMYK;
import br.edu.ifba.ads.inf008.model.entidades.Pigmento;
import br.edu.ifba.ads.inf008.model.entidades.RGB;
import br.edu.ifba.ads.inf008.model.entidades.TipoCor;
import br.edu.ifba.ads.inf008.persistence.PigmentoDAO;

public class PigmentoSQLDAO extends AbstractConexionSQLDAO implements PigmentoDAO {
	
	private static final String UPDATE_ESTOQUE = 
			"UPDATE PIGMENTO " + 
			"SET estoque = ? " +
			"WHERE idPigmento = ?";
	
	private static final String SELECT_PIGMENTO_RGB = 
			"SELECT idPigmento, nome, estoque, preco, tipo, corR, corG, corB FROM PIGMENTO";
	
	private static final String SELECT_PIGMENTO_CMYK = 
			"SELECT idPigmento, nome, estoque, preco, tipo, corC, corM, corY, corK FROM PIGMENTO";
	
	private static final String SELECT_PIGMENTO = 
			"SELECT idPigmento, nome, estoque, preco, tipo, corR, corG, corB, corC, corM, corY, corK FROM PIGMENTO";
	
	@Override
	public boolean baixaDeEstoqueUpdate(Pigmento pigmento, Double quantidadeAtual) throws Exception {
		
		boolean deuCerto;
		
		try {
			
			PreparedStatement ps = this.getConnection().prepareStatement(PigmentoSQLDAO.UPDATE_ESTOQUE);
			ps.setDouble(1, quantidadeAtual);
			ps.setString(2, pigmento.getId());
			
			ps.executeUpdate();
			ps.close();
			
			deuCerto = true;
			
		} catch (Exception e) {
			deuCerto = false;
			throw new PigmentoException(e.getMessage()); // Falta criar a mensagem de excessão
		}
		
		return deuCerto;
	}

	@Override
	public List<Pigmento> buscarTodosPigmentos() throws Exception {
		List<Pigmento> pigmentos  = new ArrayList<>();
		
		try {
			
			PreparedStatement ps = this.getConnection().prepareStatement(PigmentoSQLDAO.SELECT_PIGMENTO);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				if (rs.getInt("tipo") == 1) {
					
					RGB p = new RGB();
					
					p.setId(rs.getString("idPigmento"));
					p.setNome(rs.getString("nome"));
					p.setEstoque(rs.getDouble("estoque"));
					p.setPreco(rs.getDouble("preco"));
					p.setTipo((rs.getInt("tipo") == 1) ? TipoCor.RGB : TipoCor.CMYK); //new
					p.setR(rs.getInt("corR"));
					p.setG(rs.getInt("corG"));
					p.setB(rs.getInt("corB"));
					
					pigmentos.add(p); // Adiciona um RGB ao Array de Pigmentos
				}else if (rs.getInt("tipo") == 2) {
				
					CMYK p = new CMYK();
					
					p.setId(rs.getString("idPigmento"));
					p.setNome(rs.getString("nome"));
					p.setEstoque(rs.getDouble("estoque"));
					p.setPreco(rs.getDouble("preco"));
					p.setTipo((rs.getInt("tipo") == 1) ? TipoCor.RGB : TipoCor.CMYK); //new
					p.setC(rs.getInt("corC"));
					p.setM(rs.getInt("corM"));
					p.setY(rs.getInt("corY"));
					p.setK(rs.getInt("corK"));
					
					pigmentos.add(p); // Adiciona um RGB ao Array de Pigmentos
					
					
				}
					
				
			}
			
		} catch (Exception e) {
			throw new PigmentoException(e.getMessage()); // Falta criar a mensagem de excessão
		} 
		
		
		return pigmentos;
	}
	
}
