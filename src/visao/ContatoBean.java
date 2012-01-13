package visao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import negocio.ContatoRN;
import negocio.EventoRN;
import dominio.Contato;
import dominio.Evento;

@ManagedBean(name = "contatoBean")
@RequestScoped
@Model
public class ContatoBean implements Serializable {

	private static final long serialVersionUID = -3822376238293693100L;

	private Evento evento;
	private EventoRN eventoRN;
	private Contato contato;
	private List<Contato> contatos;

	public ContatoBean() {
		inicializar();
	}

	public void inicializar() {
		contato = new Contato();
		ContatoRN contatoRN = new ContatoRN();
		contatos = contatoRN.Listar();
		evento = new Evento();
		eventoRN = new EventoRN();
	}

	public String testSave() {

		try {
			ContatoRN contatoRN = new ContatoRN();
			contatoRN.salvarOuAtualizar(contato);
			System.out.println(contato.getNome() + " Nome do contato!");
			System.out.println(contato.getCelular() + " Número do celular!");
			System.out
					.println(contato.getNascimento() + " Data de Nascimento!");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso", contato.getNome() + " cadastrado com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			contatos.add(contato);
			contato = new Contato();
			return "Contato salvo!!";
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro", "Não foi possível salvar contato: "
							+ contato.getNome());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return "Erro!! ' '/";
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public EventoRN getEventoRN() {
		return eventoRN;
	}

	public void setEventoRN(EventoRN eventoRN) {
		this.eventoRN = eventoRN;
	}

}
