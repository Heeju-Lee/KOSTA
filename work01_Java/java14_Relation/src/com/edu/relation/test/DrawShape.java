package com.edu.relation.test;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class DrawShape extends Frame{
	public static void main(String[] args) {		
		DrawShape win = new DrawShape("도형 그리기");
	}	
	public void paint(Graphics g){
		Point[ ] p = {new Point(100,100),
				new Point(140,50),
				new Point(200,100)
				
		};
		Triangle t = new Triangle(p);
		Circle c = new Circle(new Point(150,150), 50);
		
		g.drawOval(c.center.x,c.center.y, c.r, c.r);
		
		g.drawLine(t.p[0].x,t.p[0].y, t.p[1].x, t.p[1].y);
		g.drawLine(t.p[1].x,t.p[1].y, t.p[2].x, t.p[2].y);
		g.drawLine(t.p[2].x,t.p[2].y, t.p[0].x, t.p[0].y);
	}
	
	public DrawShape(String title) {
		super(title);
		setSize(500,300);//Frame
		setBackground(Color.PINK);
		setVisible(true);//Frame
	}
}

class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Point() {
		this(0,0);
		
	}	
}

class Circle{
	Point center;//사용하는 측면에서 상속도 가능하나 설계상으로 명료하지 않음.
	int r;
	
	public Circle() {
		this(new Point(0, 0), 100);
	}
	
	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}	
}

class Triangle{
	Point[ ] p = new Point[3];

	public Triangle(Point[] p) {
		super();
		this.p = p;
	}
	public Triangle(Point p1,Point p2,Point p3 ) {
		p[0] = p1;
		p[1] = p2;
		p[2] = p3;
	}	
}






