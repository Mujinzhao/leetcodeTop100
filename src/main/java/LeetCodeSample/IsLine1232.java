package LeetCodeSample;

public class IsLine1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        boolean ans = true;

        if(coordinates.length == 2){
            return true;
        }
        int firstX = coordinates[0][0];
        int firstY = coordinates[0][1];
        double firstTanRate = (double)Math.abs(coordinates[1][1] - firstY)/(double)Math.abs(coordinates[1][0] - firstX);
        for(int i=2;i<coordinates.length;i++){
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            double tanRate = (double)Math.abs(y - firstY)/(double)Math.abs(x - firstX);
            if(tanRate != firstTanRate){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[][] lines = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        IsLine1232 test = new IsLine1232();
        boolean result = test.checkStraightLine(lines);
        return;
    }
}
