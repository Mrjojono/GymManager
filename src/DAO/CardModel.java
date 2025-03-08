/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.Icon;

/**
 *
 * @author joan
 */
public class CardModel {
    
   private Icon icon;
   private String title;
   private int values;
   private String description;

   
   
   public CardModel(Icon icon, String title, int actifs, String description) {
        this.icon = icon;
        this.title = title;
        this.values = actifs;
        this.description = description;
    }
   
   public CardModel(){
       
   }
   
   
    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }

   
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
