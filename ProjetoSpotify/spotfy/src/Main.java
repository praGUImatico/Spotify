import enitities.Midia;
import enitities.Musica;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var listaDeReproducao = new ArrayList<Midia>();
        var biblioteca = new ArrayList<Midia>();
        System.out.println("Bem vindo ao seu player de mídeia!");
        var scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Digite a opção desejada:
                      1 - Adicionar música
                      2 - Adicionar podcast
                      3 - Adicionar mídia a lista de reprodução
                      4 - Play
                      5 - Sair
                    """);
            var opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1)
                AdicionarMusica(scanner, biblioteca);
            else if (opcao == 3)
                AdcionarListaReproducao(scanner, biblioteca, listaDeReproducao);
            else if (opcao == 4)
                Reproduzir(listaDeReproducao);
            else if (opcao == 5)
                System.exit(0);
        }
    }

    public static void AdicionarMusica(Scanner scanner, ArrayList<Midia> biblioteca) {
        System.out.println("Digite o titúo da música");
        var titulo = scanner.nextLine();
        System.out.println("Digite o Artista da música");
        var artista = scanner.nextLine();
        System.out.println("Digite o gênero da música");
        var genero = scanner.nextLine();
        System.out.println("Digite o BPM da música");
        var bpm = scanner.nextInt();
        scanner.nextLine();

        var musica = new Musica();
        musica.titulo = titulo;
        musica.bpm = bpm;
        musica.artista = artista;
        musica.genero = genero;
        biblioteca.add(musica);
    }

    public static void AdcionarListaReproducao(Scanner scanner, ArrayList<Midia> biblioteca, ArrayList<Midia> listaDeReproducao) {
        System.out.println("Digite o número da mídia a ser adicionada: ");
        var opcao = scanner.nextInt();
        scanner.nextLine();
        listaDeReproducao.add(biblioteca.get(opcao));
        System.out.println("Mídia adicionada à lista de reprodução!");
    }

    public static void Reproduzir (ArrayList<Midia> listaDeReproducao){
        for(var midia : listaDeReproducao)
            System.out.println("Reproduzindo: " + midia.titulo);
        System.out.println("Player pausado");
    }
}