package MongoDBPOC;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;  
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.DropIndexOptions;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.InsertOneOptions;

import org.bson.Document; 

public class MongoDB {

	public static void main(String[] args){  
		try{  
			//---------- Connecting DataBase -------------------------//  
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );  
			//---------- Creating DataBase ---------------------------//  
			MongoDatabase db = mongoClient.getDatabase("javatpoint");  
			//---------- Creating Collection -------------------------//  
			MongoCollection<Document> table = db.getCollection("employee");  
			//---------- Creating Document ---------------------------//   
			Document doc = new Document("id",13);  
//			doc.append("id",13);  
//			InsertOneOptions options = new InsertOneOptions();
//			options.
//			IndexOptions indexOptions = new IndexOptions().unique(true);
//			table.createIndex(Indexes.ascending("name", "id"), indexOptions);
//			table.insertOne(doc); 
			FindIterable<Document> res = table.find(doc);
			System.out.println(res.iterator().next().get("id") + "| Name: "+ res.iterator().next().get("name"));
//			table.createIndex(doc, new IndexOptions().unique(true));
			//----------- Inserting Data ------------------------------//  
//			table.deleteMany(doc);
//			DropIndexOptions dio = new DropIndexOptions();
//			table.dropIndex(Indexes.ascending("name", "id"), dio);
//			System.out.println(table.getReadConcern());
		}catch(Exception e){  
			System.out.println(e);  
		}  
	}  

}
