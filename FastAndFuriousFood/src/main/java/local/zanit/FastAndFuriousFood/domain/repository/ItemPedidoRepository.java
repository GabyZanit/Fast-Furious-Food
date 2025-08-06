/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.zanit.FastAndFuriousFood.domain.repository;

import local.zanit.FastAndFuriousFood.domain.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ppjatb
 */
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    
}
