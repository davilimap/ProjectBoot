/*
 * Class for handling database access
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**
 *
 * @author Davi
 */

public class DatabaseHandle {

    private String host;
    private String uName;
    private String uPass;

    public DatabaseHandle() {
        host = "jdbc:derby://localhost:1527/ProjectBoot";
        uName = "boot";
        uPass = "prjb";
    }

    public HyperLink[] getAllLinks() {
        return getLinksByName("");
    }
    
    private int getCountByName(String nameSearch) {
        int count;

        try (Connection con = DriverManager.getConnection(host, uName, uPass)) {
            Statement stmtAll = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String getAll;
            ResultSet rsAll;
            if (nameSearch.isEmpty()) {
                getAll = "SELECT COUNT(*) AS rowcount FROM BOOT.TABELA_LINKS";
            } else {
                getAll = "SELECT COUNT(*) AS rowcount FROM BOOT.TABELA_LINKS WHERE LOWER(NOME_LINK) LIKE LOWER('%" + nameSearch + "%')";
            }
            rsAll = stmtAll.executeQuery(getAll);
            rsAll.next();
            count = rsAll.getInt("rowcount");
            rsAll.close();
        } catch (SQLException e) {
            count = -1;
        }
        return count;
    }
    
    public HyperLink[] getLinksByName(String nameSearch) {
        HyperLink[] allLinks;
        int count;
        try (Connection con = DriverManager.getConnection(host, uName, uPass)) {
            Statement stmtAll = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String getAll, getTags, getComments;
            ResultSet rsAll, rsTags, rsComments;
            count = getCountByName(nameSearch);
            if (nameSearch.isEmpty()) {
                getAll = "SELECT * FROM BOOT.TABELA_LINKS";
            } else {
                getAll = "SELECT * FROM BOOT.TABELA_LINKS WHERE LOWER(NOME_LINK) LIKE LOWER('%" + nameSearch + "%')";
            }
            rsAll = stmtAll.executeQuery(getAll);
            allLinks = new HyperLink[count];
            int i = 0;
            int id;
            String name;
            String adress;
            Date creation;
            Timestamp modification;
            Statement stmtTags;
            int tagsCount;
            String[] tags;
            Statement stmtComments;
            int commentsCount;
            String[] comments;
            while (rsAll.next()) {
                id = rsAll.getInt(1);
                name = rsAll.getString(2);
                adress = rsAll.getString(3);
                creation = new Date(rsAll.getTimestamp(4).getTime());
                modification = rsAll.getTimestamp(5);
                stmtTags = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                getTags = "SELECT COUNT(*) AS rowcount FROM BOOT.TAGS_POR_LINK WHERE LINK_KEY = " + id;
                rsTags = stmtTags.executeQuery(getTags);
                rsTags.next();
                tagsCount = rsTags.getInt("rowcount");
                rsTags.close();

                tags = new String[tagsCount];

                getTags = "SELECT TABELA_TAGS.NOME_TAG FROM BOOT.TAGS_POR_LINK INNER JOIN TABELA_TAGS ON TAGS_POR_LINK.TAG_KEY = TABELA_TAGS.ID_TAG WHERE TAGS_POR_LINK.LINK_KEY = " + id;
                rsTags = stmtTags.executeQuery(getTags);

                int iT = 0;
                while (rsTags.next()) {
                    tags[iT] = rsTags.getString(1);
                    iT++;
                }

                stmtComments = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                getComments = "SELECT COUNT(*) AS rowcount FROM BOOT.TABELA_COMENTARIOS WHERE LINK_KEY = " + id;
                rsComments = stmtComments.executeQuery(getComments);
                rsComments.next();
                commentsCount = rsComments.getInt("rowcount");
                rsComments.close();

                comments = new String[commentsCount];

                getComments = "SELECT TABELA_COMENTARIOS.TEXTO_COMENTARIO FROM BOOT.TABELA_COMENTARIOS WHERE TABELA_COMENTARIOS.LINK_KEY = " + id;
                rsComments = stmtComments.executeQuery(getComments);

                int iC = 0;
                while (rsComments.next()) {
                    comments[iC] = rsComments.getString(1);
                    iC++;
                }

                allLinks[i] = new HyperLink(id, name, adress, tags, comments, creation, (modification == null ? null : new Date(modification.getTime())));
                i++;
            }
        } catch (SQLException e) {
            allLinks = null;
        }
        return allLinks;
    }
    
