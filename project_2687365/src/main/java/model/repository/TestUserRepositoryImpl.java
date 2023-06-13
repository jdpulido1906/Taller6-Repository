package co.edu.sena.project_2687365.repository;

import model.User;

import java.sql.SQLException;


public class TestUserRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        Repository<User> repository = new UserRepositoryImpl();

        System.out.println("========saveObj Insert===========");
        User userInsert1 = new User();
        userInsert1.setUser_fistname("Jairo");
        userInsert1.setUser_lastname("Hernandez");
        userInsert1.setUser_email("jairo14@mail.com");
        userInsert1.setUser_password("jairo12");
        repository.saveObj(userInsert1);

        User userInsert2 = new User();
        userInsert2.setUser_fistname("Camilo");
        userInsert2.setUser_lastname("Hernandez");
        userInsert2.setUser_email("camilo18@mail.com");
        userInsert2.setUser_password("camilo142");
        repository.saveObj(userInsert2);


        System.out.println("========== listaObj =========");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== byIdObj ===========");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("============== saveObj ===========");
        User userUpdate = new User();
        userUpdate.setUser_fistname("Andrea");
        userUpdate.setUser_lastname("Ramos");
        userUpdate.setUser_email("Randrea12@mail.com");
        userUpdate.setUser_password("andrea12");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== deleteObj ============");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);

    }
}
