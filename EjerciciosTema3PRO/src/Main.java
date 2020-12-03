import java.util.Scanner;

public class Main {

	public static Scanner scan = new Scanner(System.in);
	//Ejercicio1_1
	public static char[] ejer1_1() {
		char toret[] = new char[25];
		for(int i = 0; i < toret.length; i++) {
			toret[i] = 'x';
		}
		return toret;
	}
	
	//Ejercicio1_2
	public static void ejer1_2() {
		float toret[] = new float[8];
		for(int i = 0; i < toret.length; i++) {
			toret[i] = 0.9f;
			System.out.print(toret[i]);
		}
	}
	
	//Ejercicio1_3
	public static void ejer1_3() {
		int toret[] = new int[4];
		for(int i = 0; i < toret.length; i++) {
			toret[i] = 10;
			System.out.print(toret[i]);
		}
	}
	
	//Ejercicio2_1
	public static void ejer2_1() {
		int toret[] = new int[20];
		for(int i = 0; i < toret.length; i++) {
			toret[i] = i;
			System.out.print(toret[i]);
		}
	}
	
	//Ejercicio2_2
	public static void ejer2_2() {
		int toret[] = new int [20];
		int j = 0;
		for(int i = 19; i >= 0; i--) {
			toret[j] = i;
			System.out.print(toret[j]);
			j++;
		}
	}
	
	//Ejercicio2_3
	public static void ejer2_3() {
		boolean aux[] = new boolean[20];
		for(int i = 0; i < aux.length; i++) {
			if(i % 2 == 0) aux[i] = false;
			else aux[i] = true;
			System.out.println( "Posición " + i  + ":" + aux[i]);
		}
	}
	
	//Ejercicio2_4
	public enum Calificacion {
		SOBRESALIENTE, NOTABLE, APROBADO, SUSPENSO, NO_PRESENTADO
	}
	
	public static void ejer2_4() {
		String notas[][] = {{"Matemáticas","Química","Lengua","Historia","Economía"},{null,null,null,null,null}};
		String aux;
		for(int i = 0; i < notas[0].length;i++) {
			do {
				System.out.println("Introduzca la calificación para: " + notas[0][i]+
					".\n1. Sobresaliente.\n"
					+ "2. Notable.\n"
					+ "3. Aprobado.\n"
					+ "4. Suspenso.\n"
					+ "5. No Presentado.");
				aux = scan.next();
				switch(aux) {
				case "1":
					notas[1][i] = "Sobresaliente";
					break;
				case "2":
					notas[1][i] = "Notable";
					break;
				case "3":
					notas[1][i] = "Aprobado";
					break;
				case "4":
					notas[1][i] = "Suspenso";
					break;
				case "5":
					notas[1][i] = "NP";
					break;
				default:
					System.out.println("Entrada incorrecta.");
				}
			}while(notas[1][i] == null );
		}	
		for(int i = 0; i < notas[0].length; i++) {
			for(int j = 0; j < notas.length; j++) {
				System.out.println(notas[j][i]);
			}
		}
	}
	
	//Ejercicio 3
	//Para enteros
	public static int[] ejer3(int [] array) {
		 int aux;
		 for(int i = 0; i < array.length/2;i++) {
			 aux = array[i];
			 array[i] = array[array.length - i - 1];
			 array[array.length - i - 1] = aux;
		 }
		return array;
	}
	
	//Para chars
	public static char[] ejer3(char [] array) {
		 char aux;
		 for(int i = 0; i < array.length/2;i++) {
			 aux = array[i];
			 array[i] = array[array.length - i - 1];
			 array[array.length - i - 1] = aux;
		 }
		return array;
	}
	
	//Ejercicio 4
	public static int aleatorio(int max) {
		double toret = Math.random()*max;
		return (int) toret;
	}
	
	public static void urna() {
		int [] bola = new int[80];
		int cont = 0;
		for(int i = 0; i < bola.length; i++) bola [i] = 0;
		do {
			bola[aleatorio(79)]++;
			cont++;
		} while(bola[33] < 3);
		for(int i = 0; i < bola.length; i++) {
			if(bola[i] != 0) System.out.println("Bola " + i + " = " + bola[i] );
			else System.out.println("Bola " + i + " = no ha salido.");
		}
		System.out.println("Total de bolas que salieron: " + cont);
	}
	
