/*
 * Class that represents a HyperLink, which includes methods for acessing their variables
 */
package Classes;

import java.util.Date;

/**
 *
 * @author Davi
 */
public class HyperLink {
    
    private final int id; //Database ID for that link
    private final String name; //Name of the link
    private final String url; //Link URL
    private final String[] tags; //Tags associated with the link
    private final String[] comments; //Comments associated with the link
    private final Date creation; //The date the link was created
    private final Date modification; //The date of the last modification

    //Constructor for the class, which gets all the fields for the class
    public HyperLink(int i, String nm, String u, String[] tgs, String[] com, Date cr, Date mod) {
        this.id = i;
        this.name = nm;
        this.url = u;
        this.tags = tgs;
        this.comments = com;
        this.creation = cr;
        this.modification = mod;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Get Methods">
    public int getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getURL() {
        return this.url;
    }
    public String[] getTags() {
        return this.tags;
    }
    public String[] getComments() {
        return this.comments;
    }
    public Date getCreation() {
        return this.creation;
    }
    public Date getModification() {
        return this.modification;
    }
    // </editor-fold>
    
    //Returns the creation date in the form of a string
    public String getCreationString() {
         return creation == null? "": creation.toString();
    }
    
    //Returns the last modification date in the form of a string
    public String getModificationString() {
         return modification == null? "": modification.toString();
    }

    //Returns a string with all of the tags separated by a comma(,)
    public String getAllTags() {
        String allTags = "";
        for(int i = 0; i < this.tags.length; i++) {
            allTags =  allTags + this.tags[i];
            if(i < this.tags.length - 1) {
                allTags =  allTags + ", ";
            }
        }
       return allTags;
    }
    
    //Returns a string with all of the comments separa
    public String getAllComments() {
        String allComments = "";
        String newline = System.getProperty("line.separator");
        for(int i = 0; i < this.comments.length; i++) {
            allComments =  allComments + this.comments[i];
            if(i < this.comments.length - 1) {
                allComments =  allComments + " " + newline;
            }
        }
       return allComments; 
    }
}
