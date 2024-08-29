import processing.core.PApplet;
import processing.core.PVector;

public class MainClass extends PApplet {
    public static void main(String[] args) {
        PApplet.main("MainClass", args);
    }

    public void settings() {
        size(1000, 1000);
    }

    public void setup() {
        PVector a = new PVector(random(0, width), random(0, height));
        PVector b = new PVector(random(0, width), random(0, height));
        PVector c = new PVector(random(0, width), random(0, height));
        PVector[] l1 = perpendicular(a, b);
        PVector[] l2 = perpendicular(b, c);
        PVector i = intersection(l1, l2);
        float r = PVector.dist(a, i);

        background(255);

        strokeWeight(2);
        stroke(20, 50, 220);
        circle(i.x, i.y, r * 2);

        strokeWeight(5);
        stroke(220, 50, 90);
        line(l1[0].x, l1[0].y, l1[1].x, l1[1].y);
        line(l2[0].x, l2[0].y, l2[1].x, l2[1].y);

        stroke(0);
        line(a.x, a.y, b.x, b.y);
        line(b.x, b.y, c.x, c.y);

        strokeWeight(15);
        stroke(50, 200, 100);
        point(i.x, i.y);
    }

    public void draw() {}

    public void keyPressed() {
        if (keyCode == 32) {
            PVector a = new PVector(random(0, width), random(0, height));
            PVector b = new PVector(random(0, width), random(0, height));
            PVector c = new PVector(random(0, width), random(0, height));
            PVector[] l1 = perpendicular(a, b);
            PVector[] l2 = perpendicular(b, c);
            PVector i = intersection(l1, l2);
            float r = PVector.dist(a, i);

            background(255);

            strokeWeight(2);
            stroke(20, 50, 220);
            circle(i.x, i.y, r * 2);

            strokeWeight(5);
            stroke(220, 50, 90);
            line(l1[0].x, l1[0].y, l1[1].x, l1[1].y);
            line(l2[0].x, l2[0].y, l2[1].x, l2[1].y);

            stroke(0);
            line(a.x, a.y, b.x, b.y);
            line(b.x, b.y, c.x, c.y);

            strokeWeight(15);
            stroke(50, 200, 100);
            point(i.x, i.y);
        }
    }

    public PVector[] perpendicular(PVector a, PVector b) {
        PVector mid = new PVector(lerp(a.x, b.x, 0.5f), lerp(a.y, b.y, 0.5f));
        PVector p = PVector.sub(b, a).rotate(HALF_PI).add(mid);
        return new PVector[]{mid, p};
    }

    public PVector intersection(PVector[] a, PVector[] b) {
        float x1 = a[0].x;
        float y1 = a[0].y;
        float x2 = a[1].x;
        float y2 = a[1].y;
        float x3 = b[0].x;
        float y3 = b[0].y;
        float x4 = b[1].x;
        float y4 = b[1].y;

        float denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        float x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / denominator;
        float y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / denominator;

        return new PVector(x, y);
    }
}
