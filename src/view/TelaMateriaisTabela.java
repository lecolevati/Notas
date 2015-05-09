package view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.TabelaMateriasController;
import controller.TabelaMateriasControllerImpl;
import controller.TabelaMateriasModeloController;

import model.Materias;

public class TelaMateriaisTabela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblMaterias;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMateriaisTabela frame = new TelaMateriaisTabela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaMateriaisTabela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 239);
		contentPane.add(scrollPane);
		
		tblMaterias = new JTable();
		String[] cabecalho = new String[3];
		cabecalho[0] = "ID"; 
		cabecalho[1] = "Nome";
		cabecalho[2] = "Carga Horária";
		DefaultTableModel modelo = new TabelaMateriasModeloController(new Object[][] {}, cabecalho);
		tblMaterias.setModel(modelo);
		tblMaterias.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblMaterias.getColumnModel().getColumn(0).setPreferredWidth(30);
		tblMaterias.getColumnModel().getColumn(1).setPreferredWidth(280);
		tblMaterias.getColumnModel().getColumn(2).setPreferredWidth(100);
		scrollPane.setViewportView(tblMaterias);
		
		TabelaMateriasController tblMatController = 
				new TabelaMateriasControllerImpl();
		
		List<Materias> lista = tblMatController.consultaMaterias();
		for (Materias m : lista){
			Object[] linha = new Object[3];
			linha[0] = m.getId();
			linha[1] = m.getNome();
			linha[2] = m.getCargaHoraria();
			modelo.addRow(linha);
		}
	}
}
