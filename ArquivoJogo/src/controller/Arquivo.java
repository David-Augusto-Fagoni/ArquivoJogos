package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Arquivo {
	
	public void leArquivo(String path, String arquivo, int ano, String mes, double avg) throws IOException {
		File arq = new File(path, arquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(",");
				if(vetLinha[1].contains(Integer.toString(ano))&& vetLinha[2].contains(mes)&& Float.parseFloat(vetLinha[3]) >= avg) {
					escreveArquivo(path, "nome.csv",vetLinha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
		}
	}
	
	public void escreveArquivo(String path, String arquivo, String[] vetLinha) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(path, arquivo);
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			FileWriter abreArq = new FileWriter(arq, existe);
			PrintWriter escreveArq = new PrintWriter(abreArq);
			escreveArq.write(vetLinha[0]+",");
			escreveArq.write(vetLinha[3]+"\n");
			escreveArq.flush();
			escreveArq.close();
			abreArq.close();
		} else {
			throw new IOException("Diretório Inválido");
		}
	}
	public void leNovoArquivo(String path, String arquivo) throws IOException {
		File arq = new File(path, arquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			System.out.println("Nome do jogo | Média de jogadores Ativos");
			while (linha != null) {
				String[] vetLinha = linha.split(",");
				System.out.println(vetLinha[0] +"|"+ vetLinha[1]+"\n");
				
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
		}
	}
	
}
