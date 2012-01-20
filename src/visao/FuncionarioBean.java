package visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import negocio.CidadeRN;
import negocio.EstadoRN;
import negocio.FuncionarioRN;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import util.FacesUtil;
import dominio.Cidade;
import dominio.Estado;
import dominio.Funcionario;

@ManagedBean(name = "funcionarioBean")
@RequestScoped
@Model
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 2213636404760405104L;
	private static final Log LOGGER = LogFactory.getLog(FuncionarioBean.class);

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private Estado estado;
	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;
	private List<SelectItem> comboCidades;
	private List<SelectItem> comboEstados;
	private String destinoSalvar;
	private String confirmaSenha;
	private CidadeRN cidadeRN;
	private EstadoRN estadoRN;
	private FuncionarioRN funcionarioRN;

	public FuncionarioBean() {
		inicializar();
	}

	// ############### Métodos de Ação ############### //

	public void inicializar() {
		cidadeRN = new CidadeRN();
		estadoRN = new EstadoRN();
		funcionarioRN = new FuncionarioRN();

		estado = new Estado();
		cidade = new Cidade();
		funcionario = new Funcionario();
		cidades = new ArrayList<Cidade>();
		estados = estadoRN.buscaTodosEstados();
		this.comboCidades = new ArrayList<SelectItem>();
		comboEstados = FacesUtil.toListSelectItem(estados);

	}

	public void carregarCidadePorEstado() {
		try {

			cidades = cidadeRN.buscarPorCidade(funcionario.getCidade()
					.getEstado());
			comboCidades = FacesUtil.toListSelectItem(cidades);
		} catch (Exception e) {
			LOGGER.error(e);
		}

		// if (estado.getSigla() == null) {
		// cidade = new Cidade();
		// List<Cidade> cid = new ArrayList<Cidade>();
		// cid.add(cidade);
		// cidades = cid;
		// } else {
		// CidadeRN cidadeRN = new CidadeRN();
		// cidades = cidadeRN.buscarPorCidade(estado);
		// }
	}

	// Verifica se a senha inserida pelo usuário é a mesma da confirmação e
	// habilita salvar se correto

	public String salvar() {
		try {

			String senha = this.funcionario.getSenha();

			if (!senha.equals(confirmaSenha)) {

				FacesMessage msg = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"A senha não foi confirmada corretamente!", "");
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
					"Este CPF já existe", "Este CPF já existe.");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// funcionario = new Funcionario();
			confirmaSenha = "";
		}

		return "CPF já existente!!";
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
		return "/admin/cad_funcionario";
	}

	public String excluir() {
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<SelectItem> getComboCidades() {
		return comboCidades;
	}

	public void setComboCidades(List<SelectItem> comboCidades) {
		this.comboCidades = comboCidades;
	}

	public List<SelectItem> getComboEstados() {
		return comboEstados;
	}

	public void setComboEstados(List<SelectItem> comboEstados) {
		this.comboEstados = comboEstados;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

}
