package br.com.caelum.jackson;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TesteMashalJson {
	
	public static void main(String[] args) throws Exception, JsonMappingException, IOException {
		
		Livro livro = new Livro();
		livro.setCodigo("ARQ");
		livro.setId(1);
		livro.setNomeAutor("Jose da Silva");
		livro.setValor(new BigDecimal(200));
		Categoria categoria = new Categoria();
		categoria.setNome("EBOOK");
		livro.setCategoria(categoria);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("livro.json"), livro);
		
		Livro l2 = mapper.readValue(new File("livro.json"), Livro.class);
		System.out.println(l2);
		
	}

}
