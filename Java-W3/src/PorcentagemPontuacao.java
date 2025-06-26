public class PorcentagemPontuacao {
    public static void main(String[] args) {
        //Definir pontuacao maxima
        int maxPontuacao = 500;
        //Pontuacao do usuario
        int userPontos = 423;

        /*Calcula a porcentagem da pontuacao do usuario em relacao a pontuacao total.
        Convereter para float, para informacao precisa*/

        float porcentagem = (float) userPontos / maxPontuacao * 100.0f;

        //Imprimir resultado
        System.out.println("A porcentagem do usuario é: " + porcentagem);
    }
}
