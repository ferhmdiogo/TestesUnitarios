package br.ce.wcaquino.servicos;

import java.util.Date;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;

import static br.ce.wcaquino.utils.DataUtils.*;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}

	public static void main(String[] args) {

		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Fernando");
		Filme filme = new Filme("Titanic", 1, 2.00);

		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);

		//verificacao
		System.out.println(locacao.getValor() == 5.0);
		System.out.println(isMesmaData(locacao.getDataLocacao(), new Date()));
		System.out.println(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(2)));
		
	}

}