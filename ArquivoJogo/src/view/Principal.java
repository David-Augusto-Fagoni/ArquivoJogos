package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.Arquivo;

public class Principal {

	public static void main(String[] args) {
		Arquivo ar = new Arquivo();
		int ano = Integer.parseInt(JOptionPane.showInputDialog("ano"));
		String mes = JOptionPane.showInputDialog("mes");
		double avg = Integer.parseInt(JOptionPane.showInputDialog("média"));
		String path = "C:\\Users\\dti";
		String arq = "SteamCharts.csv";
		try {
			ar.leArquivo(path, arq,ano,mes,avg);
			ar.leNovoArquivo(path, "nome.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
