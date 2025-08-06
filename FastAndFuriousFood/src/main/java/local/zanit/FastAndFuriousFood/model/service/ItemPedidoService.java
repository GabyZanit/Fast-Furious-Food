/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.zanit.FastAndFuriousFood.model.service;

import java.util.List;
import local.zanit.FastAndFuriousFood.domain.model.ItemPedido;
import local.zanit.FastAndFuriousFood.domain.model.Produto;
import local.zanit.FastAndFuriousFood.domain.repository.ItemPedidoRepository;
import local.zanit.FastAndFuriousFood.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ppjata
 */

@Service
public class ItemPedidoService {
    
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public ItemPedido criar(ItemPedido itemPedido) {
        Long produtoId = itemPedido.getProduto().getId();
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto com ID" + produtoId + "não encontrado"));
         itemPedido.setProduto(produto);          
                   
        double precoTotal = produto.getPreco() * itemPedido.getQntd();
        itemPedido.setPreco(precoTotal);
        
        itemPedido.setPreco(precoTotal);
        
        return itemPedidoRepository.save(itemPedido);
    }
    
    public List<ItemPedido> findAll() {
        return itemPedidoRepository.findAll();
    }
    
    public void excluir(long id) {
        itemPedidoRepository.deleteById(id);
    }
    
}
