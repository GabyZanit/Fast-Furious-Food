/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.gabriel.FastAndFuriousFood.domain.repository;

import java.util.List;
import java.util.Optional;
import local.gabriel.FastAndFuriousFood.domain.model.Pedido;
import local.gabriel.FastAndFuriousFood.domain.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ppjata
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    Optional<Pedido> findByStatus(StatusPedido status);
    
    List<Pedido> findByStatus(Enum status);
}
