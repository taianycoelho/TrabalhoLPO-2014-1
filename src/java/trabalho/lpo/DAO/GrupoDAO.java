/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.lpo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import trabalho.lpo.classes.Grupo;
import trabalho.lpo.db.ConexaoDB;

/**
 *
 * @author curso
 */
public class GrupoDAO {
    
    
     private static Connection conexao = null;
    private static PreparedStatement comandoCriar;
    
    public GrupoDAO() throws Exception{
         conexao = ConexaoDB.getConnection();
        
        comandoCriar = conexao.prepareStatement("INSERT INTO grupo (titulo, descricao, fase, cod_proposta) VALUES(?,?,?,?)");
    }

     public void criar(Grupo compraNova) throws Exception{
        
            comandoCriar.setString(1, compraNova.getTitulo());
            comandoCriar.setString(2, compraNova.getDescricao());
            comandoCriar.setInt(3, compraNova.getFase());
            comandoCriar.setInt(3, compraNova.getCodProposta());
            comandoCriar.executeUpdate();
     
    }
}
