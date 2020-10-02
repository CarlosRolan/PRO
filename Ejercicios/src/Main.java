
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		//Ejercicio1
		/*
		float far, cel;
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca los grados Farenheit: \n");
		far = scan.nextFloat();		
		cel = ((far-32)*5)/9;
		System.out.println("El resultado en Celsius es: " + cel);
				scan.close();

		*/
		
		
		//Ejercicio 2
		/*
	    float r, vol, a;
   
	    final float PI = 3.14f;
   
        Scanner scan = new Scanner(System.in);
       
        System.out.println("Introduzca el radio de la esfera : \n");
       
        r = scan.nextFloat();
       
        a = r*r*4*PI;
               
        vol = (a*r)/3;
       
        System.out.println("El volumen de la esfera de radio " + r + " es " + vol 
        		+ " y el área es " + a);
        		scan.close();

        */
		
		//Ejercicio 3
		/*
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca su nota: \n");
		int nota = scan.nextInt();
		if(!(nota < 0 || nota > 10)) {
			if( nota < 5) {
				System.out.println("SUSPENSO");
			} else if( nota < 7 ) {
				System.out.println("APROBADO");
			} else if ( nota < 9 ) {
				System.out.println("NOTABLE");
			} else {
				System.out.println("SOBRESALIENTE!");
			}
		} else {
			System.out.println("Nota no valida");
		}
				scan.close();

		*/
		
		//Ejercicio 4
		/*
		Scanner scan = new Scanner(System.in);
		int a = 0, e = 0, i = 0, o = 0, u = 0;
		char chr;
		String aux;
		for(int x = 0; x < 20; x++){
			System.out.println("Introduzca el caracter "+ (x+1) + "\n");
			aux = scan.next();
			if(aux.length() == 1){
				chr = aux.charAt(0);
				switch(chr){
					case 'a':
						a++;
						break;
					case 'e':
						e++;
						break;
					case 'i':
						i++;
						break;
					case 'o':
						o++;
						break;
					case 'u':
						u++;
						break;
					default:
						break;
				}
			}
		}
		System.out.println("Número de vocales: \n"
				+ "a: "+ a + "\n"
				+ "e: "+ e + "\n"
				+ "i: "+ i + "\n"
				+ "o: "+ o + "\n"
				+ "u: "+ u + "\n");		
						scan.close();

		*/
		
		//Ejercicio 5
		/*
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		String chr = "";
		while(!chr.equals("0")){
			System.out.println("Introduzca el primer número");
			num1 = scan.nextInt();
			System.out.println("Introduzca el segundo número");
			num2 = scan.nextInt();
			System.out.println("Seleccione la operación a realizar: (+,-,*,/,%).\n"
					+ "Pulse 0 para finalizar.");
			chr = scan.next();
			switch(chr){
				case "+":
					System.out.println("Resultado: " + (num1+num2));
					break;
				case "-":
					System.out.println("Resultado: " + (num1-num2));
					break;
				case "*":
					System.out.println("Resultado: " + num1*num2);
					break;
				case "/":
					System.out.println("Resultado: " + num1/num2);
					break;
				case "%":
					System.out.println("Resultado: " + num1%num2);
					break;
				case "0":
					System.out.println("Programa finalizado!");
					break;
				default:
					System.out.println("ERROR: Operador Inválido");
			}
		}
				scan.close();

		*/
		
		//Ejercicio 6
		/*
		Scanner scan = new Scanner(System.in);
		float n,aux;
		n = 0;
		for(int i = 0; i < 20; i++){
			System.out.println("Introduzca el siguiente número: \n");
			aux = scan.nextFloat();
			n = n + aux;
		}
		System.out.println("El promedio de los 20 números introducidos es: " + n/20);
				scan.close();

		*/
		
		//Ejercicio 7
		/*
		Scanner scan = new Scanner(System.in);
		int n, aux = 1;
		System.out.println("Introduzca un número: \n");
		n = scan.nextInt();
		for(int i = 1; i <= n; i++){
			aux = aux * i;
		}
		System.out.println("El factorial de " + n + " es: " + aux);
				scan.close();

		*/
		
		//Ejercicio 8
		/*
		Scanner scan = new Scanner(System.in);
		int n, v, aux = 0;
		System.out.println("Introduzca un número: \n");
		n = scan.nextInt();
		v = n;
		for(int i = 1; i <= n; i++){
			if((i%2)!=0){
				aux = aux + i;
			} else {
				n++;
			}
		}
		System.out.println("La suma de los " + v + " primeros impares es: " + aux);
				scan.close();

		*/
		
		//Ejercicio 9
		/*
		int res = 0;
		for(int i = 1; i <= 500; i++){
			if((i%5) == 0 && (i%7) == 0){
				res = res + i;
			}
		}
		System.out.println("El resultado es: " + res); //res = 3675
		*/
		
		//Ejercicio 10
		/*
		Scanner scan = new Scanner(System.in);
		String twit;
		System.out.println("Introduzca el texto a evaluar: \n");
		twit = scan.next();
		if(twit.length()<281){
			System.out.println("El texto es tuiteable. \n");
		} else {
			System.out.println("El texto no es tuiteable. \n");
		}
				scan.close();

		*/
		
		//Ejercicio 11
		/*
		Scanner scan = new Scanner(System.in);
		int time, min, h, d;
		System.out.println("Introduzca el tiempo en minutos a evaluar: \n");
		time = scan.nextInt();
		h = time/60;
		min = time - (h*60);
		d = h/24;
		if(d>0){
			h = h - (d*24);
		}
		System.out.println(d + " día(s) " + h + " hora(s)" + min + " minuto(s). \n");
				scan.close();

		*/
		
		//Ejercicio 12
		/*
		Scanner scan = new Scanner(System.in);
		int x, y, z;
		System.out.println("Introduzca el primer número: \n");
		x = scan.nextInt();
		System.out.println("Introduzca el segundo número: \n");
		y = scan.nextInt();
		System.out.println("Introduzca el tercer número: \n");
		z = scan.nextInt();
		if(((z%2 == 0) && (y%2 == 0)) || ((z%2 == 0) && (x%2 == 0)) || ((x%2 == 0) && (y%2 == 0))) {
			System.out.println("Al menos dos son pares.");
		} else {
			System.out.println("No hay dos o más pares.");
		}
				scan.close();

		*/
		
		//Ejercicio 13
		/*
		Scanner scan = new Scanner(System.in);
		int x, y;
		System.out.println("Introduzca el primer número: \n");
		x = scan.nextInt();
		System.out.println("Introduzca el segundo número: \n");
		y = scan.nextInt();
		if((x == 0) || (y == 0)){
			System.out.println("El producto es nulo.");
		} else if (((x > 0) && (y > 0)) || ((x < 0) && (y < 0))) {
			System.out.println("El producto es positivo.");
		} else {
			System.out.println("El producto es negativo");
		}
		scan.close();
		*/
		
		//Ejercicio 14
		/*
		Scanner scan = new Scanner(System.in);
		int x = 0, y = 0;
		while(x<=0){
			System.out.println("Introduzca el primer número positivo: \n");
			x = scan.nextInt();
			if(x<=0){
				System.out.println("El número debe ser positivo.\n");
			}
		}
		while(y<=0){
			System.out.println("Introduzca el segundo número positivo: \n");
			y = scan.nextInt();
			if(y<=0){
				System.out.println("El número debe ser positivo.\n");
			}
		}
		int res = x;
		for(int i = 1; i < y; i++){
			res = res * x;
		}
		System.out.println("El resultado de " + x + " elevado a " + y + " es: " + res);
		scan.close();
		*/
		
		//Ejercicio 15
		/*
		Scanner scan = new Scanner(System.in);
		float x, max, min;
		int i = 1;
		System.out.println("Introduce el "+ i + " número: \n");
		x = scan.nextFloat();
		max = x;
		min = x;
		while(i < 20){
			System.out.println("Introduce el "+ (i+1) + " número: \n");
			x = scan.nextFloat();
			if(x > max){
				max  = x;
			}else if(x < min){
				min = x;
			}
			i++;
		}
		System.out.println("El máximo es " + max + " y el mínimo " + min);
		scan.close();
		*/
		
		//Ejercicio 16
		/*
		Scanner scan = new Scanner(System.in);
		int x = 0;
		while(x <= 0 || x >= 10){
			System.out.println("Introduzca un número del 1 al 9: ");
			x = scan.nextInt();
		}
		//Primos del 1 al 9: 1,2,3,5,7
		if(x == 4 || x == 6 || x > 7) {
			System.out.println(x + " no es un número primo.\n");
		} else {
			System.out.println(x + " es un número primo.\n");
		}
		scan.close();
		*/
		
		//Ejercicio 17
		/*
		Scanner scan = new Scanner(System.in);
		int x = -1, aux = 0;
		while( x != 0) {
			System.out.println("Introduzca un entero positivo mayor que el anterior: \nPulse 0 para salir.");
			aux = scan.nextInt();
			if(aux > x) {
				x = aux;
				System.out.println("Nuevo mayor entero: " + x);
			} else {
				if(aux == 0){
					x = aux;
					System.out.println("Fin del programa");
				} else {
					System.out.println("Ese entero no es mayor a " + x);
				}
			}
		}
		scan.close();
		*/
		
		//Ejercicio 18
		/*
		Scanner scan = new Scanner(System.in);
		int numPar = 0, sumPar = 0, aux, sumImpar = 0;
		float mediaImpar;
		for(int i = 0; i < 10; i++){
			System.out.println("Introduzca el entero " + (i+1) + " de la lista.");
			aux = scan.nextInt();
			if(aux%2 == 0){
				numPar++;
				sumPar = sumPar + aux;
			} else {
				sumImpar = sumImpar + aux;
			}
		}
		mediaImpar = sumImpar/(10 - numPar);
		System.out.println("Resultados:\n"
				+ "Sumatorio de los pares de la lista: " + sumPar + "\n"
				+ "Número de pares: " + numPar + "\n"
				+ "Media aritmética de los impares: " + mediaImpar + "\n");
		scan.close();
		*/
		
		//Ejercicio 19
		/*
		
		  int valor [] = new int[10];
		  int sumatoria = 0;
		  float media = 0;
		  double varianza = 0.0;
		  double desviacion= 0.0; 
		  Scanner scan = new Scanner(System.in);
		  System.out.println("Introduzca números el valor de 10 numeros"
		                                     +" como muestra");
		  for (int i = 0; i < 10; i++ ){
		   System.out.print("Ingrese el valor " + (i + 1) + ":");
		   valor[i] = scan.nextInt();
		   sumatoria = sumatoria + valor[i];
		  }
		  scan.close();
		  media = sumatoria / 10; 
		  for(int i = 0 ; i < 10; i++){
		   double rango;
		   rango = Math.pow(valor[i] - media, 2f);
		   varianza = varianza + rango;
		  }
		  varianza = varianza / 10f;
		  desviacion = Math.sqrt(varianza);
		  System.out.println("Media: " + media);
		  System.out.println("Varianza: " + varianza);
		  System.out.println("Desvianción Típica: " + desviacion);
		
		*/
		
		//Ejercicio 20
		/*
		Scanner scan = new Scanner(System.in);
		int num = 0, sum = 0, aux = 0;
		System.out.println("Introduzca el número a analizar: \n");
		num = scan.nextInt();
		while(num!=0){
			aux = num%10;
			if(aux%2 == 0){
				sum = sum + aux;
			}
			num = num/10;
			System.out.println(aux);
		}
		System.out.println("Suma de los pares: " + sum);
		scan.close();
		*/
	}		
}
