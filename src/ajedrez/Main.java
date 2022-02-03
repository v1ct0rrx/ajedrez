package ajedrez;

public class Main {

	public static void main(String[] args) {
		int tablero[][] = new int[8][8];
		
		// POSICION DE LAS REYNAS
		tablero[0][0] = 1;
		tablero[1][4] = 1;
		tablero[2][7] = 1;
		tablero[3][5] = 1;
		tablero[4][2] = 1;
		tablero[5][6] = 1;
		tablero[6][1] = 1;
		tablero[7][3] = 1;
		for (int fila = 0; fila <= 7; fila++) {
			for (int columna = 0; columna <= 7; columna++) {
				System.out.print(tablero[fila][columna]);
			}
			System.out.println();
		}
		
		for (int fila = 0; fila <= 7; fila++) {
			for (int columna = 0; columna <= 7; columna++) {
				if(tablero[fila][columna] == 1) {
//					validarMovimientoHorizontal
					int sumaFila = validarMovimientoHorizontal(tablero[fila]);
//					validarMovimientoVertical
					int sumaColumna = validarMovimientoVertical(tablero, columna);
//					validarMovimientoDiagonal izq ==> der
					int sumaDiagonal1 = validarMovimientoDiagonal1(tablero, fila, columna);
//					validarMovimientoDiagonal der ==> izq
					int sumaDiagonal2 = validarMovimientoDiagonal2(tablero, fila, columna);
					
					if(sumaFila > 1) {
						System.out.println("Reina en posicion ::: " + fila + ", " + columna  + " ... No puede atacar en horizontal");
					}
					
					if(sumaColumna > 1) {
						System.out.println("Reina en posicion ::: " + fila + ", " + columna  + " ... No puede atacar en vertifcal");
					}
					
					if(sumaDiagonal1 > 1) {
						System.out.println("Reina en posicion ::: " + fila + ", " + columna  + " ... No puede atacar en diagonal");
					}
					
					if(sumaDiagonal2 > 1) {
						System.out.println("Reina en posicion ::: " + fila + ", " + columna  + " ... No puede atacar en diagonal");
					}
				}
			}
		}
	}

	private static int validarMovimientoDiagonal1(int[][] tablero, int fila, int columna) {
		
		int filasTablero= 7;
		int columnasTablero = 7;
		
		int sumatoria = 0;
		int filaInicial = filasTablero - (filasTablero - fila);
		int columnaInicial = columnasTablero - (columnasTablero - columna);
		
		if(filaInicial != 0) {
			--filaInicial;
		}
		
		if(columnaInicial != 0) {
			--columnaInicial;
		}
		
		for(int i = filaInicial; i <= 7; i++) {
			if(columnaInicial > 7) {
				continue;
			}
			sumatoria += tablero[i][columnaInicial++];
		}		
		
		return sumatoria;
	}
	
	private static int validarMovimientoDiagonal2(int[][] tablero, int fila, int columna) {
		
		int filasTablero= 7;
		int columnasTablero = 7;
		
		int sumatoria = 0;
		int filaInicial = filasTablero - (filasTablero - fila);
		int columnaInicial = (columnasTablero + columna) - columnasTablero;
		
		if(filaInicial != 0 && columnaInicial != 7) {
			--filaInicial;
		}
		
		if(columnaInicial != 0 && columnaInicial < 7) {
			++columnaInicial;
		}
		
		for(int i = filaInicial; i <= 7; i++) {
			if(columnaInicial < 0) {
				continue;
			}else if(columnaInicial > 7) {
				columnaInicial--;
			}
			sumatoria += tablero[i][columnaInicial];
			columnaInicial -= 1;
		}
		
		
		return sumatoria;
	}

	private static int validarMovimientoVertical(int[][] tablero, int columna) {
		int sumatoria = 0;
		for(int i = 0; i <= 7; i++) {
			sumatoria += tablero[i][columna];
		}
		return sumatoria;
	}

	private static int validarMovimientoHorizontal(int[] filaCompleta) {
		int sumatoria = 0;
		for (int i : filaCompleta) {
			sumatoria += i;
		}
		
		return sumatoria;
	}
}
