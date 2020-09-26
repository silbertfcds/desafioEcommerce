package com.desafio.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.desafio.model.Produto;

@Service
public class JsoupService {

	/**Lê os produtos da site específico e converte para a entidade Produto
	 * @return Lista de Produtos
	 * @throws IOException
	 * @throws ParseException
	 */
	public List<Produto> converterProdutoJsoupParaProduto() throws IOException, ParseException {
		List<Produto> produtos = new ArrayList<>();
		
		Document pagina = Jsoup.connect("https://www.amazon.com.br/gp/bestsellers/books").get();

		Elements ol = pagina.select("ol.a-ordered-list.a-vertical");
		Elements li = ol.select("li.zg-item-immersion");

		for (Element element : li) {
			Produto produto = new Produto();
			
			String titulo = element.getElementsByClass("p13n-sc-truncate-mobile-type").text();
			String avaliacao = element.getElementsByClass("a-size-small a-link-normal").text();
			String preco = element.getElementsByClass("p13n-sc-price").text();
			String desconto = "";
			String link = "";
			
			produto.setNome(titulo);
			if(!avaliacao.trim().equals("")) {
				produto.setClassificacao(Long.parseLong(avaliacao.replaceAll("[^0-9]+", "")));
			}else {
				produto.setClassificacao(0);
			}
			produto.setPreco(new BigDecimal(preco.replaceAll("[^0-9]+", "")));
			BigDecimal valorDesconto = BigDecimal.ZERO;
			produto.setDesconto(valorDesconto);
			produto.setURL("https://www.amazon.com.br/gp/bestsellers/books");
			
			produtos.add(produto);
		}
		
		return produtos;

	}
	
	public static void main(String[] args) throws IOException {
		
		
		
	}
}
