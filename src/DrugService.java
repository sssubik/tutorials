
import com.model.DrugModel;
import com.repository.RepositoryClass;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Subik
 */
public class DrugService {

    public void insert(amedicine_jpanel A) {
        DrugModel model = CTModel(A);
        RepositoryClass Rc = new RepositoryClass();
        Rc.insertDrug(model);
    }
    public DrugModel CTModel(amedicine_jpanel A)
    {
        DrugModel model = new DrugModel();
        model.setDrugName(A.getTextName().getText());
        model.setCost(Integer.parseInt(A.getTextCost().getText()));
        model.setStock(Integer.parseInt(A.getTextStock().getText()));
        model.setRegDate(A.getTextRegDate().getText());
        
      
        return model;
    }
}
