public class test {
    public static void main(String[] arg) {
    int array1[][] = new int[4][];
    array1[0]=new int[2];
    array1[1]=new int[2];
    array1[2]=new int[3];
    array1[3]=new int[4];
    array1[2][1]=1;
    int stop = 1;
    for(int[] i : array1){
        for(int a: i){
            System.out.println("hi");
            if(a==1){
                stop = 0 ;
                break;
            }
        }
        if(stop==0){
            break;
        }System.out.println("outerloop");
        }
    }

}
