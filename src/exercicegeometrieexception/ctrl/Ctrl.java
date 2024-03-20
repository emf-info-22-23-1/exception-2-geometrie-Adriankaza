package exercicegeometrieexception.ctrl;

import exercicegeometrieexception.ihm.IIhmCtrl;
import exercicegeometrieexception.wrk.IWrkCtrl;

public class Ctrl implements ICtrlIhm {

    private IIhmCtrl refIhm;
    private IWrkCtrl refWorker;

    public void demarrer() {
        refIhm.demarrer();
    }

    @Override
    public void selectCalcRadius(String value) {

        double valueDouble = 0;
        refIhm.afficheMessage("");

        try {
            valueDouble = Double.parseDouble(value);
            refIhm.afficheResultatCircle(String.valueOf(refWorker.calcRadiusCircleFromArea(valueDouble)));
        } catch (NumberFormatException e) {

            refIhm.afficheMessage("Veuillez entrer une valeur valide pour le rayon du cercle (" + value + " invalide )");
        }
    }

    @Override
    public void selectCalcLargeur(String valueArea, String valueLongueur) {

        double valueAreaDouble = 0;
        double valueLongueurDouble = 0;

        try {
            valueAreaDouble = Double.parseDouble(valueArea);

        } catch (NumberFormatException e) {

            refIhm.afficheMessage("Veuillez entrer une valeur valide pour l'aire du rectangle (" + valueArea + " invalide )");
        }

        try {
            valueLongueurDouble = Double.parseDouble(valueLongueur);
            refIhm.afficheResultatRectangle(String.valueOf(refWorker.calcLargeurFromRectangle(valueAreaDouble, valueLongueurDouble)));
            
        } catch (NumberFormatException e) {
            refIhm.afficheMessage("Veuillez entrer une valeur valide pour la longeur du rectangle (" + valueLongueur + " invalide )");
        } catch (ArithmeticException e){
            refIhm.afficheMessage("Veuillez mettre un chiffre ou un nombre autre que 0 ");
        }

    }

    public void setRefIhm(IIhmCtrl refIhm) {
        this.refIhm = refIhm;
    }

    public void setRefWorker(IWrkCtrl refWorker) {
        this.refWorker = refWorker;
    }

}