    public HyperLink getLinkByID(int id) {
        HyperLink linkToGet = null;
        try {
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmtAll = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            String getAll, getTags, getComments;
            ResultSet rsAll, rsTags, rsComments;
            
            getAll = "SELECT * FROM BOOT.TABELA_LINKS WHERE ID_LINK = " + id;
                
            rsAll = stmtAll.executeQuery(getAll);
            
            String name;
            String adress;
            Date creation;
            Timestamp modification;
            Statement stmtTags;
            int tagsCount;
            String[] tags;
            Statement stmtComments;
            int commentsCount;
            String[] comments;
            if(rsAll.next()) {
                id = rsAll.getInt(1);
                name = rsAll.getString(2);
                adress = rsAll.getString(3);
                creation = new Date(rsAll.getTimestamp(4).getTime());
                modification = rsAll.getTimestamp(5);
                stmtTags = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                getTags = "SELECT COUNT(*) AS rowcount FROM BOOT.TAGS_POR_LINK WHERE LINK_KEY = " + id;
                rsTags = stmtTags.executeQuery(getTags);
                rsTags.next();
                tagsCount = rsTags.getInt("rowcount");
                rsTags.close();
                
                tags = new String[tagsCount];
                
                getTags = "SELECT TABELA_TAGS.NOME_TAG FROM BOOT.TAGS_POR_LINK INNER JOIN TABELA_TAGS ON TAGS_POR_LINK.TAG_KEY = TABELA_TAGS.ID_TAG WHERE TAGS_POR_LINK.LINK_KEY = " + id;
                rsTags = stmtTags.executeQuery(getTags);
                
                int iT = 0;
                while(rsTags.next()) {
                    tags[iT] = rsTags.getString(1);
                    iT++;
                }
                
                stmtComments = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                getComments = "SELECT COUNT(*) AS rowcount FROM BOOT.TABELA_COMENTARIOS WHERE LINK_KEY = " + id;
                rsComments = stmtComments.executeQuery(getComments);
                rsComments.next();
                commentsCount = rsComments.getInt("rowcount");
                rsComments.close();
                
                comments = new String[commentsCount];
                
                getComments = "SELECT TABELA_COMENTARIOS.TEXTO_COMENTARIO FROM BOOT.TABELA_COMENTARIOS WHERE TABELA_COMENTARIOS.LINK_KEY = " + id;
                rsComments = stmtComments.executeQuery(getComments);
                
                int iC = 0;
                while(rsComments.next()) {
                    comments[iC] = rsComments.getString(1);
                    iC++;
                }
                
                linkToGet = new HyperLink(id, name, adress, tags, comments, creation, (modification == null? null: new Date(modification.getTime())));
            }
            con.close();
        } catch (SQLException e) {
            linkToGet = null;
        }
        return linkToGet;
    }
    
    public Map getMapTags() {
        Map<String, Integer> tags = new HashMap<>();
        
        try {
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmtAll = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            String getAll = "SELECT * FROM BOOT.TABELA_TAGS";
            ResultSet rsAll = stmtAll.executeQuery(getAll);
            
            int id;
            String name;
            while(rsAll.next()) {
                id = rsAll.getInt(1);
                name = rsAll.getString(2);
                tags.put(name, id);
            }
            con.close();
        } catch (SQLException e) {
            tags = null;
        }
        
        return tags;
    }
    
    private int getCountByTags(ArrayList<Integer> tags) {
        int count;
        try (Connection con = DriverManager.getConnection(host, uName, uPass)) {
            Statement stmtAll = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String getAll;
            ResultSet rsAll;

            getAll = "SELECT COUNT(*) AS rowcount FROM BOOT.TABELA_LINKS INNER JOIN BOOT.TAGS_POR_LINK ON TABELA_LINKS.ID_LINK = TAGS_POR_LINK.LINK_KEY WHERE ";
            int i = 0;
            for (Integer tag : tags) {
                getAll = getAll + "TAGS_POR_LINK.TAG_KEY = " + tag;
                i++;
                if (i < tags.size()) {
                    getAll = getAll + " OR ";
                }
            }

            rsAll = stmtAll.executeQuery(getAll);
            rsAll.next();
            count = rsAll.getInt(1);
            rsAll.close();
        } catch (SQLException e) {
            count = -1;
        }
        return count;
    }
    
