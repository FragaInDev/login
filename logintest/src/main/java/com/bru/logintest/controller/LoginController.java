package com.bru.logintest.controller;

import com.bru.logintest.model.Usuario;
import com.bru.logintest.persistence.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UsuarioDAO uDao;

    @RequestMapping(name = "index", value = "/index", method = RequestMethod.GET)
    public ModelAndView init(ModelMap model){
        return new ModelAndView("index");
    }

    @RequestMapping(name = "index", value = "/index", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam Map<String, String> params, ModelMap model) throws SQLException, ClassNotFoundException {
        Usuario u = new Usuario();

        String email = params.get("email");
        String senha = params.get("senha");
        String botao = params.get("btn");

        String modelName = "";

        if (botao.equalsIgnoreCase("logar")){
            u = uDao.getLogin(email, senha);
            
            System.out.println(u.getEmail());
            

            if (u.getTipo().equalsIgnoreCase("G")){
                modelName = "gestor";
            }else if (u.getTipo().equalsIgnoreCase("A")){
                modelName = "atendente";
            }else if (u.getTipo().equalsIgnoreCase("M")){
                modelName = "medico";
            }else if (u.getTipo().equalsIgnoreCase("P")){
                modelName = "paciente";
            }
        }

        return new ModelAndView(modelName);
    }
}
