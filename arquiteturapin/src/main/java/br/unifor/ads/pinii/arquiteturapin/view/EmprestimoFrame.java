package br.unifor.ads.pinii.arquiteturapin.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.unifor.ads.pinii.arquiteturapin.bo.EmprestimoBO;
import br.unifor.ads.pinii.arquiteturapin.entity.Emprestimo;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;

public class EmprestimoFrame extends AbstractFrame {

	private JPanel contentPane;
	private JTextField tfColega;
	private JTextField tfCoisa;
	private EmprestimoBO emprestimoBO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					EmprestimoFrame frame = new EmprestimoFrame();
					frame.setLocationRelativeTo(null);
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
	public EmprestimoFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 577, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblColega = new JLabel("Colega:");
		lblColega.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColega.setBounds(105, 70, 74, 14);
		contentPane.add(lblColega);
		
		tfColega = new JTextField();
		tfColega.setBounds(189, 67, 250, 20);
		contentPane.add(tfColega);
		tfColega.setColumns(10);
		
		JLabel lblCoisa = new JLabel("Coisa:");
		lblCoisa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCoisa.setBounds(105, 95, 74, 14);
		contentPane.add(lblCoisa);
		
		tfCoisa = new JTextField();
		tfCoisa.setBounds(189, 92, 250, 20);
		contentPane.add(tfCoisa);
		tfCoisa.setColumns(10);
		
		JLabel lblDataDev = new JLabel("Data Dev:");
		lblDataDev.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataDev.setBounds(105, 123, 74, 14);
		contentPane.add(lblDataDev);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(189, 120, 250, 20);
		contentPane.add(formattedTextField);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Emprestimo emprestimo = new Emprestimo();
				emprestimo.setColega(tfColega.getText());
				emprestimo.setCoisa(tfCoisa.getText());
				emprestimo.setDataEmprestimo(new Date());
				emprestimo.setDataDevolucao(null);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try {
					emprestimo.setDataPrevisao(sdf.parse(formattedTextField.getText()));
					emprestimoBO.salvar(emprestimo);
					msgInfo("Emprestimo realizado com sucesso.");
				} catch (ParseException | DAOException e) {
					msgError("Não foi possível realizar o emprestimo.");
				}
			}
		});
		btnSalvar.setBounds(246, 186, 89, 23);
		contentPane.add(btnSalvar);
		setResizable(false);
	}
}
