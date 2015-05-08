package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import persistence.MateriasDao;
import persistence.MateriasDaoImpl;

import model.Materias;


public class MateriasControllerImpl implements MateriasController {

	JComboBox<Materias> cbMaterias;
	
	public MateriasControllerImpl(JComboBox<Materias> cbMaterias){
		this.cbMaterias = cbMaterias;
	}
	
	@Override
	public void listaMaterias() throws SQLException{
		List<Materias> lista = new ArrayList<Materias>();
		MateriasDao mDao = new MateriasDaoImpl();
		lista = mDao.listaMaterias();
		if (cbMaterias.getItemCount() > 0){
			cbMaterias.removeAllItems();
		}
		if (lista != null){
			for (Materias m : lista){
				cbMaterias.addItem(m);
			}
		}
	}

	
}
