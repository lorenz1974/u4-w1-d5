package PlayerMultimediale.d4;

import java.util.Random;
import java.util.Scanner;

// Classe principale per il Player Multimediale
public class PlayerMultimediale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        // Uso String per evitare errori in caso di input impropri da parte dell'utente
        int genera = -1;

        while (genera < 1 || genera > 3) {
            pulisciSchermo();
            System.out.print("Scegli se indicare gli elementi [1] o generarli randomicamente [2] o esci [3]: ");
            genera = (int) leggiInput("int");
        }

        // Intento gestisco il più facile... esco
        if (genera == 3) {
            System.out.println("Chiudo il player. Bye bye!");
            return;
        }

        // Se l'utente sceglie la generazione randomica
        if (genera == 2) {
            Random random = new Random();

            for (int i = 0; i < 5; i++) {
                // Genera il tipo di elemento
                int tipo = random.nextInt(3) + 1;

                // Inizializzazione di titolo
                String titolo;

                switch (tipo) {
                    case 1:
                        titolo = "Titolo [" + i + "] - Elemento Immagine";
                        int luminosita = random.nextInt(5) + 1;
                        elementi[i] = new Immagine(titolo, luminosita);
                        break;
                    case 2:
                        titolo = "Titolo [" + i + "] - Elemento Audio";
                        int durataAudio = random.nextInt(5) + 1;
                        int volumeAudio = random.nextInt(5) + 1;
                        elementi[i] = new RegistrazioneAudio(titolo, durataAudio, volumeAudio);
                        break;
                    case 3:
                        titolo = "Titolo [" + i + "] - Elemento Video";
                        int durataVideo = random.nextInt(5) + 1;
                        int volumeVideo = random.nextInt(5) + 1;
                        int luminositaVideo = random.nextInt(5) + 1;
                        elementi[i] = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                        break;
                    default:
                        System.out.println("Errore nella generazione dell'elemento, riprovo...");
                        i--;
                }
            }
        }

        // Se l'utente sceglie di indicare ogni singolo brano
        if (genera == 1) {
            pulisciSchermo();

            // Creazione degli elementi multimediali
            for (int i = 0; i < 5; i++) {
                System.out.print("Inserisci tipo di elemento (1: Immagine, 2: Audio, 3: Video): ");
                int tipo = (int) leggiInput("int");

                System.out.print("Inserisci il titolo: ");
                String titolo = (String) leggiInput("string");

                switch (tipo) {
                    case 1:
                        System.out.print("Inserisci luminosità: ");
                        int luminosita = (int) leggiInput("int");
                        elementi[i] = new Immagine(titolo, luminosita);
                        break;
                    case 2:
                        System.out.print("Inserisci durata: ");
                        int durataAudio = (int) leggiInput("int");
                        System.out.print("Inserisci volume: ");
                        int volumeAudio = (int) leggiInput("int");
                        elementi[i] = new RegistrazioneAudio(titolo, durataAudio, volumeAudio);
                        break;
                    case 3:
                        System.out.print("Inserisci durata: ");
                        int durataVideo = (int) leggiInput("int");
                        System.out.print("Inserisci volume: ");
                        int volumeVideo = (int) leggiInput("int");
                        System.out.print("Inserisci luminosità: ");
                        int luminositaVideo = (int) leggiInput("int");
                        elementi[i] = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                        break;
                    default:
                        System.out.println("Hai sbagliato qualcosa...");
                        i--;
                }
            }
        }

        pulisciSchermo();

        // Esecuzione degli elementi multimediali
        while (true) {
            // Elenca i brani
            System.out.println("Elenco dei brani:");
            for (int i = 0; i < elementi.length; i++) {
                stampaElemento(i + 1, elementi[i]);
            }

            // Richiede il brano da mandare in play
            System.out.print("Scegli un elemento da eseguire (1-5) o 0 per uscire: ");
            int scelta = (int) leggiInput("int");

            if (scelta == 0) break;

            if (scelta >= 1 && scelta <= 5) {
                eseguiElemento(elementi[scelta - 1]);
            } else {
                System.out.println("Scelta non valida.");
            }
        }

        scanner.close();
    }

    static void stampaElemento(int i, ElementoMultimediale elemento) {
        if (elemento != null) {
            System.out.println(i + "] " + elemento.toString());
        } else {
            System.out.println(i + "] Nessun elemento.");
        }
    }

    // Esegue l'elemento con qualche istruzione per la presentazione
    static void eseguiElemento(ElementoMultimediale elemento) {
        if (elemento != null) {
            System.out.println("-".repeat(20));
            elemento.esegui();
            System.out.println("-".repeat(20));
            System.out.println();
        } else {
            System.out.println("Elemento non valido.");
        }
    }

    // Cancella lo schermo... torniamo agli anni '80
    static void pulisciSchermo() {
        for (int i = 0; i < 80; ++i) System.out.println();
    }

    // Verifica l'input dell'utente
    public static Object leggiInput(String tipo) {
        Scanner scanner = new Scanner(System.in);
        Object risultato = null;
        boolean inputValido = false;

        while (!inputValido) {
            try {
                String input = scanner.nextLine();

                switch (tipo.toLowerCase()) {
                    case "int":
                        risultato = Integer.parseInt(input);
                        break;
                    case "double":
                        risultato = Double.parseDouble(input);
                        break;
                    case "string":
                        risultato = input;
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo non supportato: " + tipo);
                }
                inputValido = true;
            } catch (Exception e) {
                System.out.println("Input non valido, riprova.");
            }
        }

        return risultato;
    }
}
