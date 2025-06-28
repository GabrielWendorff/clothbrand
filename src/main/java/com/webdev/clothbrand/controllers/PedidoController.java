package com.webdev.clothbrand.controllers;

import com.webdev.clothbrand.dto.ItemPedidoDTO;
import com.webdev.clothbrand.dto.PedidoDTO;
import com.webdev.clothbrand.model.*;
import com.webdev.clothbrand.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired private PedidoRepository pedidoRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private RoupaRepository roupaRepository;

    // Criar novo pedido
    @PostMapping
    public Pedido criarPedido(@RequestBody PedidoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        List<ItemPedido> itens = new ArrayList<>();
        double total = 0.0;

        for (ItemPedidoDTO itemDTO : dto.getItens()) {
            Roupa roupa = roupaRepository.findById(itemDTO.getRoupaId())
                    .orElseThrow(() -> new RuntimeException("Roupa não encontrada"));

            ItemPedido item = new ItemPedido();
            item.setPedido(pedido);
            item.setRoupa(roupa);
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPrecoUnitario(itemDTO.getPrecoUnitario());
            itens.add(item);

            total += itemDTO.getPrecoUnitario() * itemDTO.getQuantidade();
        }

        pedido.setItens(itens);
        pedido.setTotal(total);
        return pedidoRepository.save(pedido);
    }

    // Listar todos os pedidos
    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    // Buscar pedido por ID
    @GetMapping("/{id}")
    public Pedido buscarPedidoPorId(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    // Atualizar um pedido existente
    @PutMapping("/{id}")
    public Pedido atualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO dto) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        pedido.setCliente(cliente);

        pedido.getItens().clear();

        List<ItemPedido> novosItens = new ArrayList<>();
        double total = 0.0;

        for (ItemPedidoDTO itemDTO : dto.getItens()) {
            Roupa roupa = roupaRepository.findById(itemDTO.getRoupaId())
                    .orElseThrow(() -> new RuntimeException("Roupa não encontrada"));

            ItemPedido item = new ItemPedido();
            item.setPedido(pedido);
            item.setRoupa(roupa);
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPrecoUnitario(itemDTO.getPrecoUnitario());
            novosItens.add(item);

            total += itemDTO.getPrecoUnitario() * itemDTO.getQuantidade();
        }

        pedido.setItens(novosItens);
        pedido.setTotal(total);

        return pedidoRepository.save(pedido);
    }

    // Deletar pedido por ID
    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado");
        }
        pedidoRepository.deleteById(id);
    }
}