package career.softserveinc.com.softserve.Model.task1;

public class ChessBoard implements Drawable {

    private int height;
    private int width;

    ChessBoard(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public StringBuilder createBoard() {
        boolean decorLine = true;
        boolean emptyField = true;
        StringBuilder sb = new StringBuilder();
        sb.append(createDecorationForBoard());
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
        sb.append(createDecorationForBoard());
        return sb;
    }


    public StringBuilder createDecorationForBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        for (int i = 0; i < width * 2 - 1; i++) {
            sb.append("-");
        }
        sb.append("+");
        sb.append("\n");
        return sb;
    }

}
