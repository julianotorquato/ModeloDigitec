package dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CLIENTE")
	private Integer codigo;

	@org.hibernate.annotations.NaturalId
	@Column(name = "CNPJ_CLIENTE", nullable = true, length = 18)
	private String cnpj;

	@org.hibernate.annotations.NaturalId
	@Column(name = "CPF_CLIENTE", nullable = true, length = 14)
	private String cpf;

	@Column(name = "RG_CLIENTE", nullable = false, length = 11)
	private String rg;

	@Column(name = "NOME_REAL_CLIENTE", nullable = false, length = 150)
	private String nomeReal;

	@Column(name = "NOME_FANTASIA_CLIENTE", nullable = false, length = 100)
	private String nomeFantasia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_CADASTRO_CLIENTE", nullable = false)
	private Date dataCadastro;

	@Column(name = "FONE_COMERCIAL_CLIENTE", nullable = true, length = 13)
	private String foneComercial;

	@Column(name = "FONE_CELULAR_CLIENTE", nullable = true, length = 13)
	private String foneCelular;

	@Column(name = "SITE_CLIENTE", nullable = true, length = 100)
	private String site;

	@Column(name = "EMAIL_CLIENTE", nullable = true, length = 100)
	private String email;

	@Column(name = "RUA_CLIENTE", nullable = false, length = 80)
	private String rua;

	@Column(name = "BAIRRO_CLIENTE", nullable = false, length = 80)
	private String bairro;

	@Column(name = "COMPLEMENTO_CLIENTE", nullable = true, length = 60)
	private String complementoEndereco;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public String getNomeReal() {
		return nomeReal;
	}

	public void setNomeReal(String nomeReal) {
		this.nomeReal = nomeReal;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getFoneComercial() {
		return foneComercial;
	}

	public void setFoneComercial(String foneComercial) {
		this.foneComercial = foneComercial;
	}

	public String getFoneCelular() {
		return foneCelular;
	}

	public void setFoneCelular(String foneCelular) {
		this.foneCelular = foneCelular;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
