import java.util.Scanner;

public class Main {
	public static int cuatro = 4, siete = 7;
	public static String nick, pass;
	public static Scanner scan = new Scanner(System.in);
	

	
	//Ejercicio 1
	public static void intercambio(int x, int y){
		System.out.println("Variable cuatro: " + cuatro);
		System.out.println("Variable siete: " + siete);
		cuatro = y;
		siete = x;
		System.out.println("Variable cuatro: " + cuatro);
		System.out.println("Variable siete: " + siete);
	}
	
	//Ejercicio 2
	public static int mayorDeTres(int a, int b, int c){
		if(a >= b && a >= c){
			return a;
		} else if (b >= c && b >= a){
			return b;
		} else {
			return c;
		}
	}
	
	//Ejercicio 3
	public static int factorial(int x){
		int fact;
		if(x == 0){
			fact = x;
		} else {
			fact = 1;
		}
		for(int i = 1; i <= x; i++){
			fact *= i; //fact = fact * i;
		}
		return fact;
	}
	
	public static double calcE(int precision){
		double e = 1.0d;
		for(int i = precision; i > 0; i--){
			e += (i/factorial(i));
		}
		return e;
	}
	
	//Ejercicio 4
	
	//Opcion recorriendo una cadena
	//Se da por supuesto que si no hay punto en la cadena, cuenta todos los caracteres correspondientes
	public static int cuentaChar(char c) {
		int cont = 0;
		String aux = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un texto, la lectura finaliza con un punto.");
		aux = scan.nextLine();
		for(int i = 0; i < aux.length(); i++){
			if(aux.charAt(i) == c){
				cont++;
			}
			if(aux.charAt(i) == '.'){
				break;
			}
		}
		scan.close();
		return cont;
	}
	
	//Opcion caracter por caracter
	//Controlamos que solo nos introduzcan un caracter de cada vez y parar cuando sea un punto
	public static int cuentaChar2(char c) {
		int cont = 0;
		String aux = "";
		Scanner scan = new Scanner(System.in);
		while(!aux.equals(".")){
			System.out.println("Introduzca un caracter, la lectura finaliza con un punto.");
			aux = scan.next();
			if(aux.length() > 1){
				System.out.println("Introduzca sólamente UN caracter");
			}else if(aux.charAt(0) == c){
				cont++;
			}
		}
		scan.close();
		return cont;
	}
	
	//Ejercicio 5
	//Hecho con Strings
	public static String cambiaDigitos(String n){
		String toret = "";
		for(int i = n.length(); i > 0 ;i--){
			toret += n.charAt(i-1);
		}
		return toret;
	}
	
	//Hecho con Enteros
	public static int cambiaDigitosInt(int n){
		int toret = 0;
		int aux = n;
		int i = 0;
		while(n != 0) {
			n = n / 10;
			i++;
		}
		while(aux != 0){
			toret += (aux % 10) * (Math.pow(10, i-1));
			aux = aux / 10;
			i--;
		}
		return toret;
	}
	
