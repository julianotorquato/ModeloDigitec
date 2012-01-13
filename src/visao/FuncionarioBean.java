package visao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import negocio.FuncionarioRN;
import dominio.Funcionario;

@ManagedBean(name = "funcionarioBean")
@RequestScoped
@Model
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 2213636404760405104L;

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private String destinoSalvar;
	private String confirmaSenha;

	// ############### Métodos de Ação ###############

	public String novo() {
		this.destinoSalvar = "funcionarioSucesso";
		this.funcionario = new Funcionario();
		this.funcionario.setAtivo(true);
		return "funcionario";
	}

	public String editar() {
		this.confirmaSenha = this.funcionario.getSenha();
		return "/restrito/cad_funcionario";
	}

	// Verifica se a senha inserida pelo usuário é a mesma da confirmação e
	// habilita salvar se correto
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.funcionario.getSenha();

		if (!senha.equals(confirmaSenha)) {
			FacesMessage facesMessage = new FacesMessage(
					"A senha não foi confirmada corretamente!");
			context.addMessage(null, facesMessage);
			return null;
		}
		FuncionarioRN funcionarioRN = new FuncionarioRN();
		funcionarioRN.salvar(this.funcionario);

		return this.destinoSalvar;
	}

	public String atribuiPermissao(Funcionario funcionario, String permissao) {
		this.funcionario = funcionario;
		java.util.Set<String> permissoes = this.funcionario.getPermissao();
		if (permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}

		return null;
	}

	public String excluir() {
		FuncionarioRN funcionarioRN = new FuncionarioRN();
		funcionarioRN.excluir(this.funcionario);
		this.funcionarios = null;
		return null;
	}

	public String ativar() {
		if (this.funcionario.isAtivo()) {
			this.funcionario.setAtivo(false);
			System.out.println("Funcionário ativo!");
		} else {
			this.funcionario.setAtivo(true);
			System.out.println("Funcionário inativo!");
		}
		FuncionarioRN funcionarioRN = new FuncionarioRN();
		funcionarioRN.salvar(this.funcionario);
		return null;
	}

	// ############### Métodos Get e Set ###############

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		if (this.funcionarios == null) {
			FuncionarioRN funcionarioRN = new FuncionarioRN();
			this.funcionarios = funcionarioRN.listar();
		}
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

}