    public HyperLink[] getLinksByTags(ArrayList<Integer> tagsToFilter) {
        HyperLink[] allLinks;
        int count;
        try (Connection con = DriverManager.getConnection(host, uName, uPass)) {
            Statement stmtAll = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String getAll, getTags, getComments;
            ResultSet rsAll, rsTags, rsComments;
            count = getCountByTags(tagsToFilter);
            getAll = "SELECT * FROM BOOT.TABELA_LINKS INNER JOIN BOOT.TAGS_POR_LINK ON TABELA_LINKS.ID_LINK = TAGS_POR_LINK.LINK_KEY WHERE ";
            int i = 0;
            for (Integer tag : tagsToFilter) {
                getAll = getAll + "TAGS_POR_LINK.TAG_KEY = " + tag;
                i++;
                if (i < tagsToFilter.size()) {
                    getAll = getAll + " OR ";
                }
            }
            rsAll = stmtAll.executeQuery(getAll);
            allLinks = new HyperLink[count];
            int j = 0;
            int id;
            String name;
            String adress;
            Date creation;
            Date modification;
            Statement stmtTags;
            int tagsCount;
            String[] tags;
            Statement stmtComments;
            int commentsCount;
            String[] comments;
            while (rsAll.next()) {
                id = rsAll.getInt(1);
                name = rsAll.getString(2);
                adress = rsAll.getString(3);
                creation = new Date(rsAll.getTimestamp(4).getTime());
                modification = new Date(rsAll.getTimestamp(5).getTime());

                stmtTags = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                getTags = "SELECT COUNT(*) AS rowcount FROM BOOT.TAGS_POR_LINK WHERE LINK_KEY = " + id;
                rsTags = stmtTags.executeQuery(getTags);
                rsTags.next();
                tagsCount = rsTags.getInt("rowcount");
                rsTags.close();

                tags = new String[tagsCount];

                getTags = "SELECT TABELA_TAGS.NOME_TAG FROM BOOT.TAGS_POR_LINK INNER JOIN TABELA_TAGS ON TAGS_POR_LINK.TAG_KEY = TABELA_TAGS.ID_TAG WHERE TAGS_POR_LINK.LINK_KEY = " + id;
                rsTags = stmtTags.executeQuery(getTags);

                int iT = 0;
                while (rsTags.next()) {
                    tags[iT] = rsTags.getString(1);
                    iT++;
                }

                stmtComments = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                getComments = "SELECT COUNT(*) AS rowcount FROM BOOT.TABELA_COMENTARIOS WHERE LINK_KEY = " + id;
                rsComments = stmtComments.executeQuery(getComments);
                rsComments.next();
                commentsCount = rsComments.getInt("rowcount");
                rsComments.close();

                comments = new String[commentsCount];

                getComments = "SELECT TABELA_COMENTARIOS.TEXTO_COMENTARIO FROM BOOT.TABELA_COMENTARIOS WHERE TABELA_COMENTARIOS.LINK_KEY = " + id;
                rsComments = stmtComments.executeQuery(getComments);

                int iC = 0;
                while (rsComments.next()) {
                    comments[iC] = rsComments.getString(1);
                    iC++;
                }

                allLinks[j] = new HyperLink(id, name, adress, tags, comments, creation, modification);
                j++;
            }
        } catch (SQLException e) {
            allLinks = null;
        }
        return allLinks;
    }
    
    public Map getTagsByID(ArrayList<Integer> tagsToFilter) {
        Map<String, Integer> tags = new HashMap<>();
        try (Connection con = DriverManager.getConnection(host, uName, uPass)) {
            Statement stmtAll = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String getAll = "SELECT * FROM BOOT.TABELA_TAGS WHERE ";
            int i = 0;
            for (Integer tag : tagsToFilter) {
                getAll = getAll + "ID_TAG = " + tag;
                i++;
                if (i < tagsToFilter.size()) {
                    getAll = getAll + " OR ";
                }
            }

            ResultSet rsAll = stmtAll.executeQuery(getAll);

            int id;
            String name;
            while (rsAll.next()) {
                id = rsAll.getInt(1);
                name = rsAll.getString(2);
                tags.put(name, id);
            }
        } catch (SQLException e) {
            tags = null;
        }

        return tags;
    }
    
