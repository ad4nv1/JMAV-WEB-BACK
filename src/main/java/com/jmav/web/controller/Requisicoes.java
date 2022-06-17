package com.jmav.web.controller;


import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.jmav.web.model.dto.Servicos;

@RestController
@RequestMapping("/requisicao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Requisicoes {
	
	
	@PostMapping("/consultarCEP")
	public ResponseEntity consultarPreco(@Valid @RequestBody String cep) {
			String url = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?nCdEmpresa=08082650&sDsSenha=564321&sCepOrigem=53441310&sCepDestino="+cep+"&nVlPeso=1&nCdFormato=1&nVlComprimento=20&nVlAltura=20&nVlLargura=20&sCdMaoPropria=n&nVlValorDeclarado=0&sCdAvisoRecebimento=n&nCdServico=04510&nVlDiametro=0&StrRetorno=xml&nIndicaCalculo=3";
			Servicos s = new Servicos();
			RestTemplate requisicao = new RestTemplate();
			String resposta = requisicao.getForObject(url, String.class);
			return ResponseEntity.status(HttpStatus.OK).body(resposta);
	}
	
	
}

