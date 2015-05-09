package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import persistence.MateriasDao;
import persistence.MateriasDaoImpl;

import model.Materias;

public class TabelaMateriasControllerImpl implements TabelaMateriasController {

	@Override
	public List<Materias> consultaMaterias() {
		List<Materias> lista = new ArrayList<Materias>();
		MateriasDao mDao = new MateriasDaoImpl();
		try {
			lista = mDao.listaMaterias();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, 
					e.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
		}
		return lista;
	}

}
