/*
 * TestArgumentsCommandeAttendus.java								12 mai 2015
 * IUT INFO 2014-2015 
 */
package testcalcul.test;

/** 
 * TODO commenter la responsabilité de la classe
 * @author Thomas Affre
 * @author Clément Zeghmati
 * @author Thibaut Méjane
 * @author Florian Louargant
 */
public class TestArgumentsCommandeAttendus {
    

    /** TODO commenter le role du champ */
    private static final String[][] Instructions = {{ "","" },
        {"","",""},
        {"","","",""}};

    /**
     * TODO commenter le role de la methode
     * @param commande
     * @return true
     */
    public static boolean argumentsCommandeAttendus(String commande) {
        
        switch (commande.toString()) {
        case "CONT" :
        case "RAZ" :
            // La commande et la plage (facultatif)
            return Instructions[0].length <= 2;
        case "INIT" :
            // La commande, la plage mémoire (facultatif) et la valeur
            return Instructions[0].length == 2
                    || Instructions[1].length == 3;
        case "FORM" :
            // La commande et la plage mémoire
            return Instructions[0].length == 2;
        case "COPIER" :
        case "COPVAL" :
            // La commande, la plage mémoire et la valeur
            return Instructions[1].length == 3;
        
        }
        return false;
    }

    /**
     * Test plusieurs chaines de caractères Dont toutes les commandes du tableur
     * et affiche true si le nombre d'instruction correspond bien au cahier des
     *  charges ou false si la commande n'est pas prise en compte
     * @param args unused
     */
    public static void main(String[] args) {
        
        String[] correcte = { "CONT" , "RAZ" , "INIT" , "FORM" , "COPIER" ,
                              "COPVAL" };

        String[] incorrecte = { "raz" , "546" , "()" , "" , "A" , " " };
        
        //Chaine Correcte
        System.out.println("\nChaines correctes :\n");
        for(int i = 0 ; i < correcte.length ; i++ ){
             System.out.println(correcte[i] + "\t" 
                         + argumentsCommandeAttendus(correcte[i]));
        }
        
        //Chaine Correcte
        System.out.println("\nChaines incorrectes :\n");
        for(int i = 0 ; i < incorrecte.length ; i++ ){
             System.out.println(incorrecte[i] + "\t" 
                         + argumentsCommandeAttendus(incorrecte[i]));
        }

    }

}
