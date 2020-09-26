package com.desafio.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.model.Produto;
import com.desafio.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private JsoupService jsoupService;
	
	
	public List<Produto> listarProdutosFilter() {
		return Arrays.asList(getProdutoMaisBarato(),getProdutoMelhorAvaliado(),getProdutoMaiorDesconto());
	}
	
	public Produto getProdutoMaisBarato(){
		Produto produtoMenorPreco = todosProdutos()
			      .stream()
			      .min(Comparator.comparing(Produto::getPreco))
			      .orElseThrow(NoSuchElementException::new);
		
		return produtoMenorPreco;
	}
	
	public Produto getProdutoMelhorAvaliado(){
		Produto produtoMelhorAvaliado = todosProdutos()
			      .stream()
			      .max(Comparator.comparing(Produto::getClassificacao))
			      .orElseThrow(NoSuchElementException::new);
		
		return produtoMelhorAvaliado;
	}
	
	public Produto getProdutoMaiorDesconto(){	
		Produto produtoMaiorDesconto = todosProdutos()
			      .stream()
			      .max(Comparator.comparing(Produto::getDesconto))
			      .orElseThrow(NoSuchElementException::new);
		
		return produtoMaiorDesconto;
	}
	
	/**Lista todos os produtos cadastrados
	 * @return produtos
	 */
	public List<Produto> todosProdutos() {
		return produtoRepository.findAll();
	}
	
	/**
	 * Persiste no banco de dados os produtos que já foram pegos pelos Jsoup
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public void salvarProdutosViaJsoup() throws IOException, ParseException {
		List<Produto> produtos = jsoupService.converterProdutoJsoupParaProduto();
		produtoRepository.saveAll(produtos);
	}
	
	
}
