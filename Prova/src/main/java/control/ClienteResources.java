/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.util.Optional;
import javax.validation.Valid;
import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

       @PostMapping(value = "/adiciona")
    public Cliente cadastraVeiculo(@RequestBody @Valid Cliente oCliente) {
        return cli.save(oCliente);
    }
    /*
   @DeleteMapping("/{id}")
   public void deletar(Cliente cliente){
       Cliente.delete(cliente);
   }*/
   
    @PutMapping(value = "/modifica/{id}")
    public ResponseEntity<Cliente> modificaCliente(@PathVariable("id") Long id, @RequestBody Cliente oCliente) {
        Optional<Cliente> clienteInfo = cli.findById(id);
        
        if (clienteInfo.isPresent()) {
            Cliente clienteAtual = clienteInfo.get();
      

          
            cli.save(clienteAtual);
            return ResponseEntity.ok(clienteAtual);
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }
}