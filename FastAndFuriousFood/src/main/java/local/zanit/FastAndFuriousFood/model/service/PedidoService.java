/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.gabriel.FastAndFuriousFood.model.service;


import java.util.List;
import local.gabriel.FastAndFuriousFood.domain.model.ItemPedido;
import local.gabriel.FastAndFuriousFood.domain.model.Pedido;
import local.gabriel.FastAndFuriousFood.domain.model.Produto;
import local.gabriel.FastAndFuriousFood.domain.model.StatusPedido;
import local.gabriel.FastAndFuriousFood.domain.repository.PedidoRepository;
import local.gabriel.FastAndFuriousFood.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ppjata
 */
@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public void excluir(long id) {
        pedidoRepository.deleteById(id);
    }
    
    public Pedido salvarPedido(Pedido pedido) {
    for (ItemPedido item : pedido.getItens()) {
        Produto produto = produtoRepository.findById(item.getProduto().getId())
            .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + item.getProduto().getId()));
        
        item.setProduto(produto);
        item.setPreco(produto.getPreco() * item.getQntd());
        item.setPedido(pedido); // importante!
        item.setPreco(produto.getPreco() * item.getQntd());
    }

    return pedidoRepository.save(pedido);
}
    
     public Pedido salvar(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
     
     public List<Pedido> buscarPorStatus(Enum status) {
        // Delega a busca ao método findByStatus do PedidoRepository
        return pedidoRepository.findByStatus(status);
    }
    
    }
