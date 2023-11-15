package utilidades;

public class Tablas {
    public static void imprimirArrayVertical(String[] arrayDeStrings, int espacios) {
        String sMasLargo = buscarStringMasLargo(arrayDeStrings);
        
        sMasLargo = "|" +  " ".repeat(espacios) + sMasLargo + " ".repeat(espacios) + "|";
        
        System.out.println("-".repeat(sMasLargo.length() + 2));
        for (String str : arrayDeStrings){
                str = armarString(sMasLargo.length(), str, espacios, true);
                System.out.println(str);
        }
        System.out.println("-".repeat(sMasLargo.length() + 2));
    }
    
    public static int largoTablaHorizontal(String[] arrayDeCosas, int espacios){
        String sMasLargo = buscarStringMasLargo(arrayDeCosas);
        String sTemp = "";
        for (int i = 0; i < arrayDeCosas.length; i++){
            String str = arrayDeCosas[i];
            if (i == 0){
                sTemp =  sTemp + "|" + armarString(sMasLargo.length(), str, espacios, false) + "|";
            }else {
                sTemp = sTemp + armarString(sMasLargo.length(), str, espacios, false) + "|";
            }
        }
        return sTemp.length();
    }
    
    private static String buscarStringMasLargo(String[] array){
        int longitudMaxima = 0;
        String stringMasLargo = "";
        for (String str : array) {
            if (str.length() > longitudMaxima) {
                longitudMaxima = str.length();
                stringMasLargo = str;
            }
        }
        return stringMasLargo;
    }
    
    private static String armarString(int masLargo, String str, int espacios, boolean vertical){
        String oTemp = "";
        if (vertical){
            oTemp = "|" + " ".repeat(espacios) + str;
            
            while (oTemp.length() - 1 != masLargo){
                oTemp = oTemp + " ".repeat(1);
            }
            
            oTemp = oTemp + "|";
        } else {
            oTemp = " ".repeat(espacios) + str + " ".repeat(espacios);
        }
        return oTemp;
    }
    
//    public static void imprimirArrayHorizontal(String[] arrayDeCosas, int espacios) {
//        String sMasLargo = buscarStringMasLargo(arrayDeCosas);
//
//        for (int i = 0; i < arrayDeCosas.length; i++){
//            String str = arrayDeCosas[i];
//            if (i == 0){
//                System.out.print("|" + armarString(sMasLargo.length(), str, espacios, false) + "|");
//            }else {
//                System.out.print(armarString(sMasLargo.length(), str, espacios, false) + "|");
//            }
//        }
//        System.out.println("");
//    }
    
//    private static String armarTitulo(String[] array, String titulo, String sMasLargo){
//        String sTemp = "";
//        for (int i = 0; i < array.length; i++){
//            String str = array[i];
//            if (i == 0){
//                sTemp = "|" + sTemp + armarString(sMasLargo.length(), str, espacios, false) + " ".repeat(espacios) + "|";
//            }else {
//                sTemp = sTemp + armarString(sMasLargo.length(), str, espacios, false) + " ".repeat(espacios) + "|";
//            }
//        }
//        return sTemp;
//    }
//    
//    public static void largoTitulo(String[] array, String titulo){
//        String sMasLargo = buscarStringMasLargo(array);
//        String largoTitulo = armarTitulo(array, titulo, sMasLargo);
//        int espaciosPTitulo = (largoTitulo.length() - titulo.length()) / 2;
//        if (espaciosPTitulo < largoTitulo.length() * 2){
//            System.out.println("-".repeat(espaciosPTitulo) + titulo + "-".repeat(espaciosPTitulo) + "-");
//        } else {
//            System.out.println("-".repeat(espaciosPTitulo) + titulo + "-".repeat(espaciosPTitulo));
//        }
//        
//    }
}
