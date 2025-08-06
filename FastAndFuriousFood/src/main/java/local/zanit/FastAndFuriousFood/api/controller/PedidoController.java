/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.zanit.FastAndFuriousFood.api.controller;

import java.util.List;
import java.util.Optional;
import local.zanit.FastAndFuriousFood.DTO.ProdutoStatusDTO;
import local.zanit.FastAndFuriousFood.domain.model.ItemPedido;
import local.zanit.FastAndFuriousFood.domain.model.Pedido;
import local.zanit.FastAndFuriousFood.domain.model.Produto;
import local.zanit.FastAndFuriousFood.domain.model.StatusPedido;
import local.zanit.FastAndFuriousFood.domain.repository.PedidoRepository;
import local.zanit.FastAndFuriousFood.model.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.projection.EntityProjection.ProjectionType.DTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.status;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ppjatb
 */
@RestController
@RequestMapping("/fastfurious")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping("/pedido")
    public List<Pedido> listas() {
        return pedidoRepository.findAll();
    }
    
    @GetMapping("/pedido/{id}")
     public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        
        if(pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        }else {
            return ResponseEntity.notFound().build();
        }
     }
     
     @PostMapping("/pedido")
     public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoSalvo = pedidoService.salvarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }
    
    @DeleteMapping("pedido/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        pedidoService.excluir(id);
        return new ResponseEntity(HttpStatus.OK);

    }
    
    @PutMapping("/pedido/{id}")
    public ResponseEntity<Pedido> atualizar(@PathVariable Long id,
                                        @RequestBody Pedido pedidoAtualizado) {
    Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

    if (pedidoOptional.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    Pedido pedidoExistente = pedidoOptional.get();
    pedidoExistente.setStatus(pedidoAtualizado.getStatus());
    pedidoExistente.getItens().clear();

    for (ItemPedido item : pedidoAtualizado.getItens()) {
        item.setPedido(pedidoExistente);
        pedidoExistente.getItens().add(item);
    }

    Pedido pedidoSalvo = pedidoRepository.save(pedidoExistente);
    
    return ResponseEntity.ok(pedidoSalvo);
}
    
    
    @GetMapping("/pedido/status/{status}")
    public ResponseEntity<Pedido> buscarPorStatus(@PathVariable StatusPedido status) {
        Optional<Pedido> pedido = pedidoRepository.findByStatus(status);
        
        if(pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        }else {
            return ResponseEntity.notFound().build();
        }
     }
    
    @PutMapping("pedido/status/{id}")
    public ResponseEntity<Pedido> atualizarStatus(
        @PathVariable Long id,
        @RequestBody ProdutoStatusDTO statusDTO) {

    Pedido pedido = pedidoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

    pedido.setStatus(statusDTO.getStatus());
    pedidoRepository.save(pedido);

    return ResponseEntity.ok(pedido);
    }
    }
