package career.softserveinc.com.softserve.task1;

public class ChessBoard {

    private int height;
    private int width;

    public ChessBoard(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public StringBuffer createBoard() {
        boolean decorLine = true;
        boolean emptyField = true;
        StringBuffer sb = new StringBuffer();
        sb.append(createDecoration(width));
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 2; j++) {
                if (decorLine) {
                    sb.append("|");
                    decorLine = false;
                } else {
                    if (emptyField) {
                        sb.append(" ");
                        emptyField = false;
                    } else {
                        sb.append("#");
                        emptyField = true;
                    }
                    decorLine = true;
                }
            }
            sb.append("|");
            sb.append("\n");
            decorLine = true;
            if (width % 2 == 0) {
                emptyField = !emptyField;
            }
        }
        sb.append(createDecoration(width));
        return sb;
    }

    private static StringBuffer createDecoration(int width) {
        StringBuffer sb = new StringBuffer();
        sb.append("+");
        for (int i = 0; i < width * 2 - 1; i++) {
            sb.append("-");
        }
        sb.append("+");
        sb.append("\n");
        return sb;
    }

}
