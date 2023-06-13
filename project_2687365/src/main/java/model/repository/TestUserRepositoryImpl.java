package co.edu.sena.project_2687365.model.repository;

import co.edu.sena.project_2687365.model.beans.User;

import java.sql.SQLException;


public class TestUserRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        co.edu.sena.project_2687365.model.repository.Repository<User> repository = new UserRepositoryImpl();

        System.out.println("========saveObj Insert===========");
        User userInsert1 = new User();
        userInsert1.setUser_firstname("jose");
        userInsert1.setUser_lastname("perez");
        userInsert1.setUser_email("perez@gmail.com");
        userInsert1.setUser_password("jose12");
        repository.saveObj(userInsert1);

        User userInsert2 = new User();
        userInsert2.setUser_firstname("michel");
        userInsert2.setUser_lastname("laiton");
        userInsert2.setUser_email("michel12@gmail.com");
        userInsert2.setUser_password("michell23");
        repository.saveObj(userInsert2);


        System.out.println("========== listaObj =========");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== byIdObj ===========");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("============== saveObj ===========");
        User userUpdate = new User();
        userUpdate.setUser_firstname("Fabian");
        userUpdate.setUser_lastname("lopez");
        userUpdate.setUser_email("fabian12@gmail.com");
        userUpdate.setUser_password("fabiana12");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== deleteObj ============");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);

    }
}

