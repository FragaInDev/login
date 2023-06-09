package com.bru.logintest.persistence;

import com.bru.logintest.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UsuarioDAO {

    @Autowired
    private GenericDAO gDao;

    public Usuario getLogin(String email, String senha) throws SQLException, ClassNotFoundException{
        Usuario u = new Usuario();

        Connection c = gDao.getConnection();
        String sql = "SELECT email, senha, tipo FROM usuario WHERE email= ? AND senha = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();

        try{
        	while (rs.next()) {
        		u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                u.setTipo(rs.getString("tipo"));
        	}
        	
        	rs.close();
        	ps.close();
        	c.close();
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return u;
    }
}
