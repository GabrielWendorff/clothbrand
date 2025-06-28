package com.webdev.clothbrand.dto;

import lombok.Data;

@Data
public class RoupaDTO {
    private String nome;
    private String tamanho;
    private Double preco;
    private int tipoId;
	public Object getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}
	public Object getTamanho() {
		// TODO Auto-generated method stub
		return this.tamanho;
	}
	public Object getPreco() {
		// TODO Auto-generated method stub
		return this.preco;
	}
	public int getTipoId() {
		// TODO Auto-generated method stub
		return this.tipoId;
	}
}
