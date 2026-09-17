class Persona {
    private String nome;
    private String cognome;
    private String luogoVacanza;
    private String aziendaPCTO;

    public Persona(String nome, String cognome, String luogoVacanza, String aziendaPCTO) {
        this.nome = nome;
        this.cognome = cognome;
        this.luogoVacanza = luogoVacanza;
        this.aziendaPCTO = aziendaPCTO;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String toCSV() {
        return nome + ", " + cognome + ", " + luogoVacanza + ", " + aziendaPCTO;
    }
}