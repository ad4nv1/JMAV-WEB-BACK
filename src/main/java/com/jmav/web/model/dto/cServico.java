package com.jmav.web.model.dto;

public class cServico { 
	
	private int Codigo;
	private double Valor;
	private int PrazoEntrega;
	private double ValorSemAdicionais;
	private double ValorMaoPropria;
	private double ValorAvisoRecebimento;
	private double ValorValorDeclarado;
	private String EntregaDomiciliar;
	private String EntregaSabado;
	private Object obsFim;
	private int Erro;
	private Object MsgErro;
	
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public double getValor() {
		return Valor;
	}
	public void setValor(double valor) {
		Valor = valor;
	}
	public int getPrazoEntrega() {
		return PrazoEntrega;
	}
	public void setPrazoEntrega(int prazoEntrega) {
		PrazoEntrega = prazoEntrega;
	}
	public double getValorSemAdicionais() {
		return ValorSemAdicionais;
	}
	public void setValorSemAdicionais(double valorSemAdicionais) {
		ValorSemAdicionais = valorSemAdicionais;
	}
	public double getValorMaoPropria() {
		return ValorMaoPropria;
	}
	public void setValorMaoPropria(double valorMaoPropria) {
		ValorMaoPropria = valorMaoPropria;
	}
	public double getValorAvisoRecebimento() {
		return ValorAvisoRecebimento;
	}
	public void setValorAvisoRecebimento(double valorAvisoRecebimento) {
		ValorAvisoRecebimento = valorAvisoRecebimento;
	}
	public double getValorValorDeclarado() {
		return ValorValorDeclarado;
	}
	public void setValorValorDeclarado(double valorValorDeclarado) {
		ValorValorDeclarado = valorValorDeclarado;
	}
	public String getEntregaDomiciliar() {
		return EntregaDomiciliar;
	}
	public void setEntregaDomiciliar(String entregaDomiciliar) {
		EntregaDomiciliar = entregaDomiciliar;
	}
	public String getEntregaSabado() {
		return EntregaSabado;
	}
	public void setEntregaSabado(String entregaSabado) {
		EntregaSabado = entregaSabado;
	}
	public Object getObsFim() {
		return obsFim;
	}
	public void setObsFim(Object obsFim) {
		this.obsFim = obsFim;
	}
	public int getErro() {
		return Erro;
	}
	public void setErro(int erro) {
		Erro = erro;
	}
	public Object getMsgErro() {
		return MsgErro;
	}
	public void setMsgErro(Object msgErro) {
		MsgErro = msgErro;
	}
			

}
