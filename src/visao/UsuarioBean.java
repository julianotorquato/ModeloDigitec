package visao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import negocio.UsuarioRN;
import util.AuthenticationService;
import dominio.Usuario;

@ManagedBean(name = "usuarioBean")
@RequestScoped
@Model
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private String confirmaSenha;
	private List<Usuario> lista;
	private String destinoSalvar;

	@ManagedProperty(value = "#{authenticationService}")
	private AuthenticationService authenticationService;

	// A cada nova instanciação do objeto usuário este será setado com ativo
	public String novo() {
		this.destinoSalvar = "usuarioSucesso";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "usuario";
	}

	public String atribuiPermissao(Usuario usuario, String permissao) {
		this.usuario = usuario;
		java.util.Set<String> permissoes = this.usuario.getPermissao();
		if (permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}

		return null;
	}

	public String editar() {
		this.confirmaSenha = this.usuario.getSenha();
		return "/publico/usuario";
	}

	// Verifica se a senha inserida pelo usuário é a mesma da confirmação e
	// habilita salvar se correto
	public String salvar() {
		// FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.usuario.getSenha();

		if (!senha.equals(confirmaSenha)) {
			// FacesMessage facesMessage = new FacesMessage(
			// "A senha não foi confirmada corretamente!");
			// context.addMessage(null, facesMessage);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Erro", "A senha não foi confirmada corretamente!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);

		return this.destinoSalvar;
	}

	public String excluir() {
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		return null;
	}

	public String ativar() {
		if (this.usuario.isAtivo()) {
			this.usuario.setAtivo(false);
			System.out.println("Usuário ativo!");
		} else {
			this.usuario.setAtivo(true);
			System.out.println("Usuário inativo!");
		}
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		return null;
	}

	// --------------------------------------------------- //

	public String login() {
		boolean success = authenticationService.login(usuario.getLogin(),
				usuario.getSenha());

		if (!success) {
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "", "CPF ou senha inválidos");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return "falhaLogin";
		}

		return "sucessoLogin";
	}

	public String logout() {
		authenticationService.logout();
		return "login";
	}

	public String getUsuarioLogado() {
		return authenticationService.getUsuarioLogado().getLogin();
	}

	// ############### Métodos Get e Set ###############

	public List<Usuario> getLista() {
		if (this.lista == null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}
		return this.lista;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public void setAuthenticationService(
			AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

}
