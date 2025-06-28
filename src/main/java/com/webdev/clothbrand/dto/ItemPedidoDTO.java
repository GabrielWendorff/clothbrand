package com.webdev.clothbrand.dto;

import lombok.Data;

@Data
public class ItemPedidoDTO {
    private Long roupaId;
    private int quantidade;
    private Double precoUnitario;
}