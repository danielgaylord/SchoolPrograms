class Grid {
	public static void main (String[] args) {
		int[][] cells = {{1, 1, 1, 1, 1},
						 {1, 0, 0, 0, 1},
						 {1, 0, 2, 0, 1},
						 {1, 0, 0, 0, 1},
						 {1, 1, 1, 1, 1}};
					   
		for (int[] r : cells) {
			for (int c : r) {
				if (c == 1){
					System.out.print("[]");
				} else if (c == 2){
					System.out.print("##");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}