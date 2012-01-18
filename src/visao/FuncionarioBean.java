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

	private Funcionario funcionario = new Funcionario();
	private List<Funcionario> funcionarios;
	private String destinoSalvar;
	private String confirmaSenha;

	// ############### Métodos de Ação ############### //

	// Verifica se a senha inserida pelo usuário é a mesma da confirmação e
	// habilita salvar se correto
	public String salvar() {
		try {

			String senha = this.funcionario.getSenha();
			FuncionarioRN funcionarioRN = new FuncionarioRN();

			if (!senha.equals(confirmaSenha)) {

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Erro", "A senha não foi confirmada corretamente!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return null;
			}

			funcionarioRN.salvarOuAtualizar(this.funcionario);
			System.out.println("Operação de Inserção realizada com sucesso!!!");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso", "O Funcionário " + funcionario.getNome()
							+ " foi registrado!!");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			return this.destinoSalvar;
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro", "Não foi possível salvar contato: "
							+ funcionario.getNome());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return "";
	}

	// A cada nova instanciação do objeto usuário este será setado com ativo
	public String novo() {
		this.destinoSalvar = "usuarioSucesso";
		this.funcionario = new Funcionario();
		this.funcionario.setAtivo(true);
		return "cad_funcionario";
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

	public String editar() {
		this.confirmaSenha = this.funcionario.getSenha();
		return "/publico/cad_funcionario";
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
			System.out.println("Funcionário inativo!");
		} else {
			this.funcionario.setAtivo(true);
			System.out.println("Usuário ativo!");
		}
		FuncionarioRN funcionarioRN = new FuncionarioRN();
		funcionarioRN.salvarOuAtualizar(funcionario);
		return null;
	}

	// ############### Métodos Get e Set ############### //

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
