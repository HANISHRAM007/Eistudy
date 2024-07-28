// Implementor Interface
interface DrawAPI {
    void drawCircle(int radius, int x, int y);
    void drawRectangle(int width, int height, int x, int y);
}

// Concrete Implementors
class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", y: " + y + "]");
    }

    @Override
    public void drawRectangle(int width, int height, int x, int y) {
        // Not applicable for this implementation
    }
}

class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", y: " + y + "]");
    }

    @Override
    public void drawRectangle(int width, int height, int x, int y) {
        // Not applicable for this implementation
    }
}

class BlueRectangle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        // Not applicable for this implementation
    }

    @Override
    public void drawRectangle(int width, int height, int x, int y) {
        System.out.println("Drawing Rectangle[ color: blue, width: " + width + ", height: " + height + ", x: " + x + ", y: " + y + "]");
    }
}

class YellowRectangle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        // Not applicable for this implementation
    }

    @Override
    public void drawRectangle(int width, int height, int x, int y) {
        System.out.println("Drawing Rectangle[ color: yellow, width: " + width + ", height: " + height + ", x: " + x + ", y: " + y + "]");
    }
}

// Abstraction
abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}

// Refined Abstraction
class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}

class Rectangle extends Shape {
    private int x, y, width, height;

    public Rectangle(int x, int y, int width, int height, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        drawAPI.drawRectangle(width, height, x, y);
    }
}

// Client
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());
        Shape blueRectangle = new Rectangle(200, 200, 50, 30, new BlueRectangle());
        Shape yellowRectangle = new Rectangle(200, 200, 50, 30, new YellowRectangle());

        redCircle.draw();
        greenCircle.draw();
        blueRectangle.draw();
        yellowRectangle.draw();
    }
}
