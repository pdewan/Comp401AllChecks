package grail.mvc.view;

import java.awt.Graphics2D;
import java.awt.Toolkit;

import grail.interfaces.AvatarInterface;
import grail.interfaces.BoundedShapeInterface;
import grail.interfaces.ImageInterface;
import grail.interfaces.RotatingLineInterface;
import grail.interfaces.StringShapeInterface;
import grail.interfaces.VShapeInterface;

public class PaintingSupport {
	
	public static void paintRectangle(Graphics2D g, BoundedShapeInterface shape){
		g.drawRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
	}
	
	public static void paintOval(Graphics2D g, BoundedShapeInterface shape){
		g.drawOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
	}
	
	public static void paintStringShape(Graphics2D g, StringShapeInterface shape){
		g.drawString(shape.getText(), shape.getX(), shape.getY());
	}
	
	public static void paintImage(Graphics2D g, ImageInterface shape){
		g.drawImage(Toolkit.getDefaultToolkit().getImage(shape.getImageFileName()),
				shape.getX(), shape.getY(), null);
	}
	
	public static void paintLine(Graphics2D g, RotatingLineInterface line){
		g.drawLine(line.getX(), line.getY(), line.getX() + line.getWidth(), line.getY()+line.getHeight());
	}
	
	public static void paintVShape(Graphics2D g, VShapeInterface shape){
		paintLine(g, shape.getLeftLine());
		paintLine(g, shape.getRightLine());
	}
	
	public static void paintAvatar(Graphics2D g, AvatarInterface avatar){
		paintImage(g, avatar.getHead());
		paintLine(g, avatar.getTorso());
		paintStringShape(g, avatar.getStringShape());
		paintVShape(g, avatar.getArms());
		paintVShape(g, avatar.getLegs());
	}
}