    private void saveComment(int LinkID, String comment) throws SQLException {
        Connection con = DriverManager.getConnection(host, uName, uPass);
        Statement stmtAll = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String getAll = "SELECT * FROM BOOT.TABELA_COMENTARIOS";
        ResultSet rs = stmtAll.executeQuery(getAll);

        int id = 1;
        if (rs.last()) {
            id = rs.getInt(1) + 1;
        }

        rs.moveToInsertRow();

        rs.updateInt(1, id);
        rs.updateInt(2, LinkID);
        rs.updateString(3, comment);

        rs.insertRow();

        stmtAll.close();
        rs.close();
    }
    
    private int saveTag(String tag) throws SQLException {
        Connection con = DriverManager.getConnection(host, uName, uPass);
        Statement stmtAll = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String getAll = "SELECT * FROM BOOT.TABELA_TAGS WHERE LOWER(NOME_TAG) = LOWER('" + tag + "')";
        ResultSet rs = stmtAll.executeQuery(getAll);

        int id = -1;
        boolean exists;
        if (rs.next()) {
            id = rs.getInt(1);
            exists = true;
        } else {
            exists = false;
        }

        stmtAll.close();
        rs.close();
        
        if(!exists) {
            id = insertTag(tag);
        }

        return id;
    }
    
    private int getTagID(String tag) throws SQLException {
        Connection con = DriverManager.getConnection(host, uName, uPass);
        Statement stmtAll = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String getAll = "SELECT * FROM BOOT.TABELA_TAGS WHERE LOWER(NOME_TAG) = LOWER('" + tag + "')";
        ResultSet rs = stmtAll.executeQuery(getAll);

        int id = -1;
        if (rs.next()) {
            id = rs.getInt(1);
        }
        
        stmtAll.close();
        rs.close();

        return id;
    }
    
    private int insertTag(String tag) {
        int id = 1;
        try(Connection con = DriverManager.getConnection(host, uName, uPass)) {
            Statement stmtAll = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String getAll = "SELECT * FROM BOOT.TABELA_TAGS";
            ResultSet rs = stmtAll.executeQuery(getAll);
            
            if(rs.last())
                id = rs.getInt(1) + 1;
            
            rs.moveToInsertRow();
            
            rs.updateInt(1, id);
            rs.updateString(2, tag);
            
            rs.insertRow();
            
            stmtAll.close();
            rs.close();
            
        } catch(SQLException e) {
            id = -1;
        }
        return id;
    }
    
    private void insertTagLink(int LinkID, int TagID) throws SQLException {
        Connection con = DriverManager.getConnection(host, uName, uPass);
        Statement stmtAll = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String getAll = "SELECT * FROM BOOT.TAGS_POR_LINK";
        ResultSet rs = stmtAll.executeQuery(getAll);

        int id = 1;
        if (rs.last()) {
            id = rs.getInt(1) + 1;
        }

        rs.moveToInsertRow();

        rs.updateInt("ID_TAG_LINK", id);
        rs.updateInt("TAG_KEY", TagID);
        rs.updateInt("LINK_KEY", LinkID);

        rs.insertRow();

        stmtAll.close();
        rs.close();
    }
    
    public void saveNewLink(HyperLink linkToAdd) {
        try {
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmtAll = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String getAll = "SELECT * FROM BOOT.TABELA_LINKS";
            ResultSet rs = stmtAll.executeQuery(getAll);
            
            int id = 1;
            if(rs.last())
                id = rs.getInt(1) + 1;
            
            rs.moveToInsertRow();
            
            rs.updateInt(1, id);
            rs.updateString(2, linkToAdd.getName());
            rs.updateString(3, linkToAdd.getURL());
            rs.updateTimestamp(4, new Timestamp(linkToAdd.getCreation().getTime()));
            rs.updateTimestamp(5, null);
            
            rs.insertRow();
            
            stmtAll.close();
            rs.close();
            
            for(String comment:linkToAdd.getComments()) {
                if(!comment.isEmpty()) {
                    saveComment(id, comment);
                }
            }
            
            int TagID;
            for(String tag:linkToAdd.getTags()) {
                if(!tag.isEmpty()) {
                    TagID = saveTag(tag);
                    insertTagLink(id, TagID);
                }
            }
            
        } catch(SQLException e) {
            //TO DO: Handle exception.
        }
    }
    
    private void deleteTagLink(int linkID, int tagID) throws SQLException {
        Connection con = DriverManager.getConnection(host, uName, uPass);
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String get = "SELECT * FROM BOOT.TAGS_POR_LINK WHERE LINK_KEY = " + linkID + " AND TAG_KEY = " + tagID;
        ResultSet rs = stmt.executeQuery(get);

        if (rs.last()) {
            rs.deleteRow();
        }
        
        stmt.close();
        rs.close();
    }
    
