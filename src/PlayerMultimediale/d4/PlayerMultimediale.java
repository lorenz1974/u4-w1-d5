/*

Il codice implementa un sistema multimediale con le classi
 - Immagine
 - RegistrazioneAudio
 - Video
che estendono la classe astratta ElementoMultimediale e sfruttano polimorfismo.

L'interfaccia 'Riproducibile' separa la logica degli elementi riproducibili (audio e video) da Immagine.
L'uso dell'interfaccia permette di definire comportamenti specifici (play) per gli elementi riproducibili
senza mescolare la logica con elementi Immagine.

PlayerMultimediale può essere eseguito definendo i brani manualmente o generandoli in maniera pseudorandomica.
Prima di scegliere il brano da mandare in esecuzione li mostra tutti a video.
Finita l'esecuzione del brano mostra di nuovo a video l'elenco.
Il ciclo si ripete finché l'utente non esce dal loop premendo "0".

Non ho trovato un modo più efficace di quello implementato per ripulire lo schermo.

 */

package PlayerMultimediale.d4;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

// Classe principale per il Player Multimediale
public class PlayerMultimediale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        // Uso String per evitare errori in caso di input impropri da parte dell'utente
        String genera = "";
        while (!Objects.equals(genera, "1") && !Objects.equals(genera, "2") && !Objects.equals(genera, "3")) {

            pulisciSchermo();

            System.out.print("Scegli se indicare gli elementi [1] o generarli randomicamente [2] o esci [3]: ");
            genera = scanner.nextLine();
        }

        // Intento gestisco il più facile... esco
        if (genera.equals("3")) {
            System.out.print("Chiudo il player. Bye bye!");
            return;
        }

        // Se l'utente sceglie la generazione randomica
        if (genera.equals("2")) {

            for (int i = 0; i < 5; i++) {

                Random random = new Random();

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
                        System.out.print("Come hai fatto ad arrivare qui? :|");
                        i--;
                }

            }
        }

        // Se l'utente sceglie di indicare ogni singolo brano
        if (genera.equals("1")) {

            // Metodo di PlayerMultimediale
            pulisciSchermo();

            // Creazione degli elementi multimediali
            for (int i = 0; i < 5; i++) {
                System.out.print("Inserisci tipo di elemento (1: Immagine, 2: Audio, 3: Video): ");
                int tipo = scanner.nextInt();
                scanner.nextLine(); // Consuma newline

                System.out.print("Inserisci il titolo: ");
                String titolo = scanner.nextLine();

                switch (tipo) {
                    case 1:
                        System.out.print("Inserisci luminosità: ");
                        int luminosita = scanner.nextInt();
                        elementi[i] = new Immagine(titolo, luminosita);
                        break;
                    case 2:
                        System.out.print("Inserisci durata: ");
                        int durataAudio = scanner.nextInt();
                        System.out.print("Inserisci volume: ");
                        int volumeAudio = scanner.nextInt();
                        elementi[i] = new RegistrazioneAudio(titolo, durataAudio, volumeAudio);
                        break;
                    case 3:
                        System.out.print("Inserisci durata: ");
                        int durataVideo = scanner.nextInt();
                        System.out.print("Inserisci volume: ");
                        int volumeVideo = scanner.nextInt();
                        System.out.print("Inserisci luminosità: ");
                        int luminositaVideo = scanner.nextInt();
                        elementi[i] = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                        break;
                    default:
                        System.out.print("Tipo non valido.");
                        i--;
                }
            }
        }

        pulisciSchermo();

        // Esecuzione degli elementi multimediali
        while (true) {


            // Elenca i brani
            System.out.println("Elenco dei brani:");
            int i = 1;
            for (ElementoMultimediale elemento : elementi) {
                stampaElemento(i, elemento);
                i++;
            }

            // Richiede il brano da mandare in play
            System.out.print("Scegli un elemento da eseguire (1-5) o 0 per uscire: ");
            int scelta = scanner.nextInt();

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
        // Formatta la stampa
        System.out.println(i + "] Elemento");
        System.out.print("\t");
        elemento.toString();
        System.out.println();

    }

    // Esegue l'elemento con qualche istruzione per la presentazione
    static void eseguiElemento(ElementoMultimediale elemento){
        System.out.println("-".repeat(20));
        elemento.esegui();
        System.out.println("-".repeat(20));
        System.out.println();
    }

    // Cancella lo schermo... torniamo agli anni '80
    static void pulisciSchermo() {
        for (int i = 0; i < 80; ++i) System.out.println();
    }
}


