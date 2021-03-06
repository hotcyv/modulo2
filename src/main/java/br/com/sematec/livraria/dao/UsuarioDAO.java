package br.com.sematec.livraria.dao;

import org.apache.commons.lang3.StringUtils;

import br.com.sematec.livraria.modelo.Usuario;

public class UsuarioDAO extends DAO<Usuario> {
	public static synchronized UsuarioDAO getInstance() {
		if (instancia == null) {
			instancia = new UsuarioDAO();
		}
		return instancia;
	}

	private static UsuarioDAO instancia;

	private UsuarioDAO() {
		super(Usuario.class);
		geraDados();
	}

	public Usuario getUsuario(Usuario usuario) {
		Long i = 0l;
		boolean retorno = false;
		while (!retorno && i < LISTA.size()) {
			if (StringUtils.equalsIgnoreCase(LISTA.get(i).getEmail(), usuario.getEmail()) && StringUtils.equalsIgnoreCase(LISTA.get(i).getSenha(), usuario.getSenha())) {
				return LISTA.get(i);
			}
			i++;
		}
		return null;
	}

	@Override
	void geraDados() {
		geraIdEAdiciona(new Usuario("professor@sematecsolucoes.com.br", "professor", false));
		geraIdEAdiciona(new Usuario("diretor@sematecsolucoes.com.br", "diretor", true));
		geraIdEAdiciona(new Usuario("admin@admin.com", "admin", false));
		geraIdEAdiciona(new Usuario("teste@teste.com", "teste", true));
	}
}
