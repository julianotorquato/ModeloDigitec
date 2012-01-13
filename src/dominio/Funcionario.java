package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_FUNCIONARIO")
	private Integer codigo;

	@Column(name = "NOME_FUNCIONARIO", nullable = false, length = 100)
	private String nome;

	@org.hibernate.annotations.NaturalId
	@Column(name = "CPF_FUNCIONARIO", nullable = false, length = 11)
	private String cpf;

	@Column(name = "RG_FUNCIONARIO", nullable = false, length = 13)
	private String rg;

	@Column(name = "SALARIO_FUNCIONARIO", nullable = false)
	private Double salario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_ADMISSAO_FUNCIONARIO", nullable = false)
	private Date dataAdmissao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_CADASTRO_FUNCIONARIO", nullable = false)
	private Date dataCadastro;

	@Column(name = "FONE_CELULAR_FUNCIONARIO", nullable = true, length = 13)
	private String foneCelular;

	@Column(name = "FONE_RESIDENCIAL_FUNCIONARIO", nullable = true, length = 13)
	private String foneResidencial;

	@Column(name = "RUA_FUNCIONARIO", nullable = false, length = 100)
	private String rua;

	@Column(name = "BAIRRO_FUNCIONARIO", nullable = false, length = 80)
	private String bairro;

	@Column(name = "COMPLEMENTO_FUNCIONARIO", nullable = true, length = 50)
	private String complementoEndereco;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_NASCIMENTO_FUNCIONARIO", nullable = false)
	private Date dataNascimento;

	@Column(name = "SENHA_FUNCIONARIO", nullable = true, length = 10)
	private String senha;

	@Column(name = "EMAIL_FUNCIONARIO", nullable = true, length = 100)
	private String email;

	@Column(name = "STATUS_FUNCIONARIO", nullable = false)
	private boolean ativo;

	@ElementCollection(targetClass = String.class)
	@JoinTable(name = "usuario_permissao", uniqueConstraints = { @UniqueConstraint(columnNames = {
			"usuario", "permissao" }) }, joinColumns = @JoinColumn(name = "usuario"))
	@Column(name = "permissao", length = 50)
	private Set<String> permissao = new HashSet<String>();

	// ################# Métodos Get e Set #################

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getFoneCelular() {
		return foneCelular;
	}

	public void setFoneCelular(String foneCelular) {
		this.foneCelular = foneCelular;
	}

	public String getFoneResidencial() {
		return foneResidencial;
	}

	public void setFoneResidencial(String foneResidencial) {
		this.foneResidencial = foneResidencial;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Set<String> getPermissao() {
		return permissao;
	}

	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
