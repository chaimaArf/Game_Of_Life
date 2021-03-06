package iteration3.Services;



/**
 * 
 * @author chaima_arfaoui
 *
 */



import iteration3.Beans.GridMatrixBean;


public interface GameOfLifeServices {
	
	/**
	 * Créer une grille à partir de grille type GridMatrix
	 * GridMatrix : permet de creer une grille à partir de fichier data ( input file )
	 * @param row,col
	 * @return boolean[][]
	 */
	
	boolean[][] createBooleanGridFromGridMatrix(int row, int col ,GridMatrixBean grid);
	/**
	 * Dessiner une grille avec le format ( +,-) et à partir de grid de type boolean [][] 
	 * @param evolutionNember nombre de géneration courante   
	 * @param grid 
	 *  
	 * 
	 */
	void drawGrid(boolean[][] grid,int evolutionNember);
	/**
	 * Vérifier toutes les  cellules de grille si elles sont mortes ou vivantes 
	 * @param row nombre de  ligne 
	 * @param col nombre de colonne  
	 * @param grid  
	 * @return boolean
	 */

	boolean isAlive(int row, int col, int x, int y, boolean[][] grid);

	/**
	 * Créer une grille  à partir de : 
	 *  grille inital + le nombre de ligne + nombre de colonne
	 * @param row nombre de  ligne 
	 * @param col nombre de colonne 
	 * @param grid 
	 * @return boolean[][] 
	 * 
	 */
	boolean[][] nextGeneration(int row, int col, boolean[][] grid);

	
	/**
	 * Créer  et Dessiner N  génération à partir  d'une grille 
	 *  + le nombre de ligne + nombre de colonne

	 * @param evolutionCount nombre d'évolution 
	 * @param row nombre de  ligne 
	 * @param col nombre de colonne 
	 * @param grid 
	 * @return boolean[][] 
	 * 
	 */

	boolean[][] getGeneration(int evolutionCount, int row, int col, boolean[][] grid);

}
