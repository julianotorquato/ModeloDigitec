package dao;

import java.util.List;

import dominio.Cidade;
import dominio.Estado;

public interface CidadeDAO {

	List<Cidade> buscarCidadePorEstado(Estado estado);
}
