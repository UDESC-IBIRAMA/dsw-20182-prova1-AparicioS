/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author aparicio da silva
 */
public interface ClienteRepositorio extends JpaRepository<Cliente,Long>  {
    
}
