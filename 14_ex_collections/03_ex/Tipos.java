public enum Tipos {
    TEXT, DATE, DATEHOUR, INT, FLOAT, BOOLEAN, LIST;


    public static boolean isValidTipo(String tipo) {
        for (Tipos t : Tipos.values()) {
            if (t.name().equalsIgnoreCase(tipo)) {
                return true;
            }
        }
        return false;
    }
}
