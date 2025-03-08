package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class GradientPanel extends JPanel { // Renommé correctement
    private Color color1 = Color.BLACK;
    private Color color2 = new Color(102, 0, 0);

    public GradientPanel() {
        setOpaque(false); // IMPORTANT pour bien afficher le dégradé !
    }

    public GradientPanel(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
        setOpaque(false); // Toujours désactiver l'opacité par défaut
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dégradé vertical
        GradientPaint gradient = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Effet de lumière
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
    }

    public void setColors(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
        repaint(); // Redessine le panel après un changement de couleur
    }
}
