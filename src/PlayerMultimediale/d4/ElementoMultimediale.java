package PlayerMultimediale.d4;

// Classe astratta per elementi multimediali
abstract class ElementoMultimediale {
    protected String titolo;

    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

    public abstract void esegui();

    public abstract String toString();
}