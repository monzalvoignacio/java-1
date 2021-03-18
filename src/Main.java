import java.util.ArrayList;
import java.util.HashMap;

public class Main
{
    public static void radixSort(int []arr)
    {
//        Initialize empty lists
        HashMap<Integer, ArrayList<String>> hm = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hm.put(i, new ArrayList<String>());
        }
        String aArr[] = StringUtil.toStringArray(arr);
        int maxElement = StringUtil.maxLength(aArr);

//            Normalize aArr
        StringUtil.lNormalize(aArr, '0');

        for (int i = 0; i < maxElement; i++) {
            //        Iterate over arr elements and append them to corresponding list
//            char lastChar = '0';
            for (int j = 0; j < aArr.length; j++) {
                char lastChar = aArr[j].charAt(aArr[j].length() - 1 - i);
                int parsedLastChar = Character.getNumericValue(lastChar);
                hm.get(parsedLastChar).add(aArr[j]);
                aArr[j] = "";
            }
            int cont = 0;
            for (int j = 0; j < 10; j++) {
                if(hm.get(j) != null) {
                    int elementsInLayer = hm.get(j).toArray().length;
                    for (int k = 0; k < elementsInLayer; k++) {
                        aArr[cont] = hm.get(j).get(k);
                        cont++;
                    }
                    hm.get(j).clear();
                }
            }
        }

        for(int j=0; j<aArr.length;j++)
        {
            System.out.print(aArr[j]+(j<aArr.length-1?",":""));
        }
    }

    public static void main(String[] args)
    {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
//            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }
}