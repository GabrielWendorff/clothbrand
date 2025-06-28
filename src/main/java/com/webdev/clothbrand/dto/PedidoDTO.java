package com.webdev.clothbrand.dto;

import lombok.Data;
import java.util.List;

@Data
public class PedidoDTO {
    private Long clienteId;
    private List<ItemPedidoDTO> itens;
}