	//Ejercicio 5
	public static int posValorMax(int[] array) {
		int pos = 0;
		int max;
		if(array.length > 0) max = array[0];
		else return -1;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
				pos = i;
			}
		}
		return pos;
	}
	
	//Ejercicio 6_1 
	public static int [][] ejer6_1(int [][] matrizEntrada) {
		int [][] matrizSalida;
		System.out.println("Introduzca el numero de filas/columnas para su"
				+ " matriz cuadrada.");
		int numFil = scan.nextInt();
		matrizSalida = new int[numFil][numFil];
		for(int i = 0; i < matrizSalida.length; i++) {
			for(int j = 0; j < matrizSalida[i].length; j++) {
				matrizSalida[i][j] = matrizEntrada[i][j];
			}
		}
		return matrizSalida;
	}
	
	//Ejercicio6_2 nos vale también para mostrar cualquier matriz de entrada
	public static void mostrarMatriz(int [][] mEntrada) {
		for(int i = 0; i < mEntrada.length; i++) {
			System.out.print("\n");
			for(int j = 0; j < mEntrada[i].length; j++) {
				System.out.print("[" + mEntrada[i][j] + "], ");
			}
		}
		System.out.print("\n");
	}
	//Ejercicio6_3 Version procedimiento
	public static void ejer6_3(int mEntrada[][]) {
		int mayor = mEntrada[0][0];
		int menor = mEntrada[0][0];
		for(int x = 0; x < mEntrada.length; x++) {
			for(int y = 0; y < mEntrada[x].length; y++) {
				if(mEntrada[x][y] > mayor) mayor = mEntrada[x][y];
				else if (mEntrada[x][y] < menor) menor = mEntrada[x][y];
			}
		}
		System.out.println("El mayor es : " + mayor + " y el menor es : " + menor);
	}
	
	//Version funcion
	public static int[] ejer6_3_func(int mEntrada[][]) {
		int mayor = mEntrada[0][0];
		int menor = mEntrada[0][0];
		int[] toret = new int[2];
		for(int x = 0; x < mEntrada.length; x++) {
			for(int y = 0; y < mEntrada[x].length; y++) {
				if(mEntrada[x][y] > mayor) mayor = mEntrada[x][y];
				else if (mEntrada[x][y] < menor) menor = mEntrada[x][y];
			}
		}
		toret[0] = mayor;
		toret[1] = menor;
		System.out.println("El mayor es : " + toret[0] + " y el menor es : " + toret[1]);
		return toret;
	}
	
	//Ejercicio 7
	public static int ejer7_1(int mat[][]) {
		int toret = 0;
		for(int i = 0; i < mat[0].length; i++) {
			toret += mat[0][i];
		}
		return toret;
	}
	
	//Version 7_1 seleccionando el día para el calculo de más ausencias
	public static int ejer7_1plus(int dia, int mat[][]) {
		int toret = 0;
		for(int i = 0; i < mat[dia].length; i++) {
			toret += mat[dia][i];
		}
		return toret;
	}
	
	//Ejercicio 7_2
	
	public static String diaMasAusencias(int m[][]) {
		int pos = 0, max = 0, aux = 0;
		for(int dia = 0; dia < 5; dia++) {
			aux = ejer7_1plus(dia, m);
			if(aux > max) {
				max = aux;
				pos = dia;
			}
		}
		switch(pos) {
		case 0: return "Lunes";
		case 1: return "Martes";
		case 2: return "Miércoles";
		case 3: return "Jueves";
		case 4: return "Viernes";
		default: return "ERROR";
		}
	}
	
	//Ejercicio 7_3
	
	//Función que nos devuelve el total de faltas
	public static int absentismoTotal(int matriz[][]) {
		int toret = 0;
		double[] aux = faltasPorDepart(matriz);
		for(int i = 0; i < aux.length;i++) {
			toret += aux[i];
		}
		return toret;
	}
	
	//Función que nos devuelve el total de faltas por departamento
	public static double[] faltasPorDepart(int matriz[][]) {
		double toret[] = new double[matriz[0].length];
		for(int i = 0; i < matriz.length; i++) {
			for( int j = 0; j < matriz[i].length; j++) {
				toret[j] += matriz[i][j];
			}
		}
		return toret;
	}
	
	public static void absentismoPorDepart(int matriz[][]) {
		double faltasTotales = absentismoTotal(matriz);
		double faltasPorDepartamento[] = faltasPorDepart(matriz);
		System.out.println("Faltas totales: " + faltasTotales);
		for(int i = 0; i < faltasPorDepartamento.length; i++) {
			System.out.println(faltasPorDepartamento[i] + ",");
		}
		for(int i = 0; i < faltasPorDepartamento.length; i++) {
			double aux = (faltasPorDepartamento[i]/faltasTotales)*100.0;
			System.out.println("El % de faltas del departamento \n" 
					+ i + " con respecto al total es: " + aux);
		}
	}
	
	//Función aux para rellenar matrices
	public static int [][] relleno(int col, int fil, int maxValue) {
		int toret [][] = new int[col][fil];
		for(int i = 0; i < toret.length; i++) {
			for(int j = 0; j < toret[i].length; j++) {
				toret[i][j] = (int) (Math.random() * maxValue);
			}
		}
		return toret;
	}
	
	//Función aux para rellenar matrices tridimensionales
		public static int [][][] rellenoTrid(int col, int fil,int prof, int maxValue) {
			int toret [][][] = new int[col][fil][prof];
			for(int i = 0; i < toret.length; i++) {
				for(int j = 0; j < toret[i].length; j++) {
					for(int k = 0; k < toret[i][j].length;k++) {
						toret[i][j][k] = (int) (Math.random() * maxValue);
					}
				}
			}
			return toret;
		}
		//Función aux para mostrar matrices tridimensionales
		public static void mostrarTrid(int [][][] mEntrada) {
			for(int i = 0; i < mEntrada.length; i++) {
				System.out.print("\n");
				for(int j = 0; j < mEntrada[i].length; j++) {
					System.out.print("\n");
					for(int k = 0; k < mEntrada[i][j].length; k++) {
						System.out.print("[" + mEntrada[i][j][k] + "], ");
					}
				}
			}
			System.out.print("\n");
		}
	
	//Ejercicio 8
	//Procedimiento que resuelve los 3 apartados
	//Tenemos en cuenta que la matriz es 4x10x12 (Provincias x Años x Meses)
	public static void ejer8(int matriz[][][]) {
		//0 Coruña, 1 es Pontevedra, 2 Lugo, 3 Ourense
		//Apartado 1
		int aux [] = new int[matriz.length];
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				for(int k = 0; k < matriz[i][j].length; k++) {
					aux[i] += matriz[i][j][k];
				}
			}
		}
		int max = aux[0];
		System.out.println("Columna " + 0 + " lluvias " + aux[0]);
		int pos = 0;
		for(int i = 1; i < aux.length; i++) {
			System.out.println("Columna " + i + " lluvias " + aux[i]);
			if(aux[i] > max) {
				max = aux[i];
				pos = i;
			}
		}
		switch(pos) {
		case 0: System.out.println("Chove de carallo na Coruña"); break;
		case 1: System.out.println("Chove de carallo en Pontevedra"); break;
		case 2: System.out.println("Chove de carallo en Lugo"); break;
		case 3: System.out.println("Chove de carallo en Ourense"); break;
		}
		
	
		//Apartado 2
		int menor[] = new int[4];
		for (int i = 0; i < matriz.length; i++) {
			for (int k = 0; k < matriz[i][9].length; k++) {
				menor[i] += matriz[i][9][k];
			}
		}
		int min = menor[0];
		System.out.println("Columna " + 0 + " lluvias " + menor[0]);
		int posicion = 0;
		for(int i = 1; i < menor.length; i++) {
			System.out.println("Columna " + i + " lluvias " + menor[i]);
			if(menor[i] < min) {
				min = menor[i];
				posicion = i;
			}
		}
		switch(posicion) {
		case 0: System.out.println("Este ano casi non choveu na Coruña"); break;
		case 1: System.out.println("Este ano casi non choveu en Pontevedra"); break;
		case 2: System.out.println("Este ano casi non choveu en Lugo"); break;
		case 3: System.out.println("Este ano casi non choveu en Ourense"); break;
		}
		
		//Apartado 3
		int mesMayor = matriz[3][5][0];
		int posMesMayor = 0;
		for(int i = 0; i < matriz[3][5].length; i++) {
			System.out.println("Mes " + i + ":" + matriz[3][5][i]);
			if(matriz[3][5][i] > mesMayor) {
				mesMayor = matriz[3][5][i];
				posMesMayor = i;
			}
		}
		
		switch(posMesMayor) {
		case 0: System.out.println("Enero"); break;
		case 1: System.out.println("Febrero"); break;
		case 2: System.out.println("Marzo"); break;
		case 3: System.out.println("Abril"); break;
		case 4: System.out.println("Mayo"); break;
		case 5: System.out.println("Junio"); break;
		case 6: System.out.println("Julio"); break;
		case 7: System.out.println("Agosto"); break;
		case 8: System.out.println("Sept"); break;
		case 9: System.out.println("Oct"); break;
		case 10: System.out.println("Nov"); break;
		case 11: System.out.println("Diciembre"); break;

		}
	}
	
	//Ejercicio 9
	//Solo va a funcionar con matrices de la misma dimension
	public static int[][] sumaMatrices(int matriz1[][], int matriz2[][]) {
		int suma[][] = new int[matriz1.length][matriz1[0].length];
		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1[i].length; j++) {
				suma[i][j] = matriz1[i][j] + matriz2[i][j];
			}
		}
		return suma;
	}
	
	//Multiplicar TODO
	
	//Ejercicio 10
	public static boolean simetrica(int [][] entrada) {
		for (int i = 0; i < entrada.length; i++) {
			for (int j = 0; j < entrada[i].length; j++) {
				if(entrada[i][j] != entrada[j][i]) return false;
			}
		}
		return true;
	}
	
	//Ejercicio 11
	public static void repetidos(String [] entrada) {
		String indice[] = new String[entrada.length];
		for (int i = 0; i < indice.length; i++) {
			indice[i] = "";
		}
		for(int i = 0; i < entrada.length; i++) {
			System.out.print(entrada[i] + " ");
			for(int j = 0; j < entrada.length; j++) {
				if(entrada[i].equals(indice[j])) {
					entrada[i] = "";
				}
			}
			for(int j = 0; j < entrada.length; j++) {
				if(i != j) {
					if(entrada[i].equals(entrada[j])) {
						indice[i] = entrada[j];
					}
				}
			}
		}
		System.out.println();
		for(int i = 0; i < entrada.length; i++){
			if(!entrada[i].equals("")) System.out.print(entrada[i] + " ");
		}
	}
	
	// Ejercicio 12
	public static void ejer12(int m[][]) {
		int aux = m[0][0];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length/2; j++) {
				aux = m[i][j];
				m[i][j] = m[i][m[i].length-1-j];
				m[i][m[i].length-1-j] = aux;
			}
		}
	}


	//Ejercicio 14
	
	public static boolean anagrama(String cad1, String cad2) {
		int aux = 0;
		if(cad1.length() == cad2.length()) {
			for(int i = 0; i < cad1.length(); i++) {
				for(int j = 0; j < cad2.length(); j++) {
					if(cad1.charAt(i) == cad2.charAt(j)) {
						aux++;
					}
				}
			}
			if(aux == cad1.length()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	
	//Ejercicio 15
	
	public static void separarPalabras(String frase) {
		 String[] palabras = frase.split(" "); //Separa la string de entrada en substrings usando
		 //como pivote el caracter o caracteres que se pasan como parametro
	        for (String palabra : palabras) { //for (int i = 0; i < palabras.length(); i++)
	        	if(palabra.length()>0) System.out.println(palabra + ": " + palabra.length());
	        }
	}
	
	
	//Ejercicio 16
	public static String eliminaBlancosDuplicados(String frase) {
		String toret = "";
		String[] palabras = frase.split(" "); //Separa la string de entrada en substrings usando
		 //como pivote el caracter o caracteres que se pasan como parametro
	        for (String palabra : palabras) { //for (int i = 0; i < palabras.length(); i++)
	        	if(palabra.length()>0) toret += palabra + " ";
	        }
	        toret = toret.substring(0, toret.length()-1);
		return toret;
	}
	
	//Ejercicio 17
	public static void ejer17(String frase) {
		if(frase.length() < 81) {
			 String[] palabras = frase.split(" "); //Separa la string de entrada en substrings usando
			 //como pivote el caracter o caracteres que se pasan como parametro
		        for (String palabra : palabras) { //for (int i = 0; i < palabras.length(); i++)
		        	if(palabra.length()>0) {
		        		if(palabra.length() < 16) {
		        			System.out.println(palabra + ": " + palabra.length());
		        		}
		        	}
		        }
		} else {
			System.out.println("Una frase solo puede tener como máximo 80 caracteres");
		}
	}
	
	//Ejercicio 18
	//Minusculas comunes y no comunes
	public static void ejer18(String cad1, String cad2) {
		String minuscA = "", minuscB = "", toPrint = "";
		int cont = 0;
		for(int i = 0; i < cad1.length(); i++) {
			if(Character.isLowerCase(cad1.charAt(i))) {
				minuscA += cad1.charAt(i);
			}
		}
		for(int i = 0; i < cad2.length(); i++) {
			if(Character.isLowerCase(cad2.charAt(i))) {
				minuscB += cad2.charAt(i);
			}
		}
		for(int i = 0; i < minuscA.length(); i++) {
			if(minuscB.indexOf(minuscA.charAt(i)) != -1) {
				toPrint += minuscA.charAt(i);
			} else {
				cont++;
			}
		}
		for(int i = 0; i < minuscB.length(); i++) {
			if(minuscA.indexOf(minuscB.charAt(i)) == -1) {
				cont++;
			}
		}
		System.out.println("Minusculas comunes: " + toPrint);
		System.out.println("Numero de no comunes: " + cont);
	}
	
	//Ejercicio 19
	public static void plurales(String frase) {
		String[] palabras = frase.split(" ");
	    for (String palabra : palabras) { //for (int i = 0; i < palabras.length(); i++)
	       if(palabra.endsWith("a") || palabra.endsWith("e") || palabra.endsWith("i") ||
	    		   palabra.endsWith("o") || palabra.endsWith("u")) {
	    	   palabra += "s";
	       } else {
	    	   palabra += "es";
	       }
	       System.out.println(palabra);
	    }
	    
	}
	
	
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//Ejercicio1_1
//		System.out.println(ejer1_1());
//		//Ejercicio1_2
//		ejer1_2();
//		System.out.println();
//		//Ejercicio1_3
//		ejer1_3();
//		System.out.println();
//		//Ejercicio2_1
//		ejer2_1();
//		System.out.println();
//		//Ejercicio2_2
//		ejer2_2();
//		System.out.println();
//		//Ejercicio2_3
//		ejer2_3(); 
		//Ejercicio2_4
//		ejer2_4();
		//Ejercicio 3
//		int [] entrada = {1,34,6,8,11};
//		entrada = ejer3(entrada);
//		for (int i = 0; i < entrada.length; i++) System.out.print(entrada[i]+",");
//		System.out.println();
//		char [] entradaChar = {'a','b','c','d','e'};
//		System.out.print(ejer3(entradaChar));
//		System.out.println();
//		for (int i = 0; i < entradaChar.length; i++) System.out.print(entradaChar[i]+",");
		//Ejercicio 4
//		urna();
		//Ejercicio 5
//		int [] entrada = {1,34,6,8,11,123};
//		System.out.println(posValorMax(entrada));
		//Ejercicio 6
//		int matrizSesenta [][] = new int[60][60];
//		for(int i = 0; i < matrizSesenta.length; i++) {
//			for( int j = 0; j < matrizSesenta[i].length; j++) {
//				matrizSesenta[i][j] = (int) (Math.random() * 10);
//			}
//		}
//		int matrizPrueba[][] = ejer6_1(matrizSesenta);
//		mostrarMatriz(matrizPrueba);
//		ejer6_3(matrizPrueba);
		//Ejercicio 7
//		int matriz[][] = relleno(5,10,10);
//		mostrarMatriz(matriz);
//		System.out.println(ejer7_1plus(0,matriz));
//		System.out.println(ejer7_1plus(1,matriz));
//		System.out.println(ejer7_1plus(2,matriz));
//		System.out.println(ejer7_1plus(3,matriz));
//		System.out.println(ejer7_1plus(4,matriz));
//		System.out.println(diaMasAusencias(matriz));
//		absentismoPorDepart(matriz);
		
		//Ejercicio 8
//		int matriz[][][] = rellenoTrid(4, 10, 12, 100);
//		mostrarTrid(matriz);
//		ejer8(matriz);
//		scan.close();
		
		//Ejercicio 9
//		int matriz1[][] = relleno(2,3,10);
//		mostrarMatriz(matriz1);
//		int matriz2[][] = relleno(2,3,10);
//		mostrarMatriz(matriz2);
//		mostrarMatriz(sumaMatrices(matriz1, matriz2));
		
		//Ejercicio 10
//		int[][] simetrica = {{1,0,1},{0,1,0},{1,0,1}};
//		int[][] noSimetrica = {{1,0,1},{0,1,1},{1,0,1}};
//		System.out.println(simetrica(simetrica));
//		System.out.println(simetrica(noSimetrica));
		
		//Ejercicio 11
//		String [] prueba = {"a","b","c","abrieron los bares :)","c","a","d"};
//		repetidos(prueba);
		
		//Ejercicio 12
//		int m[][] = relleno(4,4,100);
//		mostrarMatriz(m);
////		ejer12(m);
//		mostrarMatriz(m);
		
		//Ejercicio 15
//		String prueba = "Vamos   a probar  el ejercicio";
//		separarPalabras(prueba);
//		//Ejercicio 16
//		System.out.println(eliminaBlancosDuplicados(prueba));
		//Ejercicio 17
//		ejer17("Esto es    una frase con palabras validas y otras palapfnwgbujqweoprign");
//		ejer18("Cadena", "cadena");
//		plurales("patata gato pan leche licor cafe");
		
	}
}