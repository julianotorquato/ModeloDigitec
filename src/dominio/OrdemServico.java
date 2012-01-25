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
@Table(name = "ordem_servico")
public class OrdemServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ORDEM_SERVICO")
	private Integer codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORDEM_SERVICO", nullable = false)
	private Date dataOS;

	@Column(name = "DESCRICAO_ORDEM_SERVICO", nullable = false, length = 200)
	private String descricao;

	@Column(name = "VALOR_ORDEM_SERVICO", nullable = false)
	private Double valorOS;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDataOS() {
		return dataOS;
	}

	public void setDataOS(Date dataOS) {
		this.dataOS = dataOS;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorOS() {
		return valorOS;
	}

	public void setValorOS(Double valorOS) {
		this.valorOS = valorOS;
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
		OrdemServico other = (OrdemServico) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
