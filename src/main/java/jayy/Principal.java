package jayy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Laboratorio;

public class Principal {

	public static void main(String args[]) throws IOException {
		
		///String caminhoArquivo = "C:\\Users\\josue\\Downloads\\";
		String caminhoArquivo = "";
		String nomeDoArquivo = "teste.xlsm";
		
		FileInputStream fis = new FileInputStream(new File(caminhoArquivo + nomeDoArquivo));

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet folhaExcel = wb.getSheetAt(0);

		int numeroDaUltimaLinha = folhaExcel.getLastRowNum();

		int linhaDeInicioDaLeitura = 1;

		ArrayList<Laboratorio> listaDeLaboratorios = new ArrayList<Laboratorio>();

		for (int linha = linhaDeInicioDaLeitura; linha <= numeroDaUltimaLinha; linha++) {
			Laboratorio laboratorio = new Laboratorio();

			XSSFRow linhaXSSF = (XSSFRow) folhaExcel.getRow(linha);
			int qtdCelulasNaLinha = linhaXSSF.getPhysicalNumberOfCells();
			for (int coluna = 0; coluna < qtdCelulasNaLinha; coluna++) {
				XSSFCell cell = linhaXSSF.getCell(coluna);

				String conteudoDaCelula = cell.toString();

				if (coluna == 0) {
					String[] substancias = conteudoDaCelula.split(";");

					for (int i = 0; i <= substancias.length - 1; i++) {
						laboratorio.addSubstancia(substancias[i]);
					}
				} else if (coluna == 1) {
					laboratorio.setCnpj(conteudoDaCelula);
				} else if (coluna == 2) {
					laboratorio.setNome(conteudoDaCelula);
				}				
			}
			listaDeLaboratorios.add(laboratorio);
		}	
		wb.close();
		System.out.println("Lista de Laboratórios:\n"+listaDeLaboratorios);
	}
}
