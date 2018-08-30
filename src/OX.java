public class OX {
    String[][] table = {
            {" ","0","1","2"},
            {"0","-","-","-"},
            {"1","-","-","-"},
            {"2","-","-","-"}
    };
    private String currentPlayer;
    private int turnCount;
    private int scoreX;
    private int scoreO;
    private int scoreDraw;

    public OX(){
        currentPlayer = "x";
        turnCount=0;
        scoreX=0;
        scoreO=0;
        scoreDraw=0;
    }

    public String getTableString() {
        String result = "";
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                result = result + table[i][j];
            }result = result+"\n";
        }
        return result;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        if (currentPlayer.equals("x")) {
            currentPlayer = "o";
        }else{
            currentPlayer = "x";
        }
    }

    public boolean put(int col, int row) {
        try{

            if(!table[row+1][col+1].equals("-")){
                return false;
            }
            table[row+1][col+1] = currentPlayer;
        }catch(Exception e){
           return  false;
        }
        turnCount++;
        if(checkWin(col, row)){
            if(currentPlayer.equals("x")){
                scoreX++;
            }else if(currentPlayer.equals("o")){
                scoreO++;
            }
        }
        if(isDraw()){
            scoreDraw++;
        }

        return true;
    }

    public String get(int col, int row) {
        if(col > 2 || col < 0 || row < 0 || row > 2){
            return null;
        }
        return table[row+1][col+1];
    }

    public boolean checkWin(int col, int row) {
        /* checkColWin */
        boolean colWin = true;
        for(int i=0;i<3;i++){
            if(!table[i+1][col+1].equals(currentPlayer)){
                colWin = false;
            }
        }
        if(colWin){
            return colWin;
        }

        boolean rowWin = true;
        for(int i=0;i<3;i++){
            if(!table[row+1][i+1].equals(currentPlayer)){
                rowWin = false;
            }
        }
        if(rowWin){
            return rowWin;
        }

        boolean esWIN = true;
        for(int i=0;i<3;i++){
            if(!table[i+1][i+1].equals(currentPlayer)){
                esWIN = false;
            }
        }
        if(esWIN){
            return esWIN;
        }

        boolean ssWin = true;
        for(int i=0;i<3;i++){
            if(!table[i+1][3-i].equals(currentPlayer)){
                ssWin = false;
            }
        }
        if(ssWin){
            return ssWin;
        }

        return false;
    }

    public void reset() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                table[i+1][j+1] = "-";
            }
        }
        currentPlayer="x";
        turnCount=0;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public boolean isDraw() {
        if(turnCount < 9){
            return false;
        }return true;
    }

    public int getScoreX() {
        return scoreX;
    }

    public int getScoreO() {
        return scoreO;
    }

    public int getScoreDraw() {
        return scoreDraw;
    }
}
