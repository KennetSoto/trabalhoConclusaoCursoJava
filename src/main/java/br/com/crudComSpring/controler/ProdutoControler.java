package br.com.crudComSpring.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/cadastro")
	public String paginaAdicionarProduto (Produto produto) {
		return "cadastro";
	}
		
	@PostMapping("/adicionarAluno")
	public String adicionarProduto (@Valid Produto produto,
		Errors erros, BindingResult result, Model model) {
		if (result.hasErrors() || (null != erros && erros.getErrorCount()> 0)) {
			return "cadastro";
		}
		produtoRepository.save(produto);
		return "redirect:/aluno";
	}
	

    @GetMapping("/aluno/{id}")
    public String showProduto(@PathVariable("id") Long id, Model model) {
        Optional<Produto> produto = produtoRepository.findById(id);
        model.addAttribute("produto", produto);
        return "aluno";
    }	
    
    @GetMapping("/cursos")
	public String paginaDeCursos (Produto produto) {
		return "cursos";
	}
	
	//get mappimg pega o endereço d pagina
	@GetMapping("/aluno")
	public String listaCursos(Model model) {
	    List<Produto> produto = produtoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	    model.addAttribute("produtos", produto);
	    return "aluno";
	}
		

	@GetMapping("/editar/{id}")
	public String paginaAtualizarProduto(
			@PathVariable("id") long id, Model model) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> 
				new IllegalArgumentException("Identificador do produto é inválido" + id));
		
		model.addAttribute("produto", produto);
		return "editarcadastro";
	}
	
		
	@PostMapping("/atualizar/{id}")
	public String atualizarProduto(@PathVariable("id") long id,
			@Valid Produto produto, BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			produto.setId(id);
			return "editar_cadastro";
		}
		produtoRepository.save(produto);
		return "redirect:/aluno";
	}
	
	@GetMapping("/delete/{id}")
	public String deletarProduto(
			@PathVariable("id") long id, Model model) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(()-> 
				new IllegalArgumentException("Identificador do produto inválido" + id));
		produtoRepository.delete(produto);
		return "redirect:/";
	}

}