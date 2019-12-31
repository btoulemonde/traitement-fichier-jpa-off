package fr.diginamic.off.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;


public class LectureDonnees {

public static List<String> lire(String cheminFichier){
	
	List<String> lignes =new ArrayList<>();
	
	try{
		File file = new File(cheminFichier);
		lignes = FileUtils.readLines(file, "UTF-8");
		
		lignes.remove(0);
		
		
		}catch (IOException e){
			System.out.println(e.getMessage());
			return null;
		}
	return lignes;
		
	}
}
