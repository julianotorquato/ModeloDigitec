package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo implements Serializable {

	private static final long serialVersionUID = 1L;

}