    private void deleteComment (int linkID, String comment) throws SQLException {
        Connection con = DriverManager.getConnection(host, uName, uPass);
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String get = "SELECT * FROM BOOT.TABELA_COMENTARIOS WHERE LINK_KEY = " + linkID + " AND TEXTO_COMENTARIO = '" + comment +"'";
        ResultSet rs = stmt.executeQuery(get);

        if (rs.last()) {
            rs.deleteRow();
        }
        
        stmt.close();
        rs.close();
    }
    
    public void alterLink (HyperLink linkToAlter, ArrayList<String> tagsToRemove, ArrayList<String> commentsToRemove) {
        try {
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmtLink = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String getLink = "SELECT * FROM BOOT.TABELA_LINKS WHERE ID_LINK = " + linkToAlter.getID();
            ResultSet rsLink = stmtLink.executeQuery(getLink);
            
            if(rsLink.next()) {
                rsLink.updateString(2, linkToAlter.getName());
                rsLink.updateString(3, linkToAlter.getURL());
                rsLink.updateTimestamp(5, new Timestamp(new Date().getTime()));
                rsLink.updateRow();
            }
            
            stmtLink.close();
            rsLink.close();
            con.close();
            
            for(String comment:linkToAlter.getComments()) {
                if(!comment.isEmpty()) {
                    saveComment(linkToAlter.getID(), comment);
                }
            }
            
            int TagID;
            for (String tag : linkToAlter.getTags()) {
                if (!tag.isEmpty()) {
                    TagID = saveTag(tag);
                    insertTagLink(linkToAlter.getID(), TagID);
                }
            }

            for (String tag : tagsToRemove) {
                TagID = getTagID(tag);
                if(TagID > 0) {
                    deleteTagLink(linkToAlter.getID(), TagID);
                }
            }

            for (String comment : commentsToRemove) {
                deleteComment(linkToAlter.getID(), comment);
            }
            
        } catch(SQLException e) {
        }
    }
    
    private void deleteCommentByLink(int LinkID) throws SQLException {
        Connection con = DriverManager.getConnection(host, uName, uPass);
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String get = "SELECT * FROM BOOT.TABELA_COMENTARIOS WHERE LINK_KEY = " + LinkID;
        ResultSet rs = stmt.executeQuery(get);

        while (rs.next()) {
            rs.deleteRow();
        }
        
        stmt.close();
        rs.close();
    }
    
    private void deleteTagLinkByLink(int LinkID) throws SQLException {
        Connection con = DriverManager.getConnection(host, uName, uPass);
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String get = "SELECT * FROM BOOT.TAGS_POR_LINK WHERE LINK_KEY = " + LinkID;
        ResultSet rs = stmt.executeQuery(get);

        while (rs.next()) {
            rs.deleteRow();
        }
        
        stmt.close();
        rs.close();
    }
    
    public void deleteLink(int id) {
        try {
            deleteCommentByLink(id);
            deleteTagLinkByLink(id);
            
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String get = "SELECT * FROM BOOT.TABELA_LINKS WHERE ID_LINK = " + id;
            ResultSet rs = stmt.executeQuery(get);

            if (rs.last()) {
                rs.deleteRow();
            }

            stmt.close();
            rs.close();

        } catch (SQLException e) {

        }
    }
    
    private void deleteTagLinkByTag(int TagID) throws SQLException {
        Connection con = DriverManager.getConnection(host, uName, uPass);
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String get = "SELECT * FROM BOOT.TAGS_POR_LINK WHERE TAG_KEY = " + TagID;
        ResultSet rs = stmt.executeQuery(get);

        while (rs.next()) {
            rs.deleteRow();
        }
        
        stmt.close();
        rs.close();
    }
    
    public void deleteTag(int id) {
        try {
            deleteTagLinkByTag(id);
            
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String get = "SELECT * FROM BOOT.TABELA_TAGS WHERE ID_TAG = " + id;
            ResultSet rs = stmt.executeQuery(get);

            if (rs.last()) {
                rs.deleteRow();
            }

            stmt.close();
            rs.close();

        } catch (SQLException e) {
        }
    }
    
    //TO DO: Save space by not repeating calling code for hyperlinks
}
