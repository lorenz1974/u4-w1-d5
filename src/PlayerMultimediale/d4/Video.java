package PlayerMultimediale.d4;

// Classe per Video
class Video extends ElementoMultimediale implements Riproducibile {
    final private int durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public void alzaVolume() {
        this.volume++;
    }

    public void abbassaVolume() {
        if (this.volume > 0) this.volume--;
    }

    public void aumentaLuminosita() {
        this.luminosita++;
    }

    public void diminuisciLuminosita() {
        if (this.luminosita > 0) this.luminosita--;
    }

    @Override
    public void esegui() {
        play();
    }

    @Override
    public void play() {
        for (int i = 0; i < this.durata; i++) {
            System.out.println(titolo + " " + "!".repeat(this.volume));
            System.out.println("*".repeat(this.luminosita));
        }
    }

    @Override
    public String toString() {
        System.out.println
                ("\"" + this.titolo + "\", Durata.: " + this.durata +
                ", Vol.: " + "!".repeat(this.volume) +
                ", Lum. : " + "*".repeat(this.luminosita)
                );
        return null;
    }
}

