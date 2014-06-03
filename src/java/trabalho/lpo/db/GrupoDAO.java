/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.lpo.db;

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

     public void criar(Grupo grupoNovo) throws Exception{
        
            comandoCriar.setString(1, grupoNovo.getTitulo());
            comandoCriar.setString(2, grupoNovo.getDescricao());
            comandoCriar.setInt(3, grupoNovo.getFase());
            comandoCriar.setInt(3, grupoNovo.getCodProposta());
            comandoCriar.executeUpdate();
     
    }
}
