package controller;

import javax.swing.table.DefaultTableModel;

public class TabelaMateriasModeloController extends DefaultTableModel{

	private static final long serialVersionUID = 1L;

	public TabelaMateriasModeloController(Object[][] objects, String[] cabecalho){
		super.setDataVector(objects, cabecalho);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	

}
