package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

}
