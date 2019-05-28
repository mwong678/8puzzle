/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

public class Board {

    private final int[][] blocks;

    public Board(int[][] blocks){
        this.blocks = blocks;
    }

    //the RIGHT number given coordinates
    private int coordsToNumber(int i, int j){
        return dimension() * i + j + 1;
    }

    //distance to a certain block number from current coordinates
    private int distanceTo(int i, int j, int n){
        n--;
        int p = n / dimension();
        int q = n % dimension();
        //System.out.println("p: " + p + "q: " + q);
        return Math.abs(i - p) + Math.abs(j - q);
    }

    public int dimension(){
        return blocks[0].length;
    }
    
    public int hamming(){
        int count = 0;
        for (int i = 0; i < dimension(); i++){
            for (int j = 0; j < dimension(); j++){
                //System.out.println(this.blocks[i][j] + " / " + coordsToNumber(i, j));
                if (!(i == dimension() - 1 && i == j)){
                    if (this.blocks[i][j] != coordsToNumber(i, j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public int manhattan(){
        int count = 0;
        for (int i = 0; i < dimension(); i++){
            for (int j = 0; j < dimension(); j++){
                //System.out.println(this.blocks[i][j] + " / " + coordsToNumber(i, j));
                if (this.blocks[i][j] != coordsToNumber(i, j) && this.blocks[i][j] != 0){
                    count = count + distanceTo(i, j, this.blocks[i][j]);
                }
            }
        }
        return count;

    }
    public boolean isGoal(){
        for (int i = 0; i < dimension(); i++){
            for (int j = 0; j < dimension(); j++){
                if (i == dimension() - 1 && i == j) {
                    if (this.blocks[i][j] != 0) {
                        return false;
                    }
                }else if (this.blocks[i][j] != coordsToNumber(i, j)){
                    return false;
                }
            }
        }

        return true;
    }
    public Board twin(){
        return null;
    }
    public boolean equals(Object y){
        int[][] b = (int[][]) y;
        for (int i = 0; i < dimension(); i++){
            for (int j = 0; j < dimension(); j++){
                if (this.blocks[i][j] != b[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public Iterable<Board> neighbors(){
        return null;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimension(); i++){
            for (int j = 0; j < dimension(); j++){
                sb.append(this.blocks[i][j] + "\t");
                if (j == dimension() - 1){
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int[][] ba = new int[3][3];
        ba[0][0] = 8;
        ba[0][1] = 1;
        ba[0][2] = 3;
        ba[1][0] = 4;
        ba[1][1] = 0;
        ba[1][2] = 2;
        ba[2][0] = 7;
        ba[2][1] = 6;
        ba[2][2] = 5;

        int[][] ba2 = new int[3][3];
        ba2[0][0] = 1;
        ba2[0][1] = 2;
        ba2[0][2] = 3;
        ba2[1][0] = 4;
        ba2[1][1] = 5;
        ba2[1][2] = 6;
        ba2[2][0] = 7;
        ba2[2][1] = 8;
        ba2[2][2] = 0;

        Board b = new Board(ba);
        System.out.println(b.toString());
        System.out.println(b.isGoal());
        System.out.println("hamming: " + b.hamming());
        System.out.println("manhattan: "+ b.manhattan());

        b = new Board(ba2);
        System.out.println(b.toString());
        System.out.println(b.isGoal());
        System.out.println("hamming: " + b.hamming());
        System.out.println("manhattan: "+ b.manhattan());


    }
}
