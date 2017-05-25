package squarelotron;

public class Squarelotron {
	int[][] squarelotron;
	int size;
	void flip(int a, int b, int c, int d){//a,b = coords of 1st point, c, d:cords of second
		int temp = this.squarelotron[a][b];
		this.squarelotron[a][b] = this.squarelotron[c][d];
		this.squarelotron[c][d] = temp;
	}
	Squarelotron(int n){
		this.squarelotron = new int[n][n];
		if(n < 4 || n > 8){
			throw new IllegalArgumentException("argument must be between 1 and 8");
			}
		this.size = n*n;
		int sum = 1;
		for(int i = 0; i < n; i++){
			for(int j =0; j < n; j++){
				this.squarelotron[i][j] = sum;
				sum++;
			}
		}
		
	}
	Squarelotron upsideDownFlip(int ring){//tested on square of length 4 end 5
		int n = (int) Math.sqrt(this.size);
		Squarelotron tempSquareLotron = new Squarelotron(n);

		int waypointUp, waypointDown;
		int half = n /2;
		if(n % 2 == 0){				//elems have a middle line
			waypointUp = half -1;
			waypointDown = half;	
		}else{
			waypointUp = half - 1; //Here, we wont event touch the half as it 
			//is a pivot point
			waypointDown = half + 1;	//elms are a pair
		}

		while(waypointUp >= 0){
			for(int i = 0; i < n; i++){
				if(waypointUp >= ring  && n - i >=ring && n -1 -i > 0 && i >= ring){//I still need to explain this to myself
					continue;
				}else {
				tempSquareLotron.flip(waypointUp, i, waypointDown, i);

				}
					

			}
			waypointDown++; waypointUp--;

		}
		


	
	return tempSquareLotron;
				

	}
	Squarelotron mainDiagonalFlip(int ring){
		/*
		Given our flip method, we choose to use the left section of the diagonal when flipping
		So if j is smaller than ring, we know we can flip otherwise, save the ring
		*/
		int n = (int) Math.sqrt(this.size);
		Squarelotron tempSquareLotron = new Squarelotron(n);
		for(int i = 0; i < n; i++){
			for(int j = 0; j< n ; j++){
				if(i > j && j < ring){
					tempSquareLotron.flip(i, j, j, i);
				}
			}
		}
	
		return tempSquareLotron;

	}
	void rotateRight(int numberOfTurns){
		if(numberOfTurns == 0) return;
		int n = (int) Math.sqrt(this.size);
		int temp[][] = new int[n][n];
		for(int i = 0; i < n; i++){
					for(int j = 0; j < n; j++){
						temp[i][j] = this.squarelotron[i][j];
					}
		}
		
		if(numberOfTurns > 0 ){
			while(numberOfTurns > 0 ){
				for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				
				this.squarelotron[j][n-1-i] = temp[i][j];
			}
		}
		for(int i = 0; i < n; i++){
					for(int j = 0; j < n; j++){
						temp[i][j] = this.squarelotron[i][j];
					}
		}
			numberOfTurns--;
		}
		}else{
			while(numberOfTurns < 0 ){
				for(int j = 0; j < n; j++){
			for(int i = 0; i < n; i++){
				
				this.squarelotron[n-1-j][i] = temp[i][j];
			}
		}
		for(int i = 0; i < n; i++){
					for(int j = 0; j < n; j++){
						temp[i][j] = this.squarelotron[i][j];
					}
		}
			numberOfTurns++;
		}
			
		}
		


}

	
	public static void main(String[] args){
		/*Squarelotron mine = new Squarelotron(5);
		Squarelotron testing;
		testing = mine.upsideDownFlip(1);


		for(int i = 0; i < Math.sqrt(testing.size); i++){
		for(int j = 0; j< Math.sqrt(testing.size); j++){
			
			System.out.print(testing.squarelotron[i][j]+ "-");
		}
		System.out.println("");
	} TESTED*/

	Squarelotron testing = new Squarelotron(5);
		testing.rotateRight(-2);


		for(int i = 0; i < Math.sqrt(testing.size); i++){
		for(int j = 0; j< Math.sqrt(testing.size); j++){
			
			System.out.print(testing.squarelotron[i][j]+ "-");
		}
		System.out.println("");
	}






	}

}
