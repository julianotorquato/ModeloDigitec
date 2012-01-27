package visao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;

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

		} catch (Exception e) {
			LOGGER.error(e);
		}
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