	//Ejercicio 6
	public static boolean amiguis(int x, int y) {
		int sumx = 0, sumy = 0;
		for(int i = 1; i < x; i++) {
			if (x % i == 0) {
				sumx += i; //sumx = sumx + i;
			}
		}
		if(sumx == y) {
			for(int i = 1; i < y; i++) {
				if (y % i == 0){
					sumy += i; //sumy = sumy + i;
				}
			}
			if(sumy == x){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	//Ejercicio 7
	public static boolean perfecto(int x) {
		boolean toret = false;
		x = Math.abs(x);
		int sum = 0;
		for(int i = 1; i < x; i++) {
			if( x % i == 0) {
				sum += i;
			}
		}
		if(sum == x) {
			toret = true; //return true
		}
		return toret; //return false en caso de no pasar por el if
	}
	
	//Opcion procedimiento en lugar de función
	public static void perfectoVoid(int x) {
		int aux = x;
		x = Math.abs(x);
		int sum = 0;
		for(int i = 1; i < x; i++) {
			if( x % i == 0) {
				sum += i;
			}
		}
		if(sum == x) {
			System.out.println(aux + " es perfecto."); //return true
		}else {
			System.out.println(aux + " no es perfecto."); //return false en caso de no pasar por el if
		}
	}
	

	//Ejercicio 8
	public static boolean registro() {
		String passRepeat;
		System.out.println("Introduzca su nickname:");
		nick = scan.next();
		System.out.println("Introduzca una contraseña:");
		pass = scan.next();
		System.out.println("Repita la contraseña:");
		passRepeat = scan.next();
		if(pass.equals(passRepeat)) {
			return true;
		}
		System.out.println("Las contraseñas no coinciden.");
		return false;
	}

	
	public static boolean registroSinVar() {
		System.out.println("Introduzca su nickname:");
		nick = scan.next();
		System.out.println("Introduzca una contraseña:");
		pass = scan.next();
		System.out.println("Repita la contraseña:");
		if(pass.equals(scan.next())) {
			return true;
		}
		System.out.println("Las contraseñas no coinciden.");
		return false;
	}
	
	public static boolean login() {
		String nickLocal, passLocal;
		System.out.println("Introduzca su username:");
		nickLocal = scan.next();
		if(!nick.equals(nickLocal)){
			System.out.println("Usuario no encontrado.");
			return false;
		}
		System.out.println("Introduzca una contraseña.");
		passLocal = scan.next();
		if(!pass.equals(passLocal)) {
			System.out.println("Contraseña incorrecta.");
			return false;
		}
		return true;
	}
	
	public static boolean loginSinVar() {
		System.out.println("Introduzca su username:");
		if(!nick.equals(scan.next())){
			System.out.println("Usuario no encontrado.");
			return false;
		}
		System.out.println("Introduzca una contraseña.");
		if(!pass.equals(scan.next())) {
			System.out.println("Contraseña incorrecta.");
			return false;
		}
		return true;
	}
	
	public static void ejer8() {
		while(!registro());
		while(!login());
	}
	
	//Ejercicio 9
		public static int sum(int a, int b) {
			return a + b;
		}
		public static int resta(int a, int b) {
			return a - b;
		}
		public static int product(int a, int b) {
			return a * b;
		}
		public static int divide(int a, int b) {
			if(b == 0) {
				System.out.println("No se puede dividir entre 0 que dice Siri que el monstuo de las galletas se pone triste.");
				return 0;
			}
			return a / b;
		}
		public static int resto(int a, int b) {
			return a % b;
		}
		public static int parseo(String x) {
			int a;
			if(x.length() > 1) {
				x = x.toLowerCase();
				switch(x) {
				case "cero":
					x = "0";
					a = Integer.parseInt(x);
					break;
				case "uno":
					x = "1";
					a = Integer.parseInt(x);
					break;
				case "dos":
					x = "2";
					a = Integer.parseInt(x);
					break;
				case "tres":
					x = "3";
					a = Integer.parseInt(x);
					break;
				case "cuatro":
					x = "4";
					a = Integer.parseInt(x);
					break;
				case "cinco":
					x = "5";
					a = Integer.parseInt(x);
					break;
				case "seis":
					x = "6";
					a = Integer.parseInt(x);
					break;
				case "siete":
					x = "7";
					a = Integer.parseInt(x);
					break;
				case "ocho":
					x = "8";
					a = Integer.parseInt(x);
					break;
				case "nueve":
					x = "9";
					a = Integer.parseInt(x);
					break;
				default:
					System.out.println("ERROR: entrada incorrecta.");
					return -1;
				}
			} else {
				a = Integer.parseInt(x);
			}
			return a;
		}
		
		public static boolean ejer9() {
			System.out.println("Introduzca el primer número: ");
			String x = scan.next();
			System.out.println("Introduzca el segundo número: ");
			String y = scan.next();
			String op;
			int a  = parseo(x);
			if(a == -1) return false;
			int b  = parseo(y);
			if(b == -1) return false;
			System.out.println("Introduzca la operacion a realizar: \n"
					+ "(+, -, *, /, %.)");
			op = scan.next();
			
			switch(op) {
			case "+":
				System.out.println("El resultado de la suma de " + a + 
						" y " + b + " es: " + sum(a,b));
				break;
			case "-":
				System.out.println("El resultado de la resta de " + a + 
						" y " + b + " es: " + resta(a,b));
				break;
			case "*":
				System.out.println("El resultado de la multiplicación de " + a + 
						" y " + b + " es: " + product(a,b));
				break;
			case "/":
				System.out.println("El resultado de la división de " + a + 
						" y " + b + " es: " + divide(a,b));
				break;
			case "%":
				System.out.println("El resultado del resto de " + a + 
						" y " + b + " es: " + resto(a,b));
				break;
			default:
				System.out.println("ERROR: Entrada incorrecta.");
				return false;
			}		
			return true;
		}
		
		public static boolean ejer9Param(String x, String y) {
			String op;
			int a  = parseo(x);
			if(a == -1) return false;
			int b  = parseo(y);
			if(b == -1) return false;
			System.out.println("Introduzca la operacion a realizar: \n"
					+ "(+, -, *, /, %.");
			op = scan.next();
			
			switch(op) {
			case "+":
				System.out.println("El resultado de la suma de " + a + 
						" y " + b + " es: " + sum(a,b));
				break;
			case "-":
				System.out.println("El resultado de la resta de " + a + 
						" y " + b + " es: " + resta(a,b));
				break;
			case "*":
				System.out.println("El resultado de la multiplicación de " + a + 
						" y " + b + " es: " + product(a,b));
				break;
			case "/":
				System.out.println("El resultado de la división de " + a + 
						" y " + b + " es: " + divide(a,b));
				break;
			case "%":
				System.out.println("El resultado del resto de " + a + 
						" y " + b + " es: " + resto(a,b));
				break;
			default:
				System.out.println("ERROR: Entrada incorrecta.");
				return false;
			}		
			return true;
		}
		
		//Ejercicio 10
		public static double cuadradoPer(double lado) {
			return lado*4.0;
		}
		
		public static double cuadradoArea(double lado) {
			return lado*lado;
		}
		
		public static double rectanguloPer(double base, double alt) {
			return (2.0 * base) + (2.0 * alt);
		}
		
		public static double rectanguloArea(double base, double alt) {
			return base * alt;
		}
		
		public static double circunferenciaPer(double radio) {
			return 2 * Math.PI * radio;
		}
		
		public static double circunferenciaArea(double radio) {
			return Math.PI * radio * radio; //return Math.PI * Math.pow(radio, 2);
		}
		
		public static double trianguloEqPer(double lado) {
			return lado * 3;
		}
		
		public static double trianguloEqArea(double base, double alt) {
			return (base * alt) / 2;
		}

	
	public static void main(String[] args) {
		//Ejercicio 1
//		intercambio(cuatro, siete);
		//Ejercicio 2
//		int local = 6;
//		System.out.println("El mayor de los tres es " + mayorDeTres(cuatro, 3, local));
		//Ejercicio 3
//		System.out.print(calcE(siete));
		//Ejercicio 4
//		System.out.println(cuentaChar2('a'));
		//Ejercicio 5
//		System.out.println(cambiaDigitos("186"));
//		System.out.println(cambiaDigitosInt(186));
		//Ejercicio 6
		//Estos son amigos
//		System.out.println(amiguis(220, 284));
		//Estos no se llevan bien
//		System.out.println(amiguis(219, 284));
		//Ejercicio 7
//		System.out.println(perfecto(6));
//		System.out.println(perfecto(-6));
//		System.out.println(perfecto(8));
//		System.out.println(perfecto(-28));
//		perfectoVoid(-28);
//		perfectoVoid(30);
		//Ejercicio 8
//		ejer8();
		//Ejercicio 9
//		while(!ejer9());
//		boolean toret = false;
//		do {
//			System.out.println("Introduzca el primer número: ");
//			String x = scan.next();
//			System.out.println("Introduzca el segundo número: ");
//			String y = scan.next();
//			toret = ejer9Param(x,y);
//		} while(!toret);
		
		//Ejercicio 10
//		System.out.println("Perimetro cuadrado: " + cuadradoPer(3.0));
//		System.out.println("Area cuadrado: " + cuadradoArea(3.0));
//		System.out.println("Perimetro rectangulo: " + rectanguloPer(2.5, 3.0));
//		System.out.println("Area rectangulo: " + rectanguloArea(2.5,3.0));
//		System.out.println("Perimetro circunferencia: " + circunferenciaPer(3.0));
//		System.out.println("Area circunferencia: " + circunferenciaArea(3.0));
//		System.out.println("Perimetro triangulo Eq: " + trianguloEqPer(3.0));
//		System.out.println("Area triangulo Eq: " + trianguloEqArea(2.5,3.0));


	}
}
