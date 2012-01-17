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

	// ############### Métodos de Ação ###############

	// Verifica se a senha inserida pelo usuário é a mesma da confirmação e
	// habilita salvar se correto
	public String salvar() {
		try {

			FuncionarioRN funcionarioRN = new FuncionarioRN();
			funcionarioRN.salvarOuAtualizar(funcionario);

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso", funcionario.getNome()
							+ " cadastrado com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			System.out.println("Nome do funcionario: " + funcionario.getNome());
			System.out.println("CPF do funcionario: " + funcionario.getCpf());
			funcionario = new Funcionario();
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro", "Não foi possível salvar contato: "
							+ funcionario.getNome());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return "";
	}

	public String excluir() {
		FuncionarioRN funcionarioRN = new FuncionarioRN();
		funcionarioRN.excluir(this.funcionario);
		this.funcionarios = null;
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

}
