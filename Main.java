import java.io.*;

class Main {
    public static void main(String[] args) {

        try {
            FileWriter fw = new FileWriter("persona.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.newLine();
            bw.write("Davide,Paternò,mare,ABB \n");
            bw.write("Ilario,Suardi,gallipoli/napoli,projectInfo \n");
            bw.write("Deyae,Bellafkih,salento,exa italia \n");
            bw.write("Federico,Mazzoleni,toscana/riccione,otg informatica \n");
            bw.write("Giacomo,Rota,brasile,tecnobody \n");
            bw.write("Yassin,Ouldib,marocco,non fatto \n");
            bw.write("Zakkaria,ElHaiki,marocco/riccione,projectInfo \n");
            bw.write("Daouda,Ndaw,lecco,projectInfo \n");

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


            System.out.println("DATI PRESENTI:");

            for (int j = 0; j < i; j++) {
                System.out.println(persone[j].toCSV());
            }


            String cognomeCercato = "Rota";

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