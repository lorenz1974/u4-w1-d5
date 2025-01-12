package PlayerMultimediale.d4;

// Classe per Registrazione Audio
class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile {
    final private int durata;
    private int volume;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    public void alzaVolume() {
        this.volume++;
    }

    public void abbassaVolume() {
        if (this.volume > 0) this.volume--;
    }

    @Override
    public void esegui() {
        play();
    }

    @Override
    public void play() {
        for (int i = 0; i < this.durata; i++) {
            System.out.println(titolo + " " + "!".repeat(volume));
        }
    }

    @Override
    public String toString() {
        return
                "\"" + this.titolo +
                "\", Durata.: " + this.durata +
                ", Vol.: " + "!".repeat(this.volume);
    }
}