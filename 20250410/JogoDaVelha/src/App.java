import java.util.Random;
import java.util.Scanner;
 

public class App {
    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String resposta;
    do{
            int dimensao;
            do{
                System.out.println("Digite a dimensao que deseja jogar ( impar):");
                dimensao=sc.nextInt();

                if(dimensao % 2 !=0){
                    

                }
            }while (dimensao % 2 == 0);
          
        
        sc.nextLine();


        JogoDaVelha jogo= new JogoDaVelha(dimensao);
        int jogadasMaximas = dimensao* dimensao; 
        int jogadas = 0;
         String resultado = "";

         System.out.println("jogo inciado com tabuleiro" + dimensao+"x"+ dimensao);
         System.out.println(jogo.toString());
     
        while(jogadas < jogadasMaximas){
        
        int i = rand.nextInt(dimensao);
        int j = rand.nextInt(dimensao);
    

        if(jogo.tabuleiro[i][j]==0){
            System.out.println("Jogada em ["+i+","+j+"]");
            jogo.poePeca(i, j); 
            jogadas++;    
           
            System.out.println(jogo.toString()); 
            resultado=jogo.vencedor();         

            if(!resultado.equals("Jogo em andamento")){ 
                break;  
           } 
    } }


    System.out.println(resultado);

    System.out.println("Deseja jogar novamente?  (y/n)");
    resposta= sc.nextLine().toLowerCase();

} while (resposta.equals("y"));

sc.close();
    
}
}

   






