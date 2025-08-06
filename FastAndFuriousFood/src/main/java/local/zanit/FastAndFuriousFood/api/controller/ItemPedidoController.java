/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.zanit.FastAndFuriousFood.api.controller;

import java.util.List;
import local.zanit.FastAndFuriousFood.domain.model.ItemPedido;
import local.zanit.FastAndFuriousFood.model.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ppjatb
 */
@RestController
@RequestMapping("/fastfurious")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoService itemPedidoService;
    
    @PostMapping("/item-pedido")
    public ItemPedido criar(@RequestBody ItemPedido itemPedido){
        return itemPedidoService.criar(itemPedido);
    }
    
    @GetMapping("/item-pedido")
    public ResponseEntity<List<ItemPedido>> listarTodos() {
        List<ItemPedido> itemPedido = itemPedidoService.findAll();
        if (itemPedido.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(itemPedido);
        }
    
    }
    
    @DeleteMapping("item-pedido/{id}")
    public ResponseEntity<Void> excluir(@PathVariable long id) {
        itemPedidoService.excluir(id);
        return new ResponseEntity(HttpStatus.OK);

    }
}
