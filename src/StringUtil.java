public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static String replicate(char c, int n)
    {
        String res = "";
        for (int i = 0; i < n; i++) {
            res += c;
        }
        return res;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "005"
    public static String lpad(String s, int n, char c)
    {
        String pre = replicate(c, n - s.length());
        return pre + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String res[] = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Integer converted = new Integer(arr[i]);
            res[i] = converted.toString();
        }
        return res;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int res[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Integer converted = new Integer(arr[i]);
            res[i] = Integer.parseInt(arr[i]);
        }
        return res;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length() > max) {
                max = arr[i].length();
            }
        }
        return max;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String[] arr, char c)
    {
        int maxLen = maxLength(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], maxLen, c);
        }
    }
}
