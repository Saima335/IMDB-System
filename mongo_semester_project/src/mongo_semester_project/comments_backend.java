/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo_semester_project;

import com.mongodb.*;
import org.bson.types.ObjectId;
public class comments_backend {
    public  static String movie_id(String title){
        String id="";
        try {
            MongoClient mongoclient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB mydb = mongoclient.getDB("testdb");
            DBCollection mycollection = mydb.getCollection("movies");
            BasicDBObject query = new BasicDBObject("title", title);
            DBCursor cursor1 = mycollection.find(query);
            while (cursor1.hasNext())
            {
                DBObject document = cursor1.next();
                return String.valueOf(document.get("_id"));
            }
        }
        catch (Exception e)
        {
        }
        return id;
    }

    

   public static String  comments(String id){
        String comment="";
        try {
            MongoClient mongoclient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB mydb = mongoclient.getDB("testdb");
            DBCollection mycollection = mydb.getCollection("commentss");
            BasicDBObject query = new BasicDBObject("movie_id",new ObjectId( id));
            DBCursor cursor1 = mycollection.find(query);
            int c=1;
            while (cursor1.hasNext())
            {
                System.out.println("hr");
                DBObject document = cursor1.next();
                comment+= c+".\n"+ String.valueOf(document.get("text"))+"\nComment by -"+document.get("name")+"\n"+"----------" +
                        "--------------------------------" +
                        "------------------------------------------------------------\n";
                c++;
                
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        if (comment.equals(""))
            return "no comments for this movie";
        return comment;
    }
}