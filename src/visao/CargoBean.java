package visao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import negocio.CargoRN;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dominio.Cargo;

@ManagedBean
@RequestScoped
@Model
public class CargoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactory.getLog(CargoBean.class);

	private Cargo cargo;
	private CargoRN cargoRN;
	private List<Cargo> cargos;

	public CargoBean() {
		inicializar();
	}

	// ############### Métodos de Ação ############### //

	public void inicializar() {
		cargo = new Cargo();
		cargoRN = new CargoRN();
		cargos = cargoRN.buscaTodosCargos();
	}

	public void salvar() {
		try {
			cargoRN.salvar(cargo);
			System.out.println("Operação de Inserção realizada."
					+ cargo.getDescricao());

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"O Cargo " + cargo.getDescricao() + " foi registrado!!", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			limparCampo();
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void limparCampo() {
		cargo = new Cargo();
	}

	// ############### Métodos Get e Set ############### //

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

}
