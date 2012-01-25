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

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
	private List<SelectItem> cidades;
	private Estado estado;
	private Cidade cidade;
	private String destinoSalvar;
	private String confirmaSenha;
	private CidadeRN cidadeRN;
	private EstadoRN estadoRN;
	private FuncionarioRN funcionarioRN;
	private String senhaCriptografada;

	public FuncionarioBean() {
		inicializar();
	}

	// ############### Métodos de Ação ############### //

	public void inicializar() {
		cidadeRN = new CidadeRN();
		estadoRN = new EstadoRN();
		funcionarioRN = new FuncionarioRN();
		funcionario = new Funcionario();
		cidade = new Cidade();
		estado = new Estado();
		cidades = new ArrayList<SelectItem>();

	}

	// public List<SelectItem> getEstados() {
	//
	// List<Estado> lista = estadoRN.buscaTodosEstados();
	//
	// List<SelectItem> itens = new ArrayList<SelectItem>(lista.size());
	//
	// for (Estado estado : lista) {
	// itens.add(new SelectItem(estado.getCodigo(), estado.getSigla()));
	// // System.out.println("Código do estado: " + estado.getCodigo()
	// // + " o nome do estado: " + estado.getNome());
	// }
	//
	// System.out.println("Tamanho da lista de estado: " + lista.size());
	// return itens;
	// }

	// public void actionCarregaCidades() {
	//
	// this.cidades = this.getCidadeByEstado();
	// System.out.println("O código da cidade selecionado é: "
	// + this.cidade.getCodigo());
	//
	// LOGGER.info("código de estado carregado: " + estado.getCodigo());
	//
	// }

	// public List<SelectItem> getCidadeByEstado() {
	//
	// // funcionario = new Funcionario();
	// List<Cidade> cidades = cidadeRN.getCidadePorEstado(this.estado
	// .getCodigo());
	//
	// System.out.println("Código do estado pra pesquisar: "
	// + estado.getCodigo());
	//
	// List<SelectItem> items = new ArrayList<SelectItem>(cidades.size());
	//
	// for (Cidade cidade : cidades) {
	// items.add(new SelectItem(cidade.getCodigo(), cidade.getNome()));
	// // System.out.println("Código de cidade: " + cidade.getCodigo()
	// // + " o nome da cidade: " + cidade.getNome());
	//
	// }
	//
	// // System.out.println("Existe instância de funcionário : "
	// // + cidades.contains(funcionario instanceof Funcionario));
	//
	// System.out.println("Tamanho da lista: " + cidades.size());
	//
	// // System.out
	// //
	// .println("Verifica se na busca de cidades encontra o código do estado: "
	// // + cidades.contains(estado.getCodigo()));
	//
	// return items;
	//
	// }

	public String salvar() {
		try {

			String senha = this.funcionario.getSenha();

			if (senha != null && senha.trim().length() > 0
					&& !senha.equals(this.confirmaSenha)) {

				FacesMessage msg = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"A senha não foi confirmada corretamente!", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return null;
			}

			if (senha != null && senha.trim().length() == 0) {
				this.funcionario.setSenha(this.senhaCriptografada);
			} else {
				String senhaCripto = DigestUtils.md5Hex(senha.getBytes());
				this.funcionario.setSenha(senhaCripto);
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
		this.senhaCriptografada = this.funcionario.getSenha();
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<SelectItem> getCidades() {
		System.out.println(" realiza busca de cidade ? O.o : "
				+ cidade.getNome());
		return cidades;
	}

	public void setCidades(List<SelectItem> cidades) {
		this.cidades = cidades;
	}

	public String getSenhaCriptografada() {
		return senhaCriptografada;
	}

	public void setSenhaCriptografada(String senhaCriptografada) {
		this.senhaCriptografada = senhaCriptografada;
	}

}
