/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author aparicio da silva
 */

public class ClienteResources{
   @Autowired
    private ClienteRepositorio cli;
    
    
    @GetMapping(value = "/lista")
    public @ResponseBody  Iterable<Cliente> listaCliente() {
        Iterable<Cliente> listaCliente = cli.findAll();
        return listaCliente;
    }
   @PostMapping  
   public Cliente salvar(@RequestBody Cliente cliente){
       return Cliente.save(cliente);
   }
   @DeleteMapping("/{id}")
   public void deletar(Cliente cliente){
       Cliente.delete(cliente);
   }
}