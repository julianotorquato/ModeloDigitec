/*
 * Método utilizado para selecionar todos os checkboxes de um formulário com
 * base na mudança de status de um deles.
 * 
 * @param checkbox ->
 *            componente que irá determinar que os outros checkboxes serão
 *            marcados
 * @param form ->
 *            formulário que contém os checkboxes que irão ser marcados
 * @return
 */
function marcarCheckBoxes(checkbox, form) {

	var i, totalElementos = form.length;
	var state = false;

	if (checkbox.checked)
		state = true;

	for (i = 0; i < totalElementos; i++) {
		if (form.elements[i].type == "checkbox") {
			form.elements[i].checked = state;
		}
	}

}

/*
 * Método utilizado para limpar os campos de um formulário
 * @param form
 * @return
*/
function limparCampos(form) {
	var i, totalElementos = form.length;

	for (i = 0; i < totalElementos; i++) {
		if (form[i].type == "text" || form[i].type == "password") {
			form[i].value = "";
		} else if (form[i].type == "checkbox") {
			form[i].checked = false;
		} else {
			if (form[i].type == "select-one") {
				form[i].selectedIndex = 0;
			}
		}
	}
}

 /*
 *  Método utilizado para abrir janelas popup
 *  @param url
 *  @param largura
 *  @param altura
 *  @return
 */
function abrirPopUp(url, largura, altura) {
	janela = window
			.open(
					url, "janelaPopUp",
					"width=" + largura + ",height="	+ altura
					+ ",scrollbars=no,toolbar=no," +
					"location=no,directories=no," +
					"status=no,menubar=no,resizable=no");
	
	// interceptacao de erro na abertura da janela
	if (!janela) {
		text = "Se a janela não abrir talvez seja porque você tenha um programa " +
		"bloqueador de pop-up! Observação: O windows XP service pack 2 " +
		"bloqueia pop-ups!";
		
		alert(text);
		return;
	}
}
