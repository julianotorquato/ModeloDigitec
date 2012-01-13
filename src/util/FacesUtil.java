package util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 * Classe utilitario para delegar mensagens para a aplicacao.<br />
 * Apresenta as mensagens na UI.
 */
public class FacesUtil {

	/**
	 * Apresenta uma mensagem de informacao.
	 * 
	 * @param title
	 *            o titulo da mensagem.
	 * @param message
	 *            a mensagem que sera apresentada.
	 */
	public static void mensInfo(String title, String message) {
		mensagem(title, message, FacesMessage.SEVERITY_INFO);
	}

	/**
	 * Apresenta uma mensagem de erro.
	 * 
	 * @param title
	 *            o titulo da mensagem.
	 * @param message
	 *            a mensagem que sera apresentada.
	 */
	public static void mensErro(String title, String message) {
		mensagem(title, message, FacesMessage.SEVERITY_ERROR);
	}

	/**
	 * Apresenta uma mensagem de atencao.
	 * 
	 * @param title
	 *            o titulo da mensagem.
	 * @param message
	 *            a mensagem que sera apresentada.
	 */
	public static void mensWarn(String title, String message) {
		mensagem(title, message, FacesMessage.SEVERITY_WARN);
	}

	/**
	 * Apresenta a mensagem na UI.
	 * 
	 * @param title
	 *            o titulo da mensagem.
	 * @param message
	 *            a mensagem que sera apresentada.
	 * @param severity
	 *            o tipo de mensagem.
	 * @see FacesMessage
	 */
	public static void mensagem(String title, String message,
			FacesMessage.Severity severity) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(severity, title, message));
	}

	public static String get(String param) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get(param);
	}

	/**
	 * Obtem as mensagens do arquivo de propriedades.
	 * 
	 * @param key
	 *            a chave da mensagem no arquivo de propriedades.
	 * @return a mensagem referente a chave.
	 */
	public static final String getMessage(String key) {
		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot viewRoot = context.getViewRoot();
		ResourceBundle bundle = ResourceBundle.getBundle("ui.Messages",
				viewRoot.getLocale());
		return bundle.getString(key);
	}

	/**
	 * Redireciona para a pagina informada pelo parametro.
	 * 
	 * @param originalViewId
	 *            a pagina que sera redirecionada.
	 */
	public static final void redirectPage(String originalViewId) {
		FacesContext context = FacesContext.getCurrentInstance();
		ViewHandler viewHandler = context.getApplication().getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, originalViewId);
		context.setViewRoot(viewRoot);
	}

}
