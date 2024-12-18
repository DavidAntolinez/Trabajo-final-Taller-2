package restcontroller.restcontroller.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restcontroller.restcontroller.Models.Dao.IUsuarioDao;
import restcontroller.restcontroller.Models.Entity.Usuario;


import org.springframework.web.bind.annotation.PostMapping;





@RestController
@RequestMapping("/API/usuario/")
public class UsuarioRestController {
    
//    @Autowired
//    IUsuarioDao usuarioDao;
//
//    @Autowired
//    JWTAuthtenticationConfig jwtAuthtenticationConfig;
//
//    @PostMapping("login")
//    public User postMethodName(@RequestParam("username") String username, @RequestParam("password") String pwd) {
//        //TODO: process POST request
//        String token;
//        if(Autenticar(new Usuario(pwd,username))){
//            token = jwtAuthtenticationConfig.getJWTToken(username);
//        }else
//            token = "Usuario o contraseña incorrectos";
//        return new User(username, pwd, token);
//    }
//
//    private boolean Autenticar(Usuario usuario){
//        List<Usuario> usuarios = usuarioDao.findAll();
//        for (Usuario usuario2 : usuarios) {
//            if(usuario2.getUsername().equals(usuario.getUsername()) && usuario2.getPassword().equals(usuario.getPassword()))
//                return true;
//        }
//        return false;
//    }
//
}
