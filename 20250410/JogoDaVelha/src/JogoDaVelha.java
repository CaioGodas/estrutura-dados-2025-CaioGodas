public class JogoDaVelha {
    protected static final int X = 1, O = -1;
    protected static final int VAZIO = 0;
    protected int tabuleiro[][];
    protected int jogador;
    protected int dimensao;

    public JogoDaVelha(int dimensao) {
        this.dimensao = dimensao;
        tabuleiro = new int[dimensao][dimensao];
        limpaTabuleiro();
    }

    public void limpaTabuleiro() {
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                tabuleiro[i][j] = VAZIO;
            }
        }
        jogador = X;
    }

    public void poePeca(int i, int j) {
        if (i < 0 || i >= dimensao || j < 0 || j >= dimensao) {
            throw new IllegalArgumentException("Posição inválida");
        }
        if (tabuleiro[i][j] != VAZIO)
            throw new IllegalArgumentException("Posição ocupada");
        tabuleiro[i][j] = jogador;

        jogador = -jogador;
    }

    public boolean descVencedor(int marca) {

        for (int i = 0; i < dimensao; i++) {
            int somaLinha = 0;
            for (int j = 0; j < dimensao; j++) {
                somaLinha += tabuleiro[i][j];
            }
            if (somaLinha == marca * dimensao) {
                return true;
            }
        }

        for (int j = 0; j < dimensao; j++) {
            int somaColuna = 0;
            for (int i = 0; i < dimensao; i++) {
                somaColuna += tabuleiro[i][j];
            }
            if (somaColuna == marca * dimensao) {
                return true;
            }
        }

        int somaDiagonal1 = 0;
        for(int i = 0; i < dimensao; i ++){
            somaDiagonal1+= tabuleiro[i][i];
        }
        if (somaDiagonal1 == marca * dimensao) {
            return true;
        }
        int somaDiagonal2 =0;
        for(int i = 0; i < dimensao; i++){
        somaDiagonal2+= tabuleiro[i][dimensao -1 -i];
    }
        if (somaDiagonal2 == marca * dimensao) {
            return true;
        }

        return false;
    }

    public String vencedor() {
        if (descVencedor(X)) {
            return ("Jogador X ganhou!!");
        } else if (descVencedor(O)) {
            return ("Jogador O ganhou!!");
        } else {
            for (int i = 0; i < dimensao; i++) {
                for (int j = 0; j < dimensao; j++) {
                    if(tabuleiro[i][j] == VAZIO)
                    return "Jogo em andamento";
                
            }
                
            }
            return "Puts!! Empate";
        }

    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                switch (tabuleiro[i][j]) {
                    case X:
                        s.append ("X");
                        break;
                    case O:
                        s.append("O");
                        break;
                    case VAZIO:
                        s.append (" ");
                        break;
                }
                if (j < dimensao - 1)
                    s.append("|"); // limite da coluna
            }
            if (i < dimensao - 1)
                s.append("\n");
                for( int k=0; k< dimensao *2- 1; k++){
                s.append("-"); // limite da linha
        }
     s.append("\n");
    }
        return s.toString();
    }
}
