package di02;

import java.util.ArrayList;
import java.util.List;


public class SearchEngine implements ISearchEngine {
    
    @Override
    public List<Document> findByType(Type documentType) {
        List<Document> result = storage();
        
        return result;
    }
    
    @Override
    public List<Document> listAll() {
        return storage();
    }
    

    private List<Document> storage() {
        List<Document> result = new ArrayList<Document>();
        Type pdfType = new Type();
        pdfType.setName("PDF");
        pdfType.setDesc("Portable Document");
        pdfType.setExtension(".pdf");
        
        Type webType = new Type("WEB", "WEB link", ".url");
        
        Document doc1 = new Document();
        doc1.setLocation("/book/Book.pdf");
        doc1.setName("Book");
        doc1.setType(pdfType);
        
        result.add(doc1);
        
        Document doc2 = new Document();
        doc1.setLocation("/book/Sample.pdf");
        doc1.setName("Sample");
        doc1.setType(pdfType);
        
        result.add(doc2);
        
        return result;
    }

}
