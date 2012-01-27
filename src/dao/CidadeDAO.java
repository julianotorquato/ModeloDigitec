package dao;

import java.util.List;

import dominio.Cidade;
import dominio.Estado;

public interface CidadeDAO {

	List<Cidade> buscarCidadePorEstado(Estado estado);

	public List<Cidade> getCidadePorEstado(Integer codigo);

	public List<Cidade> buscaTodasCidades();

	public Cidade recuperaCodigoCidade(Integer codigo);
}
