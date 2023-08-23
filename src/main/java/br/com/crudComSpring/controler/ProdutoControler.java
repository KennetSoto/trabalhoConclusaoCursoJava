package br.com.crudComSpring.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
		List<Produto> produto = produtoRepository.findAll();
		model.addAttribute("lista_produtos", produto);
		return "listagem_produtos";
	}
	
	//get mappimg pega o endereço d pagina
	@GetMapping("/cadastrarProduto")
	public String paginaAdicionarProduto (Produto produto) {
		return "adicionar_produtos";
	}
		
	@PostMapping("/adicionar_produtos")
	public String adicionarProduto (@Valid Produto produto,
		Errors erros, BindingResult result, Model model) {
		if (result.hasErrors() || (null != erros && erros.getErrorCount()> 0)) {
			return "adicionar_produtos";
		}
		produtoRepository.save(produto);
		return "redirect:/produtos";
	}
	
}