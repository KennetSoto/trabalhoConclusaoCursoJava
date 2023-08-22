package br.com.crudComSpring.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.crudComSpring.model.Produto;
import br.com.crudComSpring.repository.ProdutoRepository;

@Controller
public class ProdutoControler {

	@Autowired
	// autowired, auto gerenciada pelo spring, O Spring procurará uma classe que
	// corresponda à propriedade no applicationContext e a injetará automaticamente.
	// produtorepository é chamado para ingestao de dependencia
	private ProdutoRepository produtoRepository;

	@GetMapping("/")
	public String paginaPrincipal() {
		return "index";
		// o spring identifica o index
	}

	@GetMapping("/produtos")
	public String listaProduto(Model requisicao) {
		// model faz a passagem do back para o front
		requisicao.addAttribute("valor", 33);
		return "produtos";
	}

	@GetMapping("/inserirProdutos")
	public String inserirProduto(Model model) {
		// para passar o que o thymeleaf vai encontrar no front-end
		model.addAttribute("frase", "Exemplo crud");
		return "inserirProdutos";
	}

	@GetMapping("/listagem_produtos")
	public String listarProdutos(Model model) {
		List<Produto> listaProdutos = produtoRepository.findAll();
		model.addAttribute("lista_produtos", listaProdutos);
		return "listagem_produtos";
	}
}