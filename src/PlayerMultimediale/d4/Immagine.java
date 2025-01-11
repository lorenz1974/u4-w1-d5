package PlayerMultimediale.d4;

// Classe per PlayerMultimediale.d4.Immagine
class Immagine extends ElementoMultimediale {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public void aumentaLuminosita() {
        this.luminosita++;
    }

    public void diminuisciLuminosita() {
        if (this.luminosita > 0) this.luminosita--;
    }

    @Override
    public void esegui() {
        show();
    }

    public void show() {
        System.out.println(this.titolo + " " + "*".repeat(this.luminosita));
    }

    @Override
    public String toString() {
        System.out.println(
                "\"" + this.titolo
                + "\", Lum. : " + "*".repeat(this.luminosita)
        );
        return null;
    }
}