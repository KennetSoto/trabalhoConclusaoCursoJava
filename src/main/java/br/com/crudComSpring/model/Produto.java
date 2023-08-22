package br.com.crudComSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//ENTENDE COMO UMA ETIDADE, TABELA NO BANCO DE DADOS
@Entity
public class Produto {

	@Id
	// @id marca como uma chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// A anotação @GeneratedValue é utilizada para informar que a geração do valor
	// do identificador único da entidade será gerenciada pelo provedor de
	// persistência. Essa anotação deve ser adicionada logo após a anotação @Id.
	// Quando não anotamos o campo com essa opção, significa que a responsabilidade
	// de gerar e gerenciar as chaves primárias será da aplicação, em outras
	// palavras, do nosso código.
	// Ja o GenerationType.IDENTITY Informamos ao provedor de persistência que os valores
	// a serem atribuídos ao identificador único serão gerados pela coluna de auto
	// incremento do banco de dados. Assim, um valor para o identificador é gerado
	// para cada registro inserido no banco. Alguns bancos de dados podem não
	// suportar essa opção.
	@NotNull(message = "Campo Obrigatorio")
	@Size(min = 2, max = 254, message = "Nome deve conter entre 2 e 254 caracteres")
	private Long id;
	private String nome;
	private int quantidade;
	private double preco;
	private String descricaoProduto;
	private String urlImage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

}
