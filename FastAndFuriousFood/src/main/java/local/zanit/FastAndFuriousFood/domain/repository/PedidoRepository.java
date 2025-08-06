/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.zanit.FastAndFuriousFood.domain.repository;

import java.util.List;
import java.util.Optional;
import local.zanit.FastAndFuriousFood.domain.model.Pedido;
import local.zanit.FastAndFuriousFood.domain.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ppjatb
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    Optional<Pedido> findByStatus(StatusPedido status);
    
    List<Pedido> findByStatus(Enum status);
}
