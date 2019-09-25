package services;

import modeles.Employe;
import modeles.Service;
import modeles.Users;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Employedao {
    public List<Service> findServices(){
        List<Service> services = new ArrayList<>();
            try {
                String sql = "SELECT * FROM service";
                DatabaseHelper db = DatabaseHelper.getInstance();

                ResultSet rs = db.My_ExecuteQuery(sql);
                while (rs.next()){
                    Service s = new Service();
                    s.setId(rs.getInt(1));
                    s.setLibelle(rs.getString(2));
                    services.add(s);
                }
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            return services;
    }
}
