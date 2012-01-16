/**
 * Método utilizado para bloquear caracteres não-numéricos
 * 
 * @param event
 * @return
 * 
 * Uso:
 */
function bloqueiaCaracteresNaoNumericos(event) {
	var keyCode;
	
	if (event.srcElement) // IF IE
		keyCode = event.keyCode;
	else if (event.target){ // IF Firefox
		keyCode = event.which;
		
		if(keyCode == 0)
			return true;
	}
	
	if (keyCode == 8 || (keyCode >= 48 && keyCode <= 57))
		return true;

	return false;
}

/**
 * Método utilizado para permitir somente letras
 * 
 * @param event
 * @return
 * 
 * Uso:
 */
function permitirSomenteLetras(event) {
	var keyCode;
	
	if (event.srcElement) // IF IE
		keyCode = event.keyCode;
	else if (event.target){ // IF Firefox
		keyCode = event.which;

		if(keyCode == 0)
			return true;
	}
	
	var BACKSPACE = 8;
	var ENTER = 13;
	var SPACE = 32;
	var DOT = 46;
	
	if(BACKSPACE || ENTER || SPACE || DOT){
		return true;
	}
	
	/* Caracteres de A a z*/
	if (keyCode >= 65 && keyCode <= 122){
		return true;
	}

	return false;
}

/**
 * Método para implementar a máscara do código normal no plano de contas
 * @param input
 * @param event
 * @return
 */
function codigoNormalMask(input, event){
	
	var keyCode;
	
	if (event.srcElement){
		// IF IE
		keyCode = event.keyCode;
	}
	else if (event.target){ 
		// IF Firefox
		keyCode = event.which;
		
		if(keyCode == 0){
			return true;
		}
	}
	
	var codigoInput = input.value;
	var qtdCaracteres = codigoInput.length; // pois o caractere digitado ainda não foi incluído.
		
	if (keyCode == 8 || (keyCode >= 48 && keyCode <= 57)){
		/* Se a tecla for número */
		if(keyCode != 8){
			
			// verificando se ainda pode ser inserido mais caracteres
			if(qtdCaracteres >= 13)
				return false;
			
			// Tratanto os níveis 1, 2, 3, 4 e 5 da máscara
			if((qtdCaracteres >= 1 && qtdCaracteres <= 6) || qtdCaracteres == 8){
				codigoInput = codigoInput + '.';
			}
		}
		
		input.value = codigoInput;
		
		return true;
	}
	
	return false;
}
