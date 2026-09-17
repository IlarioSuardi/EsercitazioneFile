import java.io.*;

class Main {
    public static void main(String[] args) {

        try {
            BufferedReader tastiera = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            System.out.print("Inserisci nome: ");
            String nome = tastiera.readLine();

            System.out.print("Inserisci cognome: ");
            String cognome = tastiera.readLine();

            System.out.print("Inserisci luogo vacanza: ");
            String luogo = tastiera.readLine();

            System.out.print("Inserisci azienda PCTO: ");
            String azienda = tastiera.readLine();


            FileWriter fw = new FileWriter("persona.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.newLine();
            bw.write(nome + "," + cognome + "," + luogo + "," + azienda);

            bw.close();
            fw.close();


            FileReader fr = new FileReader("persona.csv");
            BufferedReader br = new BufferedReader(fr);

            Persona[] persone = new Persona[10];
            String line;
            int i = 0;

            while ((line = br.readLine()) != null && i < 10) {

                String[] campi = line.split(",");

                Persona p = new Persona(
                        campi[0].trim(),
                        campi[1].trim(),
                        campi[2].trim(),
                        campi[3].trim()
                );

                persone[i] = p;
                i++;
            }

            br.close();
            fr.close();


            System.out.print("\nInserisci il cognome da cercare: ");
            String cognomeCercato = tastiera.readLine();

            System.out.println("\nRICERCA DI: " + cognomeCercato);

            for (int j = 0; j < i; j++) {

                if (persone[j].getCognome().equalsIgnoreCase(cognomeCercato)) {
                    System.out.println(persone[j].toCSV());
                }
            }

        } catch (IOException e) {
            System.out.println("Errore: " + e);
        }
    }
}