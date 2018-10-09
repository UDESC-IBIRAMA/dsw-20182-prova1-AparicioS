/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author aparicio da silva
 */

public class ClienteResources{
  
    
    private Cliente cli;
    
    
        @GetMapping(value = "/lista")
    public @ResponseBody
    Iterable<Veiculo> listaVeiculos() {
        Iterable<Veiculo> listaVeiculos = vr.findAll();
        return listaVeiculos;
    }
   
  
}