package visao;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "testeBean")
@RequestScoped
@Model
public class TesteBean {

	private String text;

	private Date data;

	public void save(ActionEvent actionEvent) {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Sucesso!!", "Oie " + text));
		context.addMessage(null, new FacesMessage("Segunda Mensagem",
				"Adiciona a informação... "));
	}

	public void validador(ActionEvent actionEvent) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Correto", "Validação Aceita");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
