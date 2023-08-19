package br.com.crudComSpring.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.crudComSpring.repository.ProdutoRepository;



@Controller
public class ProdutoControler {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/")
	public String paginaPrincipal() {
		return "index";
	}

	@GetMapping("/produtos")
	public String listaProduto(Model requisicao) {
		requisicao.addAttribute("valor",33);
		return "produto";
}
}