package com.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.model.Produto;
import com.desafio.service.ProdutoService;

@RestController
@RequestMapping("/api")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/salvarProdutos")
	private String salvarProdutos() {
		try {
			produtoService.salvarProdutosViaJsoup();
		} catch(Exception e) {
			return "Erro ao salvar os produtos";
		}
		
		return "Produtos cadastrados com sucesso";
	}
	
	/**Lista os produtos com menor preço, melhor avaliado e maior desconto.
	 * @return produtos
	 */
	@GetMapping("/produtos")
	private List<Produto> listarProdutosFilter() {
		return produtoService.listarProdutosFilter();
	}
	
	@GetMapping("/produto/menorPreco")
	private Produto getProdutoMaisBarato(){
		return produtoService.getProdutoMaisBarato();
	}
	
	@GetMapping("/produto/melhorAvaliado")
	private Produto getProdutoMelhorAvaliado(){
		return produtoService.getProdutoMelhorAvaliado();
	}
	
	@GetMapping("/produto/maiorDesconto")
	private Produto getProdutoMaiorDesconto(){	
		return produtoService.getProdutoMaiorDesconto();
	}
	
	/**Lista todos os produtos cadastrados
	 * @return produtos
	 */
	private List<Produto> todosProdutos() {
		return produtoService.todosProdutos();
	}
	
}
