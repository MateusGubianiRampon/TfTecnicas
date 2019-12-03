/*
import java.awt.geom.Rectangle2D;

import javax.swing.text.Utilities;

import java.awt.geom.Line2D;
import java.awt.geom.*;
*/
/**
 * Implements the well known Cohen Sutherland line clipping algorithm (line
 * against clip rectangle).
 */
public final class AlgoritmodeCohenESutherland {
    private int xMin;
    private int yMin;
    private int xMax;
    private int yMax;

    /**
     * Creates a Cohen Sutherland clipper with clip rect (0, 0, 0, 0).
     */
    public AlgoritmodeCohenESutherland() {
    }

    /**
     * Creates a Cohen Sutherland clipper with the given clip rectangle.
     * 
     * @param clip the clip rectangle to use
     */
    public AlgoritmodeCohenESutherland(Area clip) {
        setClip(clip);
    }

    /**
     * Sets the clip rectangle.
     * 
     * @param clip the clip rectangle
     */
    public void setClip(Area clip) {
        xMin = clip.getPInfDir().getX();
        xMax = xMin + clip.getPSupEsq().getX();
        yMin = clip.getPInfDir().getY();
        yMax = yMin + clip.getPSupEsq().getY();
    }

    private static final int INSIDE = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int BOTTOM = 4;
    private static final int TOP = 8;

    private final int regionCode(int x, int y) {
        int code = x < xMin ? LEFT : x > xMax ? RIGHT : INSIDE;
        if (y < yMin)
            code |= BOTTOM;
        else if (y > yMax)
            code |= TOP;
        return code;
    }

    /**
     * Clips a given line against the clip rectangle. The modification (if needed)
     * is done in place.
     * 
     * @param line the line to clip
     * @return true if line is clipped, false if line is totally outside the clip
     *         rect.
     */
    public SituacaoReta clip(Reta line) {

        int p1x = line.getP1().getX();
        int p1y = line.getP1().getY();
        int p2x = line.getP2().getX();
        int p2y = line.getP2().getY();

        int qx = 0;
        int qy = 0;

        boolean vertical = p1x == p2x;

        int slope = vertical ? 0 : (p2y - p1y) / (p2x - p1x);

        int c1 = regionCode(p1x, p1y);
        int c2 = regionCode(p2x, p2y);

        SituacaoReta aux = SituacaoReta.TODA_DENTRO;

        while (c1 != INSIDE || c2 != INSIDE) {

            if ((c1 & c2) != INSIDE){
                aux = SituacaoReta.TODA_FORA;
                return aux;
            }

            int c = c1 == INSIDE ? c2 : c1;

            if ((c & LEFT) != INSIDE) {
                qx = xMin;
                qy = (Math.abs(c1 - c2) < 0.001 ? 0 : qx - p1x) * slope + p1y;
                aux = SituacaoReta.INTERSECTA;
            }
            else if ((c & RIGHT) != INSIDE) {
                qx = xMax;
                qy = (Math.abs(c1 - c2) < 0.001 ? 0 : qx-p1x)*slope + p1y;
                aux = SituacaoReta.INTERSECTA;
            }
            else if ((c & BOTTOM) != INSIDE) {
                qy = yMin;
                qx = vertical
                    ? p1x
                    : (Math.abs(c1 - c2) < 0.001 ? 0 : qy-p1y)/slope + p1x;
                aux = SituacaoReta.INTERSECTA;
            }
            else if ((c & TOP) != INSIDE) {
                qy = yMax;
                qx = vertical
                    ? p1x
                    : (Math.abs(c1 - c2) < 0.001 ? 0 : qy-p1y)/slope + p1x;
                aux = SituacaoReta.INTERSECTA;
            }

            if (c == c1) {
                p1x = qx;
                p1y = qy;
                c1  = regionCode(p1x, p1y);
            }
            else {
                p2x = qx;
                p2y = qy;
                c2 = regionCode(p2x, p2y);
            }
        }
        line.setLine(p1x, p1y, p2x, p2y);
        aux = SituacaoReta.TODA_DENTRO;
        return aux;
    }
}