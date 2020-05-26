import java.util.*;
public class Main {

	public static void printSolution(int sol[][], int n,int m) 
    { 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) 
                System.out.print( 
                    " " + sol[i][j] + " "); 
            System.out.println(); 
        } 
    } 

	public static boolean isSafe(int maze[][], int x, int y, int n,int m) 
    { 
        return (x >= 0 && x < n && y >= 0
                && y < m && maze[x][y] == 1); 
    } 
  
    public static void solveMaze(int maze[][], int n, int m) 
    { 
        int sol[][] = new int[n][m]; 
  
        if (solveMazeUtil(maze, 0, 0, sol,n,m) == false) { 
            System.out.print("Solution doesn't exist"); 
			return;
        } 
  
        printSolution(sol,n,m); 
    } 

	public static boolean solveMazeUtil(int maze[][], int x, int y, int sol[][], int n, int m) 
    { 
        if (x == n - 1 && y == m - 1 && maze[x][y] == 1) { 
            sol[x][y] = 1; 
            return true; 
        } 
  
        if (isSafe(maze, x, y, n, m) == true) {  
            sol[x][y] = 1; 
  
            if (solveMazeUtil(maze, x + 1, y, sol,n,m)) 
                return true; 
  
            if (solveMazeUtil(maze, x, y + 1, sol,n,m)) 
                return true; 
  
            sol[x][y] = 0; 
            return false; 
        } 
  
        return false; 
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char [][] input = new char[n][m];
		for (int i=0;i<n;i++){
			for (int j=0;j<m;j++){
				input[i][j] = sc.next().charAt(0);
			}
		}

		int [][] arr = new int[n][m];
		for (int i=0;i<n;i++){
			for (int j=0;i<m;j++){
				if (input[i][j]=='X'){
					arr[i][j]=0;
				}
				if (input[i][j]=='O'){
					arr[i][j]=1;
				}
			}
		}
        
        solveMaze(arr,n,m);

    }
}